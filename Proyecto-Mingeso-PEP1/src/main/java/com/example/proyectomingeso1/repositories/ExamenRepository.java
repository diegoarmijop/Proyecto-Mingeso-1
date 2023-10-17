package com.example.proyectomingeso1.repositories;

import com.example.proyectomingeso1.entities.CuotaEntity;
import com.example.proyectomingeso1.entities.ExamenEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ExamenRepository extends CrudRepository<ExamenEntity, Long> {
    List<ExamenEntity> findByRut(String rut);

}
