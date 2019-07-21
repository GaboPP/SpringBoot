package com.isw.server.controllers;

import java.text.SimpleDateFormat;
import java.util.*;

import java.sql.Date;
import com.isw.server.models.MemberProyect;
import com.isw.server.models.participante;
import com.isw.server.models.task;
import com.isw.server.models.user;
import com.isw.server.repository.memberProyectRepo;
import com.isw.server.repository.participanteRepo;
import com.isw.server.repository.taskRepo;
import com.isw.server.repository.userRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tasks")
public class TaskController{

    @Autowired
    private userRepo appUserDAO;
    @Autowired
    taskRepo taskRepo;
    @Autowired
    memberProyectRepo memberProyectRepo;
    @Autowired
    participanteRepo participanteRepo;
    
    @GetMapping(path = {"/{Name}"})
    public ModelAndView tasks(@PathVariable(required = true, name = "Name") String username){
        user appUser = this.appUserDAO.findUserAccount(username);
        List<task> proyectos = taskRepo.findTasksbyProyect(appUser.getUserId());
        ModelAndView modelAndView = new ModelAndView("taskBoard/taskBoard");
        int proyecto_id = proyectos.get(0).getProyecto(); //de momento asumimos solo un proyecto por miembro
        List<MemberProyect> Member_proyect = memberProyectRepo.getmembers(proyecto_id);
        List<participante> miembros = new ArrayList<participante>();
        for(int member = 0; member < Member_proyect.size(); member++){
            miembros.add(participanteRepo.getParts(Member_proyect.get(member).getId_participante()));
        }
        modelAndView.addObject("task", new task());
        modelAndView.addObject("miembros", miembros);
        modelAndView.addObject("username", username);
        modelAndView.addObject("proyectos", proyectos);
        modelAndView.addObject("proyecto_id", proyecto_id);
        return modelAndView;
    }
    

    @RequestMapping(value = "update_task/{name}/{id}", method = { RequestMethod.POST })
    public RedirectView update_proyect_detail(@ModelAttribute task task, @PathVariable(required = true, name = "name") String name, @PathVariable(required = true, name = "id") int id) {
        
        System.out.println(task.getName());
        Calendar cal = Calendar.getInstance();
        Date date = new java.sql.Date( cal.getTime().getTime() );
        task.setFecha_inicio(date);
        task.setProyecto(id);
        System.out.println(task.getDescripcion());
        System.out.println(task.getPrioridad());
        System.out.println(task.getParticipante());
        System.out.println(task.getProyecto());
        System.out.println(task.getFecha_inicio());
        System.out.println(task.getFecha_fin());

        System.out.println(task.getId_task());
        taskRepo.save(task);
        String ruta = "/tasks/" + name;
        return new RedirectView(ruta);
    }
}