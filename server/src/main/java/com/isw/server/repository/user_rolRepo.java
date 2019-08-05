package com.isw.server.repository;

import java.util.List;

import com.isw.server.models.user_rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface user_rolRepo extends JpaRepository<user_rol, Integer> { //<modelo,llave primaria>
    
    @Query("SELECT rol_name FROM user_rol WHERE user_id = ?1")
    List<String> getRoleNames(int userId);
}