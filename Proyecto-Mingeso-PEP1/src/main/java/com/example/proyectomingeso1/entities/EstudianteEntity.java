package com.example.proyectomingeso1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String RUT;
    private String apellidos;
    private String nombres;
    private String fechaNacimiento;
    private String tipoColegioProcedencia;
    private String nombreColegio;
    private Integer anoEgresoColegio;

}
