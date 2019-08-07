package com.isw.server.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

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
    private taskRepo taskRepo;
    @Autowired
    private memberProyectRepo memberProyectRepo;
    @Autowired
    private participanteRepo participanteRepo;
    
    @GetMapping(path = {"/{Name}"})
    public ModelAndView tasks(@PathVariable(required = true, name = "Name") String username){
        user appUser = this.appUserDAO.findUserAccount(username);
        List<task> proyectos = taskRepo.findTasksbyProyect(appUser.getUserId());
        ModelAndView modelAndView = new ModelAndView("taskBoard/taskBoard");
        int proyecto_id = proyectos.get(0).getProyecto(); //de momento asumimos solo un proyecto por miembro
        List<MemberProyect> Member_proyect = memberProyectRepo.getmembers(proyecto_id);
        List<participante> miembros = new ArrayList<participante>();
        Dictionary <Integer, String>members_dicc = new Hashtable<Integer, String>(); 
        for(int member = 0; member < Member_proyect.size(); member++){
            miembros.add(participanteRepo.getParts(Member_proyect.get(member).getId_participante()));
            members_dicc.put(Member_proyect.get(member).getId_participante(), miembros.get(member).getName());
        }
        modelAndView.addObject("task", new task());
        modelAndView.addObject("miembros", miembros);
        modelAndView.addObject("miembros_dicc", members_dicc);
        modelAndView.addObject("username", username);
        modelAndView.addObject("proyectos", proyectos);
        modelAndView.addObject("proyecto_id", proyecto_id);
        return modelAndView;
    }
    

    @RequestMapping(value = "update_task/{name}/{id}", method = { RequestMethod.POST })
    public RedirectView update_proyect_detail(@ModelAttribute task task, @PathVariable(required = true, name = "name") String name, @PathVariable(required = true, name = "id") int id) {
        
        System.out.println(task.getNombre_tarea());
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

    @GetMapping(value = "/get_participantes/{id}")
    public List<task> get_Task(int id_task) {
        return taskRepo.findAll().stream().filter( (p) -> { return p.getId_task() == id_task;}).collect(Collectors.toList());
    }

    @GetMapping(value="/task_detail/{id}")
    public ModelAndView task_detail(@PathVariable(required = true, name = "id") int id){
        List<task> tareas = this.get_Task(id);

        ModelAndView modelAndView = new ModelAndView("taskBoard/taskDetails");
        modelAndView.addObject("tareas", tareas.get(0));
        return modelAndView;
    }
}