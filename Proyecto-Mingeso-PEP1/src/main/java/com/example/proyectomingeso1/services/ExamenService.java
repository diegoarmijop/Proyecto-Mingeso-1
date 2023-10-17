package com.example.proyectomingeso1.services;

import com.example.proyectomingeso1.entities.ExamenEntity;
import com.example.proyectomingeso1.repositories.ExamenRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamenService {

    @Autowired
    ExamenRepository examenRepository;

    public ArrayList<ExamenEntity> obtenerData() { return (ArrayList<ExamenEntity>) examenRepository.findAll(); }

    private final Logger logg = LoggerFactory.getLogger(ExamenService.class);

    public void guardarExamen(String fecha_examen, String puntaje, String rut){
        ExamenEntity examen = new ExamenEntity();
        examen.setFecha_examen(fecha_examen);
        examen.setPuntaje(puntaje);
        examen.setRut(rut);
        examenRepository.save(examen);
    }

    @Generated
    public String guardar(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if (!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("Error",e);
                }
            }
            return "Archivo guardado exitosamente";
        }
        else {
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsv(String direccion){
        String texto = "";
        BufferedReader bf = null;
        examenRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarExamen(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public int obtenerNumeroExamenesRendidosPorRut(String rut) {
        return examenRepository.findByRut(rut).size();
    }

    public Double calcularPuntajePromedio(String rut) {
        List<ExamenEntity> examenes = examenRepository.findByRut(rut);
        if (examenes.isEmpty()) return 0.0;

        double suma = 0.0;
        for (ExamenEntity examen : examenes) {
            suma += Double.parseDouble(examen.getPuntaje());
        }
        return suma / examenes.size();
    }

    public Double calcularDescuento(Double puntajePromedio) {
        if (puntajePromedio >= 950 && puntajePromedio <= 1000) {
            return 0.10;
        } else if (puntajePromedio >= 900 && puntajePromedio < 950) {
            return 0.05;
        } else if (puntajePromedio >= 850 && puntajePromedio < 900) {
            return 0.02;
        } else {
            return 0.0;
        }
    }




}
