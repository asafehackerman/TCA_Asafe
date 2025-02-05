package com.example.models.daos;

import com.github.hugoperlin.results.Resultado;

import com.example.models.entities.Personagem;

// Classe padrão para declaração dos métodos
public interface PersonagemDAO {
        Resultado criar(Personagem personagem);
        Resultado listar();
}
