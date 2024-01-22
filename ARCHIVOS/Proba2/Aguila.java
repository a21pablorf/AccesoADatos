import java.io.Serializable;

class Paxaro {
    protected transient String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Paxaro() {
        this.nome = "Otto";
    }
}

public class Aguila extends Paxaro implements Serializable {
    {
        this.nome = "Olivia";
    }

    public Aguila() {
        this.nome = "Bridget";
    }

    public static void main(String[] args) {
        var e = new Aguila();
        e.nome = "Adeline";
    }
}