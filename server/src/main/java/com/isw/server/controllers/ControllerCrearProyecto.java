package com.isw.server.controllers;

import com.isw.server.repository.participanteRepo;
import com.isw.server.repository.proyectoRepo;
import com.isw.server.models.ListParticipante;
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
import org.springframework.web.servlet.view.RedirectView;

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
        mod = mod.addAttribute("miembros", new ListParticipante());
        return "crear-proyecto";
    }

    @PostMapping(path = "")
    public String saveProyecto(proyecto proy, participante part0, @ModelAttribute ListParticipante miembros,
            @RequestParam("tipo") String tipo) {
        
        proyecto.save(proy);

        participante.save(part0);
        for(int i = 0; i < miembros.getMails().size(); ++i){
            participante aux = new participante();
            aux.setEmail(miembros.getMails().get(i));
            aux.setName(miembros.getNames().get(i));
            participante.save(aux);
        }
        return "index"; // new RedirectView("/login");
    }
}