package com.example.models.daos;

import java.sql.*;
import java.util.ArrayList;
import com.example.models.entities.Pericia;
import com.example.models.utils.DBUtils;
import com.github.hugoperlin.results.Resultado;

public class JDBCPericiaDAO implements PericiaDAO {
    private FabricaConexoes fabrica;

    public JDBCPericiaDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Pericia pericia) {
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement(
                "INSERT INTO TCA_Pericia (nome_pericia, desc_pericia, dificuldade_pericia, tipo_pericia, custo_percia) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            pstm.setString(1, pericia.getNome());
            pstm.setString(2, pericia.getDesc());
            pstm.setString(3, pericia.getDificuldade());
            pstm.setString(4, pericia.getTipo());
            pstm.setInt(5, pericia.getCusto());

            int ret = pstm.executeUpdate();
            if (ret == 1) {
                int id = DBUtils.getLastId(pstm);
                pericia.setId(id);
                return Resultado.sucesso("Perícia cadastrada", pericia);
            }
            return Resultado.erro("Erro ao cadastrar perícia.");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listar() {
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM TCA_Pericia");
            ResultSet rs = pstm.executeQuery();
            ArrayList<Pericia> lista = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id_pericia_pk");
                String nome = rs.getString("nome_pericia");
                String desc = rs.getString("desc_pericia");
                String dificuldade = rs.getString("dificuldade_pericia");
                String tipo = rs.getString("tipo_pericia");
                int custo = rs.getInt("custo_pericia");

                Pericia pericia = new Pericia(id, nome, desc, dificuldade, tipo, custo);
                lista.add(pericia);
            }

            return Resultado.sucesso("Lista carregada", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarIdPorNome(String nome) {
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("SELECT id_pericia FROM TCA_Pericia WHERE nome_pericia = ?");
            pstm.setString(1, nome);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_pericia");
                return Resultado.sucesso("ID encontrado", id);
            } else {
                return Resultado.erro("Perícia não encontrada.");
            }
        } catch (SQLException e) {
            return Resultado.erro("Erro ao buscar perícia: " + e.getMessage());
        }
    }
}
