package com.isw.server.repository;

import com.isw.server.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userRepo extends JpaRepository<user, Integer> {   
 
    @Query("FROM user WHERE username = ?1")
    user findUserAccount(String username);
}