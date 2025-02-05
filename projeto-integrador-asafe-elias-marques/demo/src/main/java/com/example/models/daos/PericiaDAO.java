package com.example.models.daos;

import com.github.hugoperlin.results.Resultado;
import com.example.models.entities.Pericia;

public interface PericiaDAO {
    Resultado criar(Pericia pericia);
    Resultado listar();
    Resultado buscarIdPorNome(String nome);
}
