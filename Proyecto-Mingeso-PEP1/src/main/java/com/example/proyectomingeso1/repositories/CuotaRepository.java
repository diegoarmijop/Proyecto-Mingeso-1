package com.example.proyectomingeso1.repositories;

import com.example.proyectomingeso1.entities.CuotaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CuotaRepository extends CrudRepository<CuotaEntity, Long> {
    @Query(value = "select * from cuota as c where c.rut_estudiante = :rut",
            nativeQuery = true)
    ArrayList<CuotaEntity> findCuotasEstudiante(@Param("rut") String rut);
}