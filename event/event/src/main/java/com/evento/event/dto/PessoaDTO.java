package com.evento.event.dto;

import com.evento.event.entities.Pessoa;

public record PessoaDTO (String nome, String telefone, String rg){
      public PessoaDTO(Pessoa pessoa){
        this(pessoa.getNome(), pessoa.getTelefone(), pessoa.getRg());

    }

    public String getRg() {
        return null;
    }
}
