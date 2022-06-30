package com.example.demo.controller;

import com.example.demo.model.Tarea;
import com.example.demo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TareaController {

    @Autowired
    private TareaRepository repository;

    @GetMapping({"/tareas", "/"})
    public String mostrarIndex(Model modelo) {
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

    @GetMapping("/tareas/editar/{id}")
    public String formularioEditar(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("tarea", repository.findById(id).get());
        return "editarTarea";
    }

    @PostMapping("/tareas/{id}")
    public String editarTarea(@PathVariable("id") Long id, @ModelAttribute("tarea") Tarea tarea, Model modelo) {
        Optional<Tarea> tareaData = repository.findById(id);
        if (tareaData.isPresent()) {
            Tarea _tarea = tareaData.get();
            _tarea.setTitulo(tarea.getTitulo());
            _tarea.setDescription(tarea.getDescription());
            repository.save(_tarea);
        }
        return "redirect:/tareas";
    }

}
