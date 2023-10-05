package com.evento.event.dto;

import java.sql.Timestamp;

import com.evento.event.entities.Casamento;
import com.evento.event.entities.Pessoa;

public record CasamentoDTO(String lugar, Timestamp data_hora, Pessoa noivo1, Pessoa noivo2) {
    public CasamentoDTO(Casamento casamento){
        this(casamento.getLugar(), casamento.getData_hora(), casamento.getNoivo1(), casamento.getNoivo2());

    }
}