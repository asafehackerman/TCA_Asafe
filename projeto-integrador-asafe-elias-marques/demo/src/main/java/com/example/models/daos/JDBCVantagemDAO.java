package com.example.models.daos;

import java.sql.*;
import java.util.ArrayList;
import com.example.models.entities.Pericia;
import com.example.models.entities.Vantagem;
import com.example.models.utils.DBUtils;
import com.github.hugoperlin.results.Resultado;

public class JDBCVantagemDAO implements VantagemDAO {
    private FabricaConexoes fabrica;

    public JDBCVantagemDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public ArrayList <Vantagem> listar() {
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM TCA_Vantagem");
            ResultSet rs = pstm.executeQuery();
            ArrayList<Vantagem> lista = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id_vantagem_pk");
                String nome = rs.getString("nome_vantagem");
                String desc = rs.getString("desc_vantagem");
                int custo = rs.getInt("custo_vantagem");

                Vantagem vantagem = new Vantagem(id, nome, desc, custo);
                lista.add(vantagem);
            }

            return lista;
        } catch (SQLException e) {
            System.out.println("fodeu");
            return null;
        }
    }
}
