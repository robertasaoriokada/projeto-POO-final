package com.evento.event.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evento.event.entities.Pessoa;
import com.evento.event.repositories.PessoaRepo;

@Service
public class PessoaService {
    @Autowired
    public PessoaRepo pessoaRepo;

    public void createPessoa(Pessoa pessoa) {
        pessoaRepo.save(pessoa);
    }

    public Iterable<Pessoa> listarPessoas() { // Iterable --> array
        return pessoaRepo.findAll();
    }

    public Optional<Pessoa> listarPessoaPeloId(Integer id) { // pode ou não retornar algo
        return pessoaRepo.findById(id);
    }

    public void deletarPessoa(Integer id) {
        pessoaRepo.deleteById(id);
    }

    public Pessoa editarPessoa(Integer id, Pessoa pessoaEdicao) {
        Optional<Pessoa> pessoa = pessoaRepo.findById(id);
        pessoa.get().setNome(pessoaEdicao.getNome());
        pessoa.get().setTelefone(pessoaEdicao.getTelefone());
        pessoa.get().setRg(pessoaEdicao.getRg());
        return pessoaRepo.save(pessoa.get());
    }


}
