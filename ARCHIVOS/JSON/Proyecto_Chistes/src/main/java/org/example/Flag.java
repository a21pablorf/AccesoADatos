package org.example;

public enum Flag {
    NSFW("trabajo"),RELIGIOSO("religioso"),POLITICO("Politico"),
    RACISTA("Racista"),SEXISTA("Sexista"),EXP("Explicito");

    private String nome;

    public String getNome() {
        return nome;
    }

    Flag(String nome) {
        this.nome = nome;
    }
}
