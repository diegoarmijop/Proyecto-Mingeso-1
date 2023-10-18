package com.example.proyectomingeso1;


import com.example.proyectomingeso1.entities.CuotaEntity;
import com.example.proyectomingeso1.repositories.CuotaRepository;
import com.example.proyectomingeso1.services.CuotaService;
import com.example.proyectomingeso1.services.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

@SpringBootTest
public class CuotaTest {

    @Autowired
    CuotaService cuotaService;
    @Autowired
    CuotaRepository cuotaRepository;
    @Autowired
    EstudianteService estudianteService;

    @Test
    void guardarCuota(){
        cuotaService.guardarCuota(1,270000.0,"PENDIENTE","20533473-4", "18/05/2023");
        ArrayList<CuotaEntity> cuotas = (ArrayList<CuotaEntity>) cuotaRepository.findAll();
        CuotaEntity cuota = cuotas.get(cuotas.size()-1);

        assertEquals(cuota.getNumeroCuota(),1,0);
        assertEquals(cuota.getMontoCuota(),270000.0,0.0);
        assertEquals(cuota.getEstado(),"PENDIENTE");
        assertEquals(cuota.getRutEstudiante(),"20533473-4");
        assertEquals(cuota.getFechaCuota(),"18/05/2023");

        cuotaService.eliminarCuota(cuota);
    }

    /*@Test
    void generarCuotas(){
        estudianteService.guardarEstudiante("20534473-3","Vergara Torres",
                "Julieta Aneley", "9/9/2000","SUBVENCIONADO",
                "CNSC",2020,5);
        cuotaService.generarCuotas("20534473-3");
        ArrayList<CuotaEntity> cuotas = (ArrayList<CuotaEntity>) cuotaRepository.findAll();
        for (int i = 0; i < cuotas.size(); i++){
            if(cuotas.get(i).getRutEstudiante().equals("20534473-3")){
                assertEquals(i+1,cuotas.get(i).getNumeroCuota());
                assertEquals(258000,cuotas.get(i).getMontoCuota(),0.0);
                assertEquals("PENDIENTE",cuotas.get(i).getEstado());
                cuotaService.eliminarCuota(cuotas.get(i));
            }
        }
        estudianteService.eliminarEstudiante("20534473-3");
    }*/








}
