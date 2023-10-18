package com.example.proyectomingeso1;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import com.example.proyectomingeso1.repositories.EstudianteRepository;
import com.example.proyectomingeso1.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootTest
public class EstudianteTest {

    @Autowired
    EstudianteService estudianteService;
    @Autowired
    EstudianteRepository estudianteRepository;

    EstudianteEntity estudiante = new EstudianteEntity();

    @Test
    void guardarEstudiante(){

        estudianteService.guardarEstudiante("20223132-1", "Benavides Rojas", "Pablo Jose", "9/9/1999", "PRIVADO", "Centenario", 2020, 0);
        ArrayList<EstudianteEntity> estudiantes = (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
        estudiante = estudiantes.get(estudiantes.size()-1);
        assertEquals("20223132-1",estudiante.getRut());
        assertEquals("Benavides Rojas",estudiante.getApellidos());
        assertEquals("Pablo Jose",estudiante.getNombres());
        assertEquals("9/9/1999",estudiante.getFechaNacimiento());
        assertEquals("PRIVADO",estudiante.getTipoColegioProcedencia());
        assertEquals("Centenario",estudiante.getNombreColegio());
        assertEquals(2020,estudiante.getAnoEgresoColegio());
        assertEquals(0,estudiante.getTipoPago());
        estudianteService.eliminarEstudiante(estudiante.getRut());
    }

    @Test
    void obtenerCantCuotas(){
        estudianteService.guardarEstudiante("20223132-1", "Benavides Rojas", "Pablo Jose", "9/9/1999", "PRIVADO", "Centenario", 2020, 3);
        Integer cantCuotas = estudianteService.findCantCuotas("20223132-1");
        assertEquals(3,cantCuotas,0.0);
        estudianteService.eliminarEstudiante("20223132-1");
    }

    @Test
    void findByRut(){
        estudianteService.guardarEstudiante("20223132-1", "Benavides Rojas", "Pablo Jose", "9/9/1999", "PRIVADO", "Centenario", 2020, 3);
        estudiante = estudianteService.findByRut("20223132-1");
        assertEquals("20223132-1",estudiante.getRut());
        assertEquals("Benavides Rojas",estudiante.getApellidos());
        assertEquals("Pablo Jose",estudiante.getNombres());
        assertEquals("9/9/1999",estudiante.getFechaNacimiento());
        assertEquals("PRIVADO",estudiante.getTipoColegioProcedencia());
        assertEquals("Centenario",estudiante.getNombreColegio());
        assertEquals(2020,estudiante.getAnoEgresoColegio());
        assertEquals(3,estudiante.getTipoPago());
        estudianteService.eliminarEstudiante(estudiante.getRut());
    }

    @Test
    void calcularDescuentoPorPago(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFechaNacimiento("20/06/1999");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(0);

        double descuento = estudianteService.calcularDescuentoPorTipoPago(estudiante);
        assertEquals(0.5,descuento,0.0);
    }

    @Test
    void calcularDescuentoPorTipoColegio(){
        estudiante.setRut("20445431-1");
        estudiante.setNombres("Diego Armijo");
        estudiante.setApellidos("Palominos");
        estudiante.setFechaNacimiento("27/10/1999");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(0);

        double descuento = estudianteService.calcularDescuentoPorTipoColegio(estudiante);
        assertEquals(0,descuento,0.0);
    }

    @Test
    void calcularDescuentoPorAñosDeEgreso(){
        estudiante.setRut("20445431-1");
        estudiante.setNombres("Diego Armijo");
        estudiante.setApellidos("Palominos");
        estudiante.setFechaNacimiento("27/10/1999");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(0);

        double descuento = estudianteService.calcularDescuentoPorAñosDeEgreso(estudiante);
        assertEquals(0,descuento,0.0);
    }

    @Test
    void calcularValorPorCuota() {
        estudiante.setRut("20445431-1");
        estudiante.setNombres("Diego Armijo");
        estudiante.setApellidos("Palominos");
        estudiante.setFechaNacimiento("27/10/1999");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(5);

        double valorPorCuota = estudianteService.calcularValorPorCuota(estudiante);
        assertEquals(300000.0, valorPorCuota, 0.0);
    }
}
