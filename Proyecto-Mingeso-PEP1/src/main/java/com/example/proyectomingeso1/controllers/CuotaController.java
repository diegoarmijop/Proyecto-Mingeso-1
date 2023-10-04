package com.example.proyectomingeso1.controllers;

import com.example.proyectomingeso1.services.CuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CuotaController {

    @Autowired
    private CuotaService cuotaService;

    @GetMapping("/generar-cuotas")
    public String generarCuotas() {return "generar-cuotas";}

    @PostMapping("/generar-cuotas")
    public String generarCuotas(@RequestParam("rut") String rut){
        cuotaService.generarCuotas(rut);
        return "redirect:/";
    }

}
