package com.example.proyectomingeso1.repositories;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, String> {
    // Puedes agregar métodos personalizados de ser necesario
}
