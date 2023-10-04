package com.example.proyectomingeso1.repositories;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, String> {

    @Query(value = "select e.tipo_pago from estudiantes as e where e.rut = :rut",
            nativeQuery = true)
    Integer findCantCuotas(@Param("rut") String rut);

    @Query(value = "select * from estudiantes as e where e.rut = :rut",
            nativeQuery = true)
    EstudianteEntity findByRut(@Param("rut")String rut);

}
