package com.evento.event.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evento.event.entities.Casamento;
import com.evento.event.services.CasamentoService;

@RestController
@RequestMapping("/casamento")
public class CasamentoController {
    @Autowired
    CasamentoService casamentoService;

    @PostMapping("/create")
    public String createCasamento(@RequestBody Casamento casamento) {
        casamentoService.createCasamento(new Casamento(casamento.getLugar(), casamento.getData_hora(),
                casamento.getNoivo1(), casamento.getNoivo2()));
        return "Casamento criado com sucesso";
    }

    @GetMapping("/listAll")
    public Iterable<Casamento> listarCasamentos() {
        return casamentoService.listarCasamentos();
    }

    @GetMapping("/listar/{id}")
    public Optional<Casamento> listarCasamentosPeloId(@PathVariable(name = "id") Integer id) {
        return casamentoService.listarCasamentoPeloId(id);
    }

    @DeleteMapping("deletar/{id}")
    public String deletarCasamentoPeloId(@PathVariable(name = "id") Integer id) {
        casamentoService.deletarCasamento(id);
        return "Casamento apagado";
    }

    @PatchMapping("editar/{id}")
    public String editarCasamentoPeloId(@PathVariable(name = "id") Integer id, @RequestBody Casamento casamento) {
        casamentoService.editarCasamento(id,
                new Casamento(casamento.getLugar(), casamento.getData_hora(), casamento.getNoivo1(),
                        casamento.getNoivo2()));
        return "Editado";
    }

}
