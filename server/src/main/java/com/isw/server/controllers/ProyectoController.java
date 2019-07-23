package com.isw.server.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.isw.server.models.proyecto;
import com.isw.server.repository.ProyectoRepo;

import com.isw.server.models.MemberProyect;
import com.isw.server.models.mentor;
import com.isw.server.models.participante;
import com.isw.server.repository.memberProyectRepo;
import com.isw.server.repository.mentorRepo;
import com.isw.server.repository.participanteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController{

    @Autowired
    ProyectoRepo proyectoRepo;
    @Autowired
    private participanteRepo participanteRepo;
    @Autowired
    private memberProyectRepo memberProyectRepo;
    @Autowired
    private mentorRepo mentorRepo;

    @GetMapping(path = {""})
    public ModelAndView proyectos() {
        ModelAndView modelAndView = new ModelAndView("proyectos");
        List<proyecto> proyects = proyectoRepo.findAll();
        List<proyecto> proyectos = proyects.stream().filter( (p) -> { return p.getState() != 1;}).collect(Collectors.toList());
        modelAndView.addObject("proyectos", proyectos);
        return modelAndView;
    }
    
    @GetMapping(path = {"/evaluar"})
    public String evaluar(Model model){
        List<proyecto> proyects = proyectoRepo.findAll();
        List<proyecto> proyectos = proyects.stream().filter( (p) -> { return p.getState() == 1;}).collect(Collectors.toList());
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }
    @GetMapping(value = "/getProyect")
    public List<proyecto> getProyect(int id) {
        return proyectoRepo.findAll().stream().filter((p) -> {
            return p.getId_proyecto() == id;
        }).collect(Collectors.toList());
    }
       
    @GetMapping(value = "/get_participantes/{id}")
    public List<participante> get_memberProyect(int id_proyecto) {
        List<MemberProyect> participantes = memberProyectRepo.findAll().stream().filter( (p) -> { return p.getId_proyecto() == id_proyecto;}).collect(Collectors.toList());
        int id_participante = participantes.get(0).getId_participante();
        return participanteRepo.findAll().stream().filter( (p) -> { return p.getId_participante() == id_participante;}).collect(Collectors.toList());
    }
    public List<mentor> get_mentores() {
        return mentorRepo.findAll();
    }
    @GetMapping("/proyect_detail/{id}")
    public ModelAndView getproyect_detail(@PathVariable(required = true, name = "id") int id
    ){        
        List<participante> participante = this.get_memberProyect(id);

        ModelAndView modelAndView = new ModelAndView("proyect_details/proyect_detail");
        List<proyecto> proyectos = this.getProyect(id);
        List<mentor> mentores = this.get_mentores();
        
        modelAndView.addObject("participante", participante.get(0));
        modelAndView.addObject("mentores", mentores);
        return modelAndView.addObject("proyecto", proyectos.get(0));
    }
    @RequestMapping(value = "proyect_detail/update_proyect_detail/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public String update_proyect_detail(@ModelAttribute proyecto proyecto, @PathVariable(required = true, name = "id") int id) {
        List<proyecto> proyecto_bd = this.getProyect(id);
        
        if(proyecto.getState() == 4) { // fix por 3 que es que el proyecto se acepte!!!
            proyecto.setBoss(1); //FIX! jefe
        } else {
            proyecto.setBoss(proyecto_bd.get(0).getBoss());
        }



        proyecto.setTipo(proyecto_bd.get(0).getTipo());
        proyecto.setNombre(proyecto_bd.get(0).getNombre());
        proyecto.setDetalle(proyecto_bd.get(0).getDetalle());
        proyecto.setId_proyecto(id);
        proyectoRepo.save(proyecto);
        return "index";
    }
}