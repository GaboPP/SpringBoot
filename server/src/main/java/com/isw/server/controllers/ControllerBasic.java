package com.isw.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Así se define un controlador
@RequestMapping("/home") //Para definirlo como endpoint
public class ControllerBasic {

    @GetMapping(path = {""}) // le digo a Spring boot que es un methodo que puede ser accesado mediante GET
    public String saludar() {
        return "index";
    }
}