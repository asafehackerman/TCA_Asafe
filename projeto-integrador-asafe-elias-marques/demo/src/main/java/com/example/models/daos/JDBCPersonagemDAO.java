package com.example.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.models.entities.Personagem;
import com.example.models.utils.DBUtils;
import com.github.hugoperlin.results.Resultado;

// Classe especificação dos métodos, implementando UsuarioDAO
public class JDBCPersonagemDAO implements PersonagemDAO {
    private FabricaConexoes fabrica;

    public JDBCPersonagemDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Personagem personagem) {
        // Abre um try criando uma conexão
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("INSERT INTO TCA_Personagem (nome_personagem, desc_personagem, st_personagem, dx_personagem, iq_personagem, ht_personagem, fadiga_personagem, dano_personagem, velocidade_personagem, vida_personagem, pontos_de_atributo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, personagem.getId());
            pstm.setString(2, personagem.getNome());
            pstm.setString(3, personagem.getDesc());
            pstm.setInt(4, personagem.getST());
            pstm.setInt(5, personagem.getDX());
            pstm.setInt(6, personagem.getIQ());
            pstm.setInt(7, personagem.getHT());
            pstm.setInt(8, personagem.getFadiga());
            pstm.setString(9, personagem.getDano());
            pstm.setFloat(10, personagem.getVel());
            pstm.setInt(8, personagem.getVida());
            pstm.setInt(8, personagem.getPontos_de_atributo());            

            // Confirma se o número de linhas foi afetado
            int ret = pstm.executeUpdate();

            if (ret == 1) {
                int id = DBUtils.getLastId(pstm);
                personagem.setId(id);
                return Resultado.sucesso("Personagem cadastrado", personagem);
            }

            return Resultado.erro("Erro ao cadastrar personagem.");

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listar() {
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM TCA_Personagem");

            ResultSet rs = pstm.executeQuery();
            ArrayList<Personagem> lista = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String desc = rs.getString("desc");
                int st = rs.getInt("st");
                int dx = rs.getInt("dx");
                int iq = rs.getInt("iq");
                int ht = rs.getInt("ht");
                int fadiga = rs.getInt("fadiga");
                String dano = rs.getString("dano");
                float vel = rs.getFloat("vel");
                int vida = rs.getInt("vida");
                int pontos_de_atributo = rs.getInt("pontos_de_atributo");

                Personagem personagem = new Personagem(id, nome, desc, st, dx, iq, ht, fadiga, dano, vel, vida, pontos_de_atributo);
                lista.add(personagem);
            }

            return Resultado.sucesso("Lista carregada", lista);

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

}
