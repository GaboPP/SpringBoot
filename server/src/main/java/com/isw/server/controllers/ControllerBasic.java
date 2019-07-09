package com.isw.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isw.server.models.participante;
import com.isw.server.repository.participanteRepo;

@Controller //Así se define un controlador
@RequestMapping("/home") //Para definirlo como endpoint
public class ControllerBasic {

    // @GetMapping(path = {"/post", "/"}) // le digo a Spring boot que es un methodo que puede ser accesado mediante POST
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @Autowired
    private participanteRepo participanteRepo;

    @GetMapping(value = "/all") // le digo a Spring boot que es un methodo que puede ser accesado mediante GET
    public List<participante> getAll() {//Model model) {
        //model.addAttribute("personas", participanteRepo.findAll());
        return participanteRepo.findAll();
    }

    @GetMapping(value = "/get_participantes") // le digo a Spring boot que es un methodo que puede ser accesado mediante GET
    public String get_p( Model model) {
        model.addAttribute("participantes", participanteRepo.findAll());
        return "greeting";
    }

    @GetMapping("/insert_participante")
    public String insert_participante(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        
        participante p = new participante();
        p.setId_participante(4);
        p.setName("yian");
        participanteRepo.save(p);
        return "greeting";
    }
    @PostMapping(value = "/load")
    public List<participante> persist(@RequestBody final participante Participante) {
        participanteRepo.save(Participante);
        return participanteRepo.findAll();

    }

}