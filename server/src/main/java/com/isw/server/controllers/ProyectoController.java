package com.isw.server.controllers;

import com.isw.server.repository.ProyectoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.isw.server.models.Proyecto;
import java.util.*;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController{

    @Autowired
    ProyectoRepo proyectoRepo;
    
    @GetMapping(path = {""})
    public String proyectos(Model model){
        List<Proyecto> proyectos = proyectoRepo.findAll();
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }
}