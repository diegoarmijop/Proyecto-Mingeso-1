package com.example.proyectomingeso1.controllers;

import com.example.proyectomingeso1.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;
    @PostMapping("/guardar")
    public String guardarEstudiante(
            @RequestParam String RUT,
            @RequestParam String apellidos,
            @RequestParam String nombres,
            @RequestParam String fechaNacimiento,
            @RequestParam String tipoColegioProcedencia,
            @RequestParam String nombreColegio,
            @RequestParam Integer anoEgresoColegio
    ) {
        estudianteService.guardarEstudiante(RUT, apellidos, nombres, fechaNacimiento, tipoColegioProcedencia, nombreColegio, anoEgresoColegio);

        return "redirect:/"; // Puedes redirigir a una página de confirmación o a donde sea necesario
    }
}
