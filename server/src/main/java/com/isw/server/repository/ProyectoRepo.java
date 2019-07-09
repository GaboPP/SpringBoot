package com.isw.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isw.server.models.proyecto;

public interface ProyectoRepo extends JpaRepository<proyecto, Integer> {

}