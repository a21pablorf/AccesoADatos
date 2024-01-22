package org.example;

public class Poeta {
    private String nome;
    private int idade;

    private String categoria;

    public Poeta() {}

    public Poeta(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Poeta{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
