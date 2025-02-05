package com.example.controllers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

import com.example.App;
import com.example.models.daos.FabricaConexoes;
import com.example.models.daos.JDBCPersonagemDAO;
import com.example.models.daos.JDBCVantagemDAO;
import com.example.models.entities.Peculiaridade;
import com.example.models.entities.Personagem;
import com.example.models.entities.PersonagemPeculiaridade;
import com.example.models.entities.Vantagem;
import com.github.hugoperlin.results.Resultado;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;  // Para os controles como TextField, Button, Label, etc.
import javafx.scene.text.Text;

public class Tela2 {

    // Campos de texto do FXML
    @FXML private TextField nome_personagem;
    @FXML private TextArea desc_personagem;

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

    @FXML private Button st_up_btn;
    @FXML private Button st_dn_btn;
    @FXML private Button dx_up_btn;
    @FXML private Button dx_dn_btn;
    @FXML private Button iq_up_btn;
    @FXML private Button iq_dn_btn;
    @FXML private Button ht_up_btn;
    @FXML private Button ht_dn_btn;
    
    @FXML private TableView<String> tabela_atributos;
    @FXML MenuButton vantagens_menu_button;
    @FXML MenuButton desvantagens_menu_button;
    @FXML MenuItem vantagem1;

    // Labels de erro e sucesso
    @FXML private Label sucesso_label;
    @FXML private Label erro_label;
    Personagem personagem = new Personagem(0, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0);

    @FXML
    private void voltar() throws IOException {
        App.setRoot("tela1");
    }

    @FXML
    private void mais_st_btn() {
        int ptsInt = Integer.parseInt(pontos_de_atributo_text.getText());
        String msg;
        Alert alert;

        if (ptsInt <= 0) {
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();
        } else {
            int stInt = Integer.parseInt(st_text.getText());
            stInt++;
            String stString = String.valueOf(stInt);
            st_text.setText(stString);
            atualizarAtributos();
            adicionarPontoAtributo();
        }
    }

    @FXML
    private void menos_st_btn() {
        String msg;
        Alert alert;
        int stInt = Integer.parseInt(st_text.getText());
        
        if (stInt <= 1) {
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();   
        } else {
            stInt--;
            String stString = String.valueOf(stInt);
            st_text.setText(stString);
            atualizarAtributos();
            tirarPontoAtributo();
        }
        
        
    }

    @FXML
    private void mais_dx_btn() {
        int ptsInt = Integer.parseInt(pontos_de_atributo_text.getText());
        String msg;
        Alert alert;

        if (ptsInt <= 0) {
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();
        } else {
            int dxInt = Integer.parseInt(dx_text.getText());
            dxInt++;
            String dxString = String.valueOf(dxInt);
            dx_text.setText(dxString);
            atualizarAtributos();
            adicionarPontoAtributo();
        }
    }

    @FXML
    private void menos_dx_btn() {
        String msg;
        Alert alert;
        int dxInt = Integer.parseInt(dx_text.getText());

        if (dxInt <= 1) {
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();
        } else {
            dxInt--;
            String dxString = String.valueOf(dxInt);
            dx_text.setText(dxString);
            atualizarAtributos();
            tirarPontoAtributo();
        }
    }

    @FXML
    private void mais_iq_btn() {
        int ptsInt = Integer.parseInt(pontos_de_atributo_text.getText());
        String msg;
        Alert alert;
        if (ptsInt <= 0) {
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();
        } else {
            int iqInt = Integer.parseInt(iq_text.getText());
            iqInt++;
            String iqString = String.valueOf(iqInt);
            iq_text.setText(iqString);
            atualizarAtributos();
            adicionarPontoAtributo();
        }
    }

    @FXML
    private void menos_iq_btn() {
        String msg;
        Alert alert;
        int iqInt = Integer.parseInt(iq_text.getText());

        if (iqInt <= 1) {
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();
        } else {
            iqInt--;
            String iqString = String.valueOf(iqInt);
            iq_text.setText(iqString);
            atualizarAtributos();
            tirarPontoAtributo();
        }
    }

    @FXML
    private void mais_ht_btn() {
        int ptsInt = Integer.parseInt(pontos_de_atributo_text.getText());
        String msg;
        Alert alert;

        if (ptsInt <= 0) {
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();
        } else {
            int htInt = Integer.parseInt(ht_text.getText());
            htInt++;
            String htString = String.valueOf(htInt);
            ht_text.setText(htString);
            atualizarAtributos();
            adicionarPontoAtributo();
        }
    }

    @FXML
    private void menos_ht_btn() {    
        String msg;
        Alert alert;
        int htInt = Integer.parseInt(ht_text.getText());
        
        if(htInt <= 1){
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();        
        } else {
            htInt--;
            String htString = String.valueOf(htInt);
            ht_text.setText(htString);
            atualizarAtributos();
            tirarPontoAtributo();
        }
    }

    // Método para salvar a ficha
    private void atualizarAtributos() {
        fadiga_text.setText(st_text.getText());
        dano_text.setText(personagem.definirDano(Integer.parseInt(st_text.getText())));
        vida_text.setText(ht_text.getText());
        
        int dxFloat = Integer.parseInt(dx_text.getText());
        int htFloat = Integer.parseInt(ht_text.getText());
        personagem.setVel(dxFloat, htFloat);
        String velString = String.valueOf(personagem.getVel());
        vel_text.setText(velString);
    }

    
    private void adicionarPontoAtributo() {
        int ptsInt = Integer.parseInt(pontos_de_atributo_text.getText());
        String msg;
        Alert alert;

        if (ptsInt <= 0){
            msg = "fudeu";
            alert = new Alert(AlertType.ERROR,msg);
            alert.close();        
        } else {
            ptsInt--;
            String ptsString = String.valueOf(ptsInt);
            pontos_de_atributo_text.setText(ptsString);
        }
        
    }
    
    private void tirarPontoAtributo() {
        int ptsInt = Integer.parseInt(pontos_de_atributo_text.getText());
                
        ptsInt++;
        String ptsString = String.valueOf(ptsInt);
        pontos_de_atributo_text.setText(ptsString);
        
    }

    @FXML
    private void preencheVantagens() {
        JDBCVantagemDAO dao = new JDBCVantagemDAO(new FabricaConexoes());
        ArrayList<Vantagem> vantagens = dao.listar();
        vantagens_menu_button.getItems().clear();

        for(Vantagem v : vantagens) {
            if (v == null) {
                System.out.println("erro");
            } 
            MenuItem item = new MenuItem(v.getNome());
            vantagens_menu_button.getItems().add(item);
        }
    }

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
                System.out.println("Personagem criado com sucesso!");
                //erro_label.setText(""); // Limpar mensagem de erro
            } else if (resultado.foiErro()) {
                System.out.println("Erro ao criar personagem: " + resultado.getMsg());
                 // Limpar mensagem de sucesso
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Verifique os valores numéricos.");
            //sucesso_label.setText(""); // Limpar mensagem de sucesso
        }
    }

    
}
