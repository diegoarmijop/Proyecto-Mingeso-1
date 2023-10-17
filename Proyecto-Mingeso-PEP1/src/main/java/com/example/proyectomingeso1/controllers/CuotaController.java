package com.example.proyectomingeso1.controllers;

import com.example.proyectomingeso1.entities.CuotaEntity;
import com.example.proyectomingeso1.services.CuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class CuotaController {

    @Autowired
    CuotaService cuotaService;

    @GetMapping("/rut-cuotas")
    public String cuotas(){
        return "rut-cuotas";
    }

    @GetMapping("/generar-cuotas")
    public String generarCuotas() {return "generar-cuotas";}

    @PostMapping("/generar-cuotas")
    public String generarCuotas(@RequestParam("rut") String rut){
        cuotaService.generarCuotas(rut);
        return "redirect:/";
    }

    @GetMapping("/listado-cuotas")
    public String cuotas(Model model, @RequestParam("rut") String rut){
        List<CuotaEntity> cuotas = cuotaService.obtenerCuotasEstudiante(rut);
        model.addAttribute("cuotas", cuotas);
        return "listado-cuotas";
    }

}
