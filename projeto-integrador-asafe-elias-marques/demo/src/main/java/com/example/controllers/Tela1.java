package com.example.controllers;


import java.io.IOException;

import com.example.App;
import com.example.models.repositories.RepositorioPersonagem;

import javafx.fxml.FXML;

public class Tela1 {

    public RepositorioPersonagem rsPersonagem;
    public Tela2 cadastrarFicha;

    @FXML
    private void cadastrarFicha() throws IOException {
        App.setRoot("tela2");
    }

    @FXML
    private void editarFicha() throws IOException {
        App.setRoot("tela3");
    }

    @FXML
    private void verFicha() throws IOException {
        App.setRoot("tela4");
    }

    @FXML
    private void ajuda() throws IOException {
        App.setRoot("tela5");
    }

    @FXML
    private void sair() {
        System.exit(0);
    }
}
