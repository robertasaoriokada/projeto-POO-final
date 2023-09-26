package com.evento.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evento.event.entities.Casamento;

@Repository
public interface CasamentoRepo extends JpaRepository<Casamento, Integer> {

}
