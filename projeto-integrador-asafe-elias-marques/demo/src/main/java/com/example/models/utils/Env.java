package com.example.models.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {

    private static Dotenv dotenv;

    private Env() {}

    public static String get(String key) {
        if (dotenv == null) {
            // Usar o arquivo .env diretamente do classpath
            dotenv = Dotenv.load();
            System.out.println("Variável URL_DB: " + Env.get("URL_DB"));


        }
        // Verificar se a variável existe e retornar
        String value = dotenv.get(key);
        if (value == null) {
            System.out.println("Variável não encontrada: " + key);
            System.out.println("Variável erro URL_DB: " + Env.get("URL_DB"));

        }
        return value;
    }
}
