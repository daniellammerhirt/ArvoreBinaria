package com.info.arvorebinaria.model.db;

public class No {
    private Integer numero;

    private No direita;
    private No esquerda;


    public No(Integer numero){
        this.numero=numero;
        this.direita=null;
        this.esquerda=null;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}
