package com.example.controllers;

import java.io.IOException;

import com.example.App;
import com.example.models.daos.FabricaConexoes;
import com.example.models.daos.JDBCPersonagemDAO;
import com.example.models.entities.Personagem;
import com.github.hugoperlin.results.Resultado;
import com.example.models.entities.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;  // Para os controles como TextField, Button, Label, etc.
import javafx.scene.text.Text;

public class CadastrarFicha {

    // Campos de texto do FXML
    @FXML private TextField nome_personagem;
    @FXML private TextArea desc_personagem;
    @FXML private TextField st_text_field;
    @FXML private TextField dx_text_field;
    @FXML private TextField iq_text_field;
    @FXML private TextField ht_text_field;

    // Textos exibidos
    @FXML private Text st_text;
    @FXML private Text dx_text;
    @FXML private Text iq_text;
    @FXML private Text ht_text;
    @FXML private Text dano_text;
    @FXML private Text vida_text;
    @FXML private Text pontos_de_atributo_text;
    @FXML private Text fadiga_text;
    @FXML private Text vel_text;

    // Labels de erro e sucesso
    @FXML private Label sucesso_label;
    @FXML private Label erro_label;

    // Método para voltar
    @FXML
    private void voltar() throws IOException {
        App.setRoot("tela1");
    }

    // Método para salvar a ficha
    @FXML
    private void salvar() {
        try {
            // Recuperar dados dos campos de entrada
            String nome = nome_personagem.getText();
            String desc = desc_personagem.getText();
            
            // Pegar valores dos elementos Text
            int st = Integer.parseInt(st_text.getText());
            int dx = Integer.parseInt(dx_text.getText());
            int iq = Integer.parseInt(iq_text.getText());
            int ht = Integer.parseInt(ht_text.getText());
            int vida = Integer.parseInt(vida_text.getText());
            int pontos_de_atributo = Integer.parseInt(pontos_de_atributo_text.getText());
            String dano = dano_text.getText();
            int fadiga = Integer.parseInt(fadiga_text.getText());
            float vel = Float.parseFloat(vel_text.getText());

            // Criar o personagem
            Personagem personagem = new Personagem(0, nome, desc, st, dx, iq, ht, fadiga, dano, vel, vida, pontos_de_atributo);

            // Usar o DAO para criar o personagem no banco
            JDBCPersonagemDAO dao = new JDBCPersonagemDAO(new FabricaConexoes());
            Resultado resultado = dao.criar(personagem);
            
            if (resultado.foiSucesso()) {
                sucesso_label.setText("Personagem criado com sucesso!");
                erro_label.setText(""); // Limpar mensagem de erro
            } else if (resultado.foiErro()) {
                erro_label.setText("Erro ao criar personagem: " + resultado.getMsg());
                sucesso_label.setText(""); // Limpar mensagem de sucesso
            }
        } catch (NumberFormatException e) {
            erro_label.setText("Erro: Verifique os valores numéricos.");
            sucesso_label.setText(""); // Limpar mensagem de sucesso
        }
    }
}
