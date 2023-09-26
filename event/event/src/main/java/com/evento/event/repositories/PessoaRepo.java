package com.evento.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evento.event.entities.Pessoa;

@Repository
public interface PessoaRepo extends JpaRepository<Pessoa, Integer> {

}
