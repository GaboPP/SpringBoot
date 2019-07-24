package com.isw.server.controllers;

import com.isw.server.repository.participanteRepo;
import com.isw.server.repository.proyectoRepo;
import com.isw.server.models.participante;
import com.isw.server.models.proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Así se define un controlador
@RequestMapping("/crear-proyecto") //Para definirlo como endpoint
public class ControllerCrearProyecto {
    @Autowired
    proyectoRepo proyecto;
    @Autowired
    participanteRepo participante;
    

    @GetMapping(path = "/add")
    public String proyectoForm(Model mod) {
        mod = mod.addAttribute("proyecto", new proyecto());
        mod = mod.addAttribute("part0", new participante());
        mod = mod.addAttribute("part1", new participante());
        mod = mod.addAttribute("part2", new participante());
        mod = mod.addAttribute("part3", new participante());
        mod = mod.addAttribute("part4", new participante());
        mod = mod.addAttribute("part5", new participante());
        return "crear-proyecto";
    }

    @PostMapping(path = "")
    public String saveProyecto(@ModelAttribute("proyecto") proyecto proy, @ModelAttribute("part0") participante part0, @ModelAttribute("part1") participante part1, @ModelAttribute("part2") participante part2, @ModelAttribute("part3") participante part3, @ModelAttribute("part4") participante part4, @ModelAttribute("part5") participante part5, BindingResult bindingResult, @RequestParam("tipo") String tipo){
        String[] names = part0.getName().split(",");
        String[] mails = part0.getEmail().split(",");
        
        proy.setTipo(tipo);
        proy.setState(1);
        proy.setComentario("");
        
        proyecto.save(proy);
        for(int i = 0; i < names.length; ++i){
            if(!(names[i].equals("") || mails[i].equals(""))){
                participante aux = new participante();
                aux.setEmail(mails[i]);
                aux.setName(names[i]);
                participante.save(aux);
            }
        }
        return "index";
    }
}