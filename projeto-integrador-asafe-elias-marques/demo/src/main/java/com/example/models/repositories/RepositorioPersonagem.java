package com.example.models.repositories;

import com.github.hugoperlin.results.Resultado;

import com.example.models.daos.PersonagemDAO;
import com.example.models.entities.Personagem;

public class RepositorioPersonagem {
    
    private PersonagemDAO dao;

    public RepositorioPersonagem (PersonagemDAO dao) {
        this.dao = dao;
    }

    public Resultado criar(int id, String nome, String desc, int st, int dx, int iq, int ht, int fadiga, String dano, float vel, int vida, int pontos_de_atributo){
        Personagem personagem = new Personagem(id, nome, desc, st, dx, iq, ht, fadiga, dano, vel, vida, pontos_de_atributo);

        return dao.criar(personagem);
    }

    public Resultado lista(){
        return dao.listar();
    }

}
