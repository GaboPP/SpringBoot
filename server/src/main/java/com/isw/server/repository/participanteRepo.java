package com.isw.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isw.server.models.participante;

public interface participanteRepo extends JpaRepository<participante, Integer> { //<modelo,llave primaria>

    @Query("FROM participante WHERE id_participante = ?1")
    participante getParts(int ParticipanteId);
}