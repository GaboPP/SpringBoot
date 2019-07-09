package com.isw.server.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.isw.server.models.participante;
import com.isw.server.models.proyecto;
import com.isw.server.repository.participanteRepo;
import com.isw.server.repository.proyectoRepo;

@Controller //Así se define un controlador
@RequestMapping("/data") //Para definirlo como endpoint
public class ControllerBasic {

    // @GetMapping(path = {"/post", "/"}) // le digo a Spring boot que es un methodo que puede ser accesado mediante POST
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @Autowired
    private participanteRepo participanteRepo;
    @Autowired
    private proyectoRepo proyectoRepo;

    @GetMapping(value = "/all") // le digo a Spring boot que es un methodo que puede ser accesado mediante GET
    public List<proyecto> getAll() {//Model model) {
        //model.addAttribute("personas", participanteRepo.findAll());
        return proyectoRepo.findAll();
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
    
    
    @GetMapping(value = "/getProyect")
    public List<proyecto> getProyect() {
        return proyectoRepo.findAll();
    }
    
    @GetMapping("/proyect_detail/{id}")
    public ModelAndView getproyect_detail(@PathVariable(required = true, name = "id") int id
    ){        
        ModelAndView modelAndView = new ModelAndView("proyect_details/proyect_detail");
        List<proyecto> proyectos = this.getProyect().stream().filter( (p) -> { return p.getId_proyecto() == id;}).collect(Collectors.toList());
        modelAndView.addObject("post", proyectos.get(0));
        return modelAndView.addObject("proyecto", new proyecto());
    }
    @PostMapping("/add_proyect_detail")
    public String add_proyect_detail(proyecto post_evaluation, Model model) {
        List<proyecto> posts = this.getProyect();
        posts.add(post_evaluation);
        model.addAttribute("posts", posts);
        return "index";
    }

}