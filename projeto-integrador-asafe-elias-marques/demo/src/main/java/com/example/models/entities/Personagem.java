package com.example.models.entities;

public class Personagem {
    int id;
    String nome;
    String desc;
    int ST;
    int DX;
    int IQ;
    int HT;
    int fadiga;
    String dano;
    float vel;
    int vida;
    int pontos_de_atributo;

    public Personagem(int id, String nome, String desc, int sT, int dX, int iQ, int hT, int fadiga, String dano, float vel, int vida, int pontos_de_atributo) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        ST = sT;
        DX = dX;
        IQ = iQ;
        HT = hT;
        this.fadiga = ST;
        this.dano = definirDano();
        this.vel = (HT + DX) / 4;
        this.vida = HT;
        this.pontos_de_atributo = pontos_de_atributo;
    }

    public String definirDano() {
        if (ST >= 1 && ST <= 2) {
            return "1D-5";
        } else if (ST >= 3 && ST <= 5) {
            return "1D-4";
        } else if (ST >= 6 && ST <= 8) {
            return "1D-3";
        } else if (ST >= 9 && ST <= 11) {
            return "1D-2";
        } else if (ST >= 12 && ST <= 15) {
            return "1D-1";
        } else if (ST >= 16 && ST <= 20) {
            return "1D";
        } else if (ST >= 21 && ST <= 25) {
            return "1D+1";
        } else if (ST >= 26 && ST <= 30) {
            return "1D+2";
        } else if (ST >= 31 && ST <= 35) {
            return "2D-1";
        } else if (ST >= 36 && ST <= 40) {
            return "2D";
        } else if (ST >= 41 && ST <= 45) {
            return "2D+1";
        } else if (ST >= 46 && ST <= 50) {
            return "2D+2";
        } else if (ST >= 51 && ST <= 55) {
            return "3D-1";
        } else {
            return "3D";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getST() {
        return ST;
    }

    public void setST(int sT) {
        ST = sT;
    }

    public int getDX() {
        return DX;
    }

    public void setDX(int dX) {
        DX = dX;
    }

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int iQ) {
        IQ = iQ;
    }

    public int getHT() {
        return HT;
    }

    public void setHT(int hT) {
        HT = hT;
    }

    public float getVel() {
        return vel;
    }

    public void setVel(float vel) {
        this.vel = vel;
    }

    public int getFadiga() {
        return fadiga;
    }

    public void setFadiga(int fadiga) {
        this.fadiga = fadiga;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public int getPontos_de_atributo() {
        return pontos_de_atributo;
    }

    public void setPontos_de_atributo(int pontos_de_atributo) {
        this.pontos_de_atributo = pontos_de_atributo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    
}
