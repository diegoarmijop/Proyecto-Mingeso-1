package com.example.proyectomingeso1.services;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import com.example.proyectomingeso1.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public void guardarEstudiante(String rut,  String apellidos, String nombres, String fechaNacimiento, String tipoColegioProcedencia, String nombreColegio, Integer anoEgresoColegio, String tipoPago){

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
}