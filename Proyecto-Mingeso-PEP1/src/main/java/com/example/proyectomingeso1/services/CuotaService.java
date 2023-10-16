package com.example.proyectomingeso1.services;

import com.example.proyectomingeso1.entities.CuotaEntity;
import com.example.proyectomingeso1.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CuotaService {
    @Autowired
    CuotaRepository cuotaRepository;
    @Autowired
    AdminService adminService;
    @Autowired
    EstudianteService estudianteService;

    public void guardarCuota(Integer nro_cuota, Double monto, String estado, String rut){
        CuotaEntity cuota = new CuotaEntity();
        cuota.setNumeroCuota(nro_cuota);
        cuota.setMontoCuota(monto);
        cuota.setEstado(estado);
        cuota.setRutEstudiante(rut);
        cuotaRepository.save(cuota);
    }

    public void generarCuotas(String rut){
        int cantCuotas = estudianteService.obtenerCantCuotas(rut);
        double monto = adminService.calcularValorPorCuota(estudianteService.findByRut(rut));
        if(Integer.toString(cantCuotas).equals("0")){
            guardarCuota(1,750000.0,"PAGADO",rut);
        }
        for (int i = 1; i <= cantCuotas; i = i + 1){
            guardarCuota(i,monto,"PENDIENTE",rut);
        }
    }

    public ArrayList<CuotaEntity> obtenerCuotasEstudiante(String rut) {
        return (ArrayList<CuotaEntity>) cuotaRepository.findCuotasEstudiante(rut);
    }

}
