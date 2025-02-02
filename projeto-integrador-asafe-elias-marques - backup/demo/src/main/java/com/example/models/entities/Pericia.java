package com.example.models.entities;

public class Pericia {
    int id;
    String nome;
    String desc;
    String dificuldade;
    String tipo;
    int custo;

    public Pericia(int id, String nome, String desc, String dificuldade, String tipo, int custo) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.dificuldade = dificuldade;
        this.tipo = tipo;
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    
    
}
