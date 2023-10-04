package com.example.proyectomingeso1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;

@Entity
@Table(name="estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstudianteEntity {

    @Id
    private String rut;
    private String apellidos;
    private String nombres;
    private String fechaNacimiento;
    private String tipoColegioProcedencia;
    private String nombreColegio;
    private Integer anoEgresoColegio;
    private String tipoPago;

}
