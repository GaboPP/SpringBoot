package com.isw.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isw.server.models.participante;
import com.isw.server.repository.participanteRepo;

@Controller //Así se define un controlador
@RequestMapping("/home") //Para definirlo como endpoint
public class ControllerBasic {

    @GetMapping(path = {"/post", "/"}) // le digo a Spring boot que es un methodo que puede ser accesado mediante GET
    public String saludar() {
        return "index";
    }
    
    @Autowired
    private participanteRepo participanteRepo;

    @GetMapping(value = "/all") // le digo a Spring boot que es un methodo que puede ser accesado mediante GET
    public List<participante> getAll() {
        return participanteRepo.findAll();
    }

    @PostMapping(value = "/load")
    public List<participante> persist(@RequestBody final participante Participante) {
        participanteRepo.save(Participante);
        return participanteRepo.findAll();

    }

}