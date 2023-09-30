/*package com.example.proyectomingeso1.entities;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "matriculas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula_id")
    private Long matriculaId;

    @Column(name = "fecha_matricula")
    private String fechaMatricula;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "monto_matricula")
    private Integer montoMatricula;

    @Column(name = "descuento_matricula")
    private Integer descuentoMatricula;

    @OneToOne
    @JoinColumn(name = "rut")
    private EstudianteEntity estudiante;


}*/
