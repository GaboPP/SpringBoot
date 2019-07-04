package com.isw.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isw.server.models.Participante;

public interface participanteRepo extends JpaRepository<Participante, Integer> {

}