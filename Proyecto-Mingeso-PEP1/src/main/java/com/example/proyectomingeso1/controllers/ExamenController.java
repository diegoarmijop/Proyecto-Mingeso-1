package com.example.proyectomingeso1.controllers;

import com.example.proyectomingeso1.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class ExamenController {

    @Autowired
    ExamenService examenService;

    @GetMapping("/mostrar-resumen-estudiante")
    public String importarResumen(){return "mostrar-resumen-estudiante";}


    @GetMapping("/importar-notas")
    public String importar(){return "importar-notas";}

    @PostMapping("/importar-notas")
    public String importar(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        examenService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        examenService.leerCsv(file.getOriginalFilename());
        return "redirect:/importar-notas";
    }
}
