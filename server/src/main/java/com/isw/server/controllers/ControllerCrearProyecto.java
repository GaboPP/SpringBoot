package com.isw.server.controllers;

import com.isw.server.repository.participanteRepo;
import com.isw.server.repository.proyectoRepo;
import com.isw.server.models.participante;
import com.isw.server.models.proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //Así se define un controlador
@RequestMapping("/crear-proyecto") //Para definirlo como endpoint
public class ControllerCrearProyecto {
    @Autowired
    proyectoRepo proyecto;
    @Autowired
    participanteRepo participante;
    

    @GetMapping(path = "/add")
    public ModelAndView proyectoForm() {
        ModelAndView mod = new ModelAndView("crear-proyecto").addObject("proyecto", new proyecto());
        mod = mod.addObject("participante", new participante());
        return mod;
    }

    @PostMapping(path = "")
    public String saveProyecto(proyecto proy, participante part){
        part.setPermisos(0);
        proyecto.save(proy);
        participante.save(part);
        return "crear-proyecto";
    }
}