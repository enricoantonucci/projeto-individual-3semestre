package br.com.sptech.eventos.model;

public class Evento {

    private Integer id;
    private String nome;
    private String local;
    private String responsavel;
    private String tipo;
    private String situacao;

    public Evento() {
    }

    public Evento(Integer id, String nome, String local, String responsavel, String tipo, String situacao) {
        this.id = id;
        this.nome = nome;
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
