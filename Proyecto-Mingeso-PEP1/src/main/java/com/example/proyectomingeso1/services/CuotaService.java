package com.example.proyectomingeso1.services;


import com.example.proyectomingeso1.entities.CuotaEntity;
import com.example.proyectomingeso1.entities.EstudianteEntity;
import com.example.proyectomingeso1.repositories.CuotaRepository;
import com.example.proyectomingeso1.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class CuotaService {

    @Autowired
    CuotaRepository cuotaRepository;

    @Autowired
    @Lazy
    EstudianteService estudianteService;

    public ArrayList<CuotaEntity> obtenerCuotasEstudiante(String rut) {
        return (ArrayList<CuotaEntity>) cuotaRepository.findCuotasEstudiante(rut);
    }

    public void guardarCuota(Integer nro_cuota, Double monto, String estado, String rut, String fechaCuota){
        CuotaEntity cuota = new CuotaEntity();
        cuota.setNumeroCuota(nro_cuota);
        cuota.setMontoCuota(monto);
        cuota.setEstado(estado);
        cuota.setRutEstudiante(rut);
        cuota.setFechaCuota(fechaCuota);
        cuotaRepository.save(cuota);
    }

    public void generarCuotas(String rut){

        EstudianteEntity estudiante = estudianteService.findByRut(rut);

        int cantCuotas = estudianteService.findCantCuotas(rut);
        double monto = estudianteService.calcularValorPorCuota(estudiante);
        if(Integer.toString(cantCuotas).equals("0")){
            guardarCuota(1,750000.0,"PAGADO",rut, LocalDate.now().toString());
        }

        LocalDate fechaActual = LocalDate.now();

        for (int i = 1; i <= cantCuotas; i = i + 1){
            fechaActual = fechaActual.plusMonths(1).withDayOfMonth(5);
            guardarCuota(i,monto,"PENDIENTE",rut, fechaActual.toString());
        }
    }

    public Double calcularInteres(CuotaEntity cuota) {
        if (cuota.getEstado().equals("PENDIENTE")) {
            final double interes_1 = 0.03;
            final double interes_2 = 0.06;
            final double interes_3 = 0.09;
            final double interes_maximo = 0.15;

            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaVencimiento = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 5); // Establecer el día de vencimiento al 5 de cada mes

            if (fechaActual.isAfter(fechaVencimiento)) {
                fechaVencimiento = fechaVencimiento.plusMonths(1);
            }

            long atraso = ChronoUnit.MONTHS.between(fechaVencimiento, fechaActual);

            if (atraso <= 0) {
                return cuota.getMontoCuota();
            }
            if (atraso == 1) {
                double interes = cuota.getMontoCuota() * interes_1;
                return cuota.getMontoCuota() + interes;
            }
            if (atraso == 2) {
                double interes = cuota.getMontoCuota() * interes_2;
                return cuota.getMontoCuota() + interes;
            }
            if (atraso == 3) {
                double interes = cuota.getMontoCuota() * interes_3;
                return cuota.getMontoCuota() + interes;
            }

            double interes = cuota.getMontoCuota() * interes_maximo;
            return cuota.getMontoCuota() + interes;
        }
        return cuota.getMontoCuota();
    }



}

