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

import com.evento.event.entities.Pessoa;
import com.evento.event.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public String createPessoa(@RequestBody Pessoa pessoa) {
        if (pessoa == null) {
            return "Não foi possível criar";
        }

        pessoaService.createPessoa(new Pessoa(pessoa.getNome(), pessoa.getTelefone(), pessoa.getRg()));
        return "Pessoa criada com sucesso";
    }

    @GetMapping
    public Iterable<Pessoa> listarPessoa() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> listarPessoaPeloId(@PathVariable(name = "id") Integer id) {
        return pessoaService.listarPessoaPeloId(id);
    }

    @DeleteMapping("/{id}")
    public String deletarPeloId(@PathVariable(name = "id") Integer id) {
        pessoaService.deletarPessoa(id);
        return "Deletado com sucesso";
    }

    @PatchMapping("/{id}")
    public String editarPessoaPeloId(@PathVariable(name = "id") Integer id, @RequestBody Pessoa pessoa) {
        pessoaService.editarPessoa(id, new Pessoa(pessoa.getNome(), pessoa.getTelefone(), pessoa.getRg()));
        return "Editado";
    }

}
