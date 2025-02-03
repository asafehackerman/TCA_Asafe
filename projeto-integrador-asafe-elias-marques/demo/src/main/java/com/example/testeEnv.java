package com.example;

import com.example.models.utils.Env;

public class testeEnv {
    public static void main(String[] args) {
        String url = Env.get("URL_DB");
    String usuario = Env.get("DB_USER");
    String senha = Env.get("DB_PASSWORD");


        // Verifique se as variáveis estão corretas
        if (url != null && usuario != null && senha != null) {
            System.out.println("Conexão com banco bem-sucedida!");
            System.out.println("URL: " + url);
            System.out.println("Usuário: " + usuario);
            System.out.println("Senha: " + senha);
        } else {
            System.out.println("Erro ao ler variáveis do .env");
        }
    }
}
