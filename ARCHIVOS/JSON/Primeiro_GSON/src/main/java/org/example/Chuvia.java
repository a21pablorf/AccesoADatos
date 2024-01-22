package org.example;

public class Chuvia {

    private String nome;
    private double cantidade;

    public Chuvia(String nome, double cantidade) {
        this.nome = nome;
        this.cantidade = cantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCantidade() {
        return cantidade;
    }

    public void setCantidade(double cantidade) {
        this.cantidade = cantidade;
    }

    @Override
    public String toString() {
        return "Chuvia " + System.lineSeparator()+
                "nome='" + nome + '\'' +
                ", cantidade=" + cantidade;
    }
}
