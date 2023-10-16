package com.example.proyectomingeso1.services;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import com.example.proyectomingeso1.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public boolean existeEstudiante(String rut){
        ArrayList<EstudianteEntity> estudiantes = (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
        boolean existe = false;
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getRut().equals(rut)){
                existe = true;
            }
        }
        return existe;
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

    public int obtenerCantCuotas(String rut){return estudianteRepository.findCantCuotas(rut);}

    public EstudianteEntity findByRut(String rut){return estudianteRepository.findByRut(rut);}

    public void eliminarEstudiante(String rut){
        EstudianteEntity estudiante = findByRut(rut);
        estudianteRepository.delete(estudiante);
    }

}