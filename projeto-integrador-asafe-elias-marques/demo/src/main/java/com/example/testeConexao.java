package com.example;

import com.example.models.daos.FabricaConexoes;
import java.sql.Connection;
import java.sql.SQLException;

public class testeConexao {
    public static void main(String[] args) {
        try {
            Connection con = FabricaConexoes.getInstance().getConnection();
            if (con != null && !con.isClosed()) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
