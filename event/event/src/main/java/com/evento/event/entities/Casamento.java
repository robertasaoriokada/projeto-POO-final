package com.evento.event.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "casamento")
public class Casamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "lugar", nullable = false)
    private String lugar;

    @Column(name = "data_hora", nullable = false)
    private Timestamp data_hora;

    @OneToOne
    @JoinColumn(name = "noivo1", nullable = false)
    private Pessoa noivo1;

    @OneToOne
    @JoinColumn(name = "noivo2", nullable = false)
    private Pessoa noivo2;

    @OneToMany
    private Set<Pessoa> convidados;

    Casamento() {

    }

    public Casamento(String lugar, Timestamp data_hora, Pessoa noivo1, Pessoa noivo2) {
        this.lugar = lugar;
        this.data_hora = data_hora;
        this.noivo1 = noivo1;
        this.noivo2 = noivo2;
        this.convidados = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public Pessoa getNoivo1() {
        return noivo1;
    }

    public void setNoivo1(Pessoa noivo1) {
        this.noivo1 = noivo1;
    }

    public Pessoa getNoivo2() {
        return noivo2;
    }

    public void setNoivo2(Pessoa noivo2) {
        this.noivo2 = noivo2;
    }

    public Set<Pessoa> getConvidados() {
        return convidados;
    }

    public void setConvidados(Set<Pessoa> convidados) {
        this.convidados = convidados;
    }

}