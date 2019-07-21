package com.isw.server.repository;

import java.util.List;

import com.isw.server.models.MemberProyect;
import com.isw.server.models.MemberProyectId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface memberProyectRepo extends JpaRepository<MemberProyect, MemberProyectId> { //<modelo,llave primaria>

    @Query(value = "SELECT * FROM member_proyect WHERE id_proyecto = ?1", nativeQuery = true)
    List<MemberProyect> getmembers(int ProyectId);
}