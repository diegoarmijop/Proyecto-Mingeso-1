package com.example.proyectomingeso1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cuota")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CuotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuota_id", nullable = false)
    private Long id;
    @Column(name = "numero_cuota")
    private Integer numeroCuota;
    @Column(name = "monto_cuota")
    private Double montoCuota;
    @Column(name = "estado")
    private String estado;
    @Column(name = "rut_estudiante")
    private String rutEstudiante;
    @Column(name = "fecha_cuota")
    private String fechaCuota;
}
