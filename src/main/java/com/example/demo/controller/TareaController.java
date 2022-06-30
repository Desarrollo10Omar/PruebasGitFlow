package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.TareaRepository;

@Controller
public class TareaController {
    
    @Autowired
    private TareaRepository repository;

    @GetMapping({"/todo","/"})
    public String mostrarIndex(Model modelo){
        modelo.addAttribute("tareas", repository.findAll());
        return "index";
    }

}
