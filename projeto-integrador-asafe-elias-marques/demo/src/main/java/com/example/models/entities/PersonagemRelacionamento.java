package com.example.models.entities;

public class PersonagemRelacionamento {
    int id_personagem_fk_pk;
    int id_relacionado_fk_pk;

    public PersonagemRelacionamento(int id_personagem_fk_pk, int id_relacionado_fk_pk) {
        this.id_personagem_fk_pk = id_personagem_fk_pk;
        this.id_relacionado_fk_pk = id_relacionado_fk_pk;
    }

    public int getId_personagem_fk_pk() {
        return id_personagem_fk_pk;
    }

    public void setId_personagem_fk_pk(int id_personagem_fk_pk) {
        this.id_personagem_fk_pk = id_personagem_fk_pk;
    }

    public int getId_relacionado_fk_pk() {
        return id_relacionado_fk_pk;
    }

    public void setId_relacionado_fk_pk(int id_relacionado_fk_pk) {
        this.id_relacionado_fk_pk = id_relacionado_fk_pk;
    }
}
