package com.example.models.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
    
    public static int getLastId(PreparedStatement pstm) throws SQLException{

        // Instancia a conexão associada ao PreparedStatement
        Connection con = pstm.getConnection();
        // Inicia ID como valor padrão para caso dê erro
        int id = -1;

        // Verifica se o banco de dados é SQLite
        if(con.getMetaData().getDatabaseProductName().equals("SQLite")){
            // Executa o comando para retornar o último ID inserido no banco de dados
            ResultSet rs2 = con.prepareStatement("select last_insert_rowid();").executeQuery();
            rs2.next();
            id = rs2.getInt(1);
            // Fecha o ResultSet
            rs2.close();
        }else{
            // Tratamento para outros bancos de dados
            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        }
        // Retorna id
        return id;
    }
}