package br.com.sptech.eventos.model;

import java.time.LocalDate;

public class Evento {

    private Integer id;
    private String nome;
    private LocalDate data;
    private String local;
    private String responsavel;
    private String tipo;
    private String situacao;

    public Evento() {
    }

    public Evento(Integer id, String nome, LocalDate data, String local,
                  String responsavel, String tipo, String situacao) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.responsavel = responsavel;
        this.tipo = tipo;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
