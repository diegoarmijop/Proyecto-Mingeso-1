package com.example.proyectomingeso1.services;

import com.example.proyectomingeso1.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CuotaService {
    @Autowired
    CuotaRepository cuotaRepository;
    @Autowired
    AdminService adminService;
    @Autowired
    EstudianteService estudianteService;



}
