package com.isw.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isw.server.models.mentor;

public interface mentorRepo extends JpaRepository<mentor, Integer> { //<modelo,llave primaria>

}