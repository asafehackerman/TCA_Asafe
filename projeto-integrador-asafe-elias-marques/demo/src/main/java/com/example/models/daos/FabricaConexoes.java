package com.example.models.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.models.utils.Env;

public class FabricaConexoes {

    private static int MAX_CONNECTIONS = 5;
    private final String URL_DB;
    private final String USER;
    private final String PASSWORD;
    private final String CON_STRING;

    private Connection[] conexoes;

    private static FabricaConexoes instance;

    // Construtor
    public FabricaConexoes() {
        conexoes = new Connection[MAX_CONNECTIONS];
        // Carregar dados de conexão do .env
        URL_DB = Env.get("URL_DB"); // URL completa já definida no .env
        USER = Env.get("DB_USER");  // Nome de usuário do banco
        PASSWORD = Env.get("DB_PASSWORD");  // Senha do banco
        CON_STRING = URL_DB; // Já temos a URL completa, não precisa concatenar o nome do banco
    }

    // Método para garantir que a instância seja criada apenas uma vez
    public static FabricaConexoes getInstance() {
        if (instance == null) {  // Condição corrigida aqui
            instance = new FabricaConexoes();
        }
        return instance;
    }

    // Método para obter uma conexão
    public Connection getConnection() throws SQLException {
        // Tentar obter uma conexão disponível
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            if (conexoes[i] == null || conexoes[i].isClosed()) {
                conexoes[i] = DriverManager.getConnection(CON_STRING, USER, PASSWORD);
                return conexoes[i];
            }
        }
        throw new SQLException("Máximo de conexões alcançado");
    }

    public Connection getConexao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConexao'");
    }
}
