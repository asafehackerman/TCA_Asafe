package com.example.controllers;

import java.io.IOException;

import com.example.App;

import javafx.fxml.FXML;

public class Tela3 {
    

    @FXML
    private void voltar() throws IOException {
        App.setRoot("tela1");
    }
    
}
