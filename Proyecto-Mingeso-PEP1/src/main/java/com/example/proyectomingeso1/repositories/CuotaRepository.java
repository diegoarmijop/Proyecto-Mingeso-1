/*package com.example.proyecto.repositories;

import com.example.proyectomingeso1.entities.CuotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuotaRepository extends JpaRepository<CuotaEntity, Long> {
    @Query("SELECT e.rut, e.tipoPago FROM EstudianteEntity e")
    List<Object[]> obtenerRutYTipoPagoDeEstudiantes();
}*/
