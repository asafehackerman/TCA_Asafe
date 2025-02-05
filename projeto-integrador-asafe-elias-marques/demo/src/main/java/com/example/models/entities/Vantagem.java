package com.example.models.entities;

public class Vantagem {
    int id;
    String nome;
    String desc;
    int custo;

    public Vantagem (int id, String nome, String desc, int custo) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
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
    public int getCusto() {
        return custo;
    }
    public void setCusto(int custo) {
        this.custo = custo;
    }

    
}
