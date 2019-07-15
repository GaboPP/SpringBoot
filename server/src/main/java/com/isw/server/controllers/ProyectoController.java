package com.isw.server.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.isw.server.models.proyecto;
import com.isw.server.repository.ProyectoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController{

    @Autowired
    ProyectoRepo proyectoRepo;

    @GetMapping(path = {""})
    public String proyectos(Model model){
        List<proyecto> proyects = proyectoRepo.findAll();
        List<proyecto> proyectos = proyects.stream().filter( (p) -> { return p.getState() != 1;}).collect(Collectors.toList());
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }
    
    @GetMapping(path = {"/evaluar"})
    public String evaluar(Model model){
        List<proyecto> proyects = proyectoRepo.findAll();
        List<proyecto> proyectos = proyects.stream().filter( (p) -> { return p.getState() == 1;}).collect(Collectors.toList());
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }

    @GetMapping(value = "/getProyect")
    public List<proyecto> getProyect(){
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