package com.isw.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isw.server.models.MemberProyect;;

public interface memberProyectRepo extends JpaRepository<MemberProyect, Integer> { //<modelo,llave primaria>

}