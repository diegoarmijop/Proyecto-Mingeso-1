package com.example.proyectomingeso1;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import com.example.proyectomingeso1.services.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminTest {

    @Autowired
    AdminService administradorService;
    EstudianteEntity estudiante = new EstudianteEntity();

    /*@Test
    void calcularDescuentoPorPagoContado(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFechaNacimiento("27-08-2023");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(0);

        double descuento = administradorService.calcularDescuentoPorTipoPago(estudiante);
        assertEquals(0.5,descuento,0.0);
    }

    @Test
    void calcularDescuentoPorTipoColegio(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFechaNacimiento("27-10-1999");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(0);

        double descuento = administradorService.calcularDescuentoPorTipoColegio(estudiante);
        assertEquals(0,descuento,0.0);
    }

    @Test
    void calcularDescuentoPorAñosDeEgreso(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFechaNacimiento("27-10-1999");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(5);

        double descuento = administradorService.calcularDescuentoPorAñosDeEgreso(estudiante);
        assertEquals(0,descuento,0.0);
    }

    @Test
    void calcularValorPorCuota(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFechaNacimiento("27-10-1999");
        estudiante.setTipoColegioProcedencia("SUBVENCIONADO");
        estudiante.setNombreColegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAnoEgresoColegio(2018);
        estudiante.setTipoPago(5);

        double valorPorCuota = administradorService.calcularValorPorCuota(estudiante);
        assertEquals(270000,valorPorCuota,0.0);
    }*/
}
