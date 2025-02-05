package com.example.models.repositories;

import com.github.hugoperlin.results.Resultado;
import com.example.models.daos.PericiaDAO;
import com.example.models.entities.Pericia;

public class RepositorioPericia {

    private PericiaDAO dao;

    public RepositorioPericia(PericiaDAO dao) {
        this.dao = dao;
    }

    public Resultado criar(String nome, String descricao, String dificuldade, String tipo, int custo) {
        Pericia pericia = new Pericia(0, nome, descricao, dificuldade, tipo, custo);
        return dao.criar(pericia);
    }

    public Resultado listar() {
        return dao.listar();
    }

    public Resultado buscarIdPorNome(String nome) {
        return dao.buscarIdPorNome(nome);
    }
}
