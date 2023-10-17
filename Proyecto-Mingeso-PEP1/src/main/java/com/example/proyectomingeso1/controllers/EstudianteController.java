package com.example.proyectomingeso1.controllers;

import com.example.proyectomingeso1.entities.ResumenEstudiante;
import com.example.proyectomingeso1.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    public String vistaPrincipal() {
        return "index";
    }

    @GetMapping("/agregar-estudiante")
    public String agregarEstudiante() {
        return "agregar-estudiante";
    }

    @PostMapping("/guardar-estudiante")
    public String guardarEstudiante(
            @RequestParam String rut,
            @RequestParam String apellidos,
            @RequestParam String nombres,
            @RequestParam String fechaNacimiento,
            @RequestParam String tipoColegioProcedencia,
            @RequestParam String nombreColegio,
            @RequestParam Integer anoEgresoColegio,
            @RequestParam Integer tipoPago
    ) {
        estudianteService.guardarEstudiante(rut, apellidos, nombres, fechaNacimiento, tipoColegioProcedencia, nombreColegio, anoEgresoColegio, tipoPago);

        return "redirect:/"; // Puedes redirigir a una página de confirmación o a donde sea necesario
    }

    @GetMapping("/resumen/{rut}")
    public String obtenerResumenEstudiante(@PathVariable String rut, Model model) {
        ResumenEstudiante resumen = estudianteService.generarResumen(rut);
        model.addAttribute("resumen", resumen);
        return "resumenEstudiante";
    }
}
