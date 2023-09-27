package com.evento.event.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evento.event.entities.Casamento;
import com.evento.event.entities.Pessoa;
import com.evento.event.repositories.CasamentoRepo;

@Service
public class CasamentoService {
    @Autowired
    CasamentoRepo casamentoRepo;

    public void createCasamento(Casamento casamento) {
        casamentoRepo.save(casamento);
    }

    public Iterable<Casamento> listarCasamentos() { // Iterable --> array
        return casamentoRepo.findAll();
    }

    public Optional<Casamento> listarCasamentoPeloId(Integer id) {
        return casamentoRepo.findById(id);
    }

    public void deletarCasamento(Integer id) {
        casamentoRepo.deleteById(id);
    }

    public Casamento editarCasamento(Integer id, Casamento casamentoEdicao) {
        Optional<Casamento> casamento = casamentoRepo.findById(id);
        casamento.get().setLugar(casamentoEdicao.getLugar());
        casamento.get().setData_hora(casamentoEdicao.getData_hora());
        casamento.get().setNoivo1(casamentoEdicao.getNoivo1());
        casamento.get().setNoivo2(casamentoEdicao.getNoivo2());
        return casamentoRepo.save(casamento.get());
    }

    public void adicionarConvidados(Pessoa convidado, Casamento casamento) {
        casamento.adicionarConvidados(convidado);
    }
}
