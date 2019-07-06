package com.isw.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isw.server.models.Proyecto;

public interface ProyectoRepo extends JpaRepository<Proyecto, Integer> {

}