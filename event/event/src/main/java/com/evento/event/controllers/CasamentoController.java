package com.evento.event.controllers;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evento.event.entities.Casamento;
import com.evento.event.entities.Pessoa;
import com.evento.event.services.CasamentoService;

@Controller
@RequestMapping("/casamento")
public class CasamentoController {
    @Autowired
    CasamentoService casamentoService;

    @PostMapping("create")
    public String createCasamento(String lugar, Timestamp data_hora, Pessoa noivo1, Pessoa noivo2) {
        casamentoService.createCasamento(new Casamento(lugar, data_hora, noivo1, noivo2));
        return "Casamento criado com sucesso";
    }

}
