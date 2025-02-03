package com.example.controllers;

import java.io.IOException;

import com.example.App;

import javafx.fxml.FXML;

public class TelaInicio {

    @FXML
    private void cadastrarFicha() throws IOException {
        App.setRoot("tela3");
    }

    @FXML
    private void editarFicha() throws IOException {
        App.setRoot("");
    }

    @FXML
    private void verFicha() throws IOException {
        App.setRoot("");
    }

    @FXML
    private void ajuda() throws IOException {
        App.setRoot("");
    }

    @FXML
    private void sair() {
        System.exit(0);
    }
}
