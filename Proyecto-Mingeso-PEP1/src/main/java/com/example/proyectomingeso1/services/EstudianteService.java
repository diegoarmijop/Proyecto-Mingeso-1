package com.example.proyectomingeso1.services;

import com.example.proyectomingeso1.entities.CuotaEntity;
import com.example.proyectomingeso1.entities.EstudianteEntity;
import com.example.proyectomingeso1.entities.ResumenEstudiante;
import com.example.proyectomingeso1.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    @Lazy
    CuotaService cuotaService;
    @Autowired
    ExamenService examenService;


    public int findCantCuotas(String rut){return estudianteRepository.findCantCuotas(rut);}

    public EstudianteEntity findByRut(String rut){return estudianteRepository.findByRut(rut);}

    public ArrayList<EstudianteEntity> obtenerTodosLosEstudiantes(){
        return (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
    }


    //Calcula el descuento según el tipo de pago
    //CONTADO: 50% de descuento; caso contrario 0%
    public double calcularDescuentoPorTipoPago(EstudianteEntity estudiante){
        double descuentoPorTipoPago = 0;
        if(estudiante.getTipoPago().equals(0)){
            descuentoPorTipoPago = 0.5;
        }else{
            return descuentoPorTipoPago;
        }
        return descuentoPorTipoPago;
    }

    //Calcula el descuento según el tipo de colegio
    //MUNICIPAL: 20% de descuento
    //SUBVENCIONADO: 10% de descuento
    //PRIVADO: 0% de descuento
    public double calcularDescuentoPorTipoColegio(EstudianteEntity estudiante){
        double descuentoPorTipoColegio = 0;
        if(estudiante.getTipoColegioProcedencia() == "Municipal"){
            descuentoPorTipoColegio = 0.2;
        } else if (estudiante.getTipoColegioProcedencia() == "Subvencionado") {
            descuentoPorTipoColegio = 0.1;
        }else {
            return descuentoPorTipoColegio;
        }
        return descuentoPorTipoColegio;
    }

    public double calcularDescuentoPorAñosDeEgreso(EstudianteEntity estudiante){
        int cantidadAñosDeEgreso = LocalDateTime.now().getYear() - estudiante.getAnoEgresoColegio();
        double descuentoPorAñosDeEgreso = 0;
        if (cantidadAñosDeEgreso == 0){
            descuentoPorAñosDeEgreso = 0.15;
        } else if (cantidadAñosDeEgreso == 1 || cantidadAñosDeEgreso == 2) {
            descuentoPorAñosDeEgreso = 0.08;
        } else if (cantidadAñosDeEgreso == 3 || cantidadAñosDeEgreso == 4) {
            descuentoPorAñosDeEgreso = 0.04;
        } else {
            return descuentoPorAñosDeEgreso;
        }
        return descuentoPorAñosDeEgreso;
    }

    public double calcularValorPorCuota(EstudianteEntity estudiante){
        double descuentoTotal = calcularDescuentoPorTipoPago(estudiante) +
                calcularDescuentoPorTipoColegio(estudiante) + calcularDescuentoPorAñosDeEgreso(estudiante);
        double valorPorCuota = (1500000 - 1500000*descuentoTotal)/estudiante.getTipoPago();
        return valorPorCuota;
    }


    public void guardarEstudiante(String rut,  String apellidos, String nombres, String fechaNacimiento, String tipoColegioProcedencia, String nombreColegio, Integer anoEgresoColegio, Integer tipoPago){

        EstudianteEntity estudiante = new EstudianteEntity();

        estudiante.setRut(rut);
        estudiante.setApellidos(apellidos);
        estudiante.setNombres(nombres);
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setTipoColegioProcedencia(tipoColegioProcedencia);
        estudiante.setNombreColegio(nombreColegio);
        estudiante.setAnoEgresoColegio(anoEgresoColegio);
        estudiante.setTipoPago(tipoPago);
        estudianteRepository.save(estudiante);
    }

    public ResumenEstudiante generarResumen(String rut){

        ResumenEstudiante resumenEstudiante = new ResumenEstudiante();
        EstudianteEntity estudiante = findByRut(rut);
        List<CuotaEntity> cuotaEntities = cuotaService.obtenerCuotasEstudiante(rut);

        resumenEstudiante.setRut(estudiante.getRut());
        resumenEstudiante.setNombre(estudiante.getNombres());
        resumenEstudiante.setNumeroExamenesRendidos(examenService.obtenerNumeroExamenesRendidosPorRut(estudiante.getRut()));
        resumenEstudiante.setPromedioPuntajeExamenes(examenService.calcularPuntajePromedio(estudiante.getRut()));
        resumenEstudiante.setMontoTotalAPagar(MontoTotal(rut));
        resumenEstudiante.setTipoPago(tipoPago(estudiante));
        resumenEstudiante.setNumeroTotalCuotasPactadas(cuotaEntities.size());
        resumenEstudiante.setNumeroCuotasPagadas(1);
        resumenEstudiante.setMontoTotalPagado(70000.00);
        resumenEstudiante.setFechaUltimoPago("22");
        resumenEstudiante.setSaldoPorPagar(5.0);
        resumenEstudiante.setNumeroCuotasConRetraso(5L);

        return resumenEstudiante;

    }

    public String tipoPago(EstudianteEntity estudiante) {
        if (estudiante.getTipoPago() == 0) {
            return "CONTADO";
        } else {
            return "CUOTAS";
        }
    }


    public Double MontoTotal(String rut) {
        List<CuotaEntity> cuotas = cuotaService.obtenerCuotasEstudiante(rut);
        EstudianteEntity estudiante = findByRut(rut);
        Double puntajePromedio = examenService.calcularPuntajePromedio(estudiante.getRut());
        Double descuento = examenService.calcularDescuento(puntajePromedio);
        double[] MontoTotalArr = {0.0};

        cuotas.forEach(cuota -> {
            if (cuota.getEstado().equals("PENDIENTE")) {
                cuota.setMontoCuota(cuotaService.calcularInteres(cuota));
            }
            cuota.setMontoCuota(cuota.getMontoCuota() * (1 - descuento));
            MontoTotalArr[0] = MontoTotalArr[0] + cuota.getMontoCuota();
        });
        return MontoTotalArr[0];
    }

    public void eliminarEstudiante(String rut){
        EstudianteEntity estudiante = findByRut(rut);
        estudianteRepository.delete(estudiante);
    }

}
