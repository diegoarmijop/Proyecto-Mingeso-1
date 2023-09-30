/*package com.example.proyectomingeso1.controllers;

import com.example.proyectomingeso1.services.EstudianteService;
import com.example.proyectomingeso1.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping("/guardarMatricula")
    public String guardarMatricula(
            @RequestParam Long matriculaID,
            @RequestParam String rutEstudiante
            @RequestParam String fechaMatricula,
            @RequestParam String formaPago,
            @RequestParam Integer montoMatricula,
            @RequestParam Integer descuentoMatricula
    ){
        matriculaService.guardarMatricula(matriculaID, rutEstudiante);
        return "redirect:/";
    }
}*/
