package com.example.proyectomingeso1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResumenEstudiante {

    private String rut;
    private String nombre;
    private int numeroExamenesRendidos;
    private Double promedioPuntajeExamenes;
    private Double montoTotalAPagar;
    private String tipoPago;
    private int numeroTotalCuotasPactadas;
    private int numeroCuotasPagadas;
    private Double montoTotalPagado;
    private String fechaUltimoPago;
    private Double saldoPorPagar;
    private Long numeroCuotasConRetraso;

}
