package com.isw.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.isw.server.models.task;

public interface taskRepo extends JpaRepository<task, Integer> {
    
    @Query("FROM task WHERE proyecto = ?1")
    List<task> findTasksbyProyect(int id);
}