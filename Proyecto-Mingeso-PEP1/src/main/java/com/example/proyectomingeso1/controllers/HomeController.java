package com.example.proyectomingeso1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/")
    public String vistaPrincipal() {
        return "index";
    }
    @GetMapping("/agregar-estudiante")
    public String agregarEstudiante() {
        return "agregar-estudiante";
    }
}