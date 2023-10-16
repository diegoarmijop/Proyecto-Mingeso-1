package com.example.proyectomingeso1.repositories;

import com.example.proyectomingeso1.entities.ExamenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends CrudRepository<ExamenEntity, Long> {
}
