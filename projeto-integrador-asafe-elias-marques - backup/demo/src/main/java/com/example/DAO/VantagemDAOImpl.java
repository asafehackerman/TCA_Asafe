package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.db.FabricaConexao;
import com.example.models.entities.Vantagem;

public class VantagemDAOImpl {
    
    
    
    public boolean mostrarVantagem(Vantagem vantagem) {
        String sql = "select * from TCA_Vantagem";

        try (Connection con = FabricaConexao.faz_Conexao(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(2, vantagem.getId());
            stmt.setString(1, vantagem.getNome());
            stmt.setString(2, vantagem.getDesc());
            stmt.setInt(2, vantagem.getCusto());

            try (ResultSet rs = stmt.executeQuery();) {

                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

}
