package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.Tarea;
import com.example.demo.repository.TareaRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TareaController {
    
    @Autowired
    private TareaRepository repository;

    @GetMapping({"/tareas","/"})
    public String mostrarIndex(Model modelo){
        modelo.addAttribute("tareas", repository.findAll());
        return "index";
    }

    @GetMapping("/tareas/agregar")
    public String formularioAgregar(Model modelo) {
        Tarea tarea = new Tarea();
        modelo.addAttribute("tarea", tarea);
        return "agregarTarea";
    }

    @PostMapping("/tareas")
    public String guardarTarea(@ModelAttribute("tarea") Tarea tarea) {
        repository.save(tarea);
        return "redirect:/tareas";
    }
    
}
