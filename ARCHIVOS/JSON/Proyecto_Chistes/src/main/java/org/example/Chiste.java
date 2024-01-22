package org.example;

import java.util.ArrayList;
import java.util.List;

public class Chiste {
//    private boolean error;
    private String categoria;
    private String tipo;
    private String pregunta;
    private String respuesta;
    private List<Flag> flags;
    private boolean seguro;
    private int id;
    private String idioma;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Chiste(String categoria, String tipo, String pregunta, String respuesta, boolean seguro, int id, String idioma) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.seguro = seguro;
        this.id = id;
        this.idioma = idioma;
    }

    public Chiste() {
        flags=new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder(
                "Chiste{" +
                        "Categoria: " + categoria + '\'' + System.lineSeparator()+
                        "Tipo: " + tipo + '\'' +System.lineSeparator()+
                        "Pregunta: " + pregunta + '\'' +System.lineSeparator()+
                        "Respuesta: " + respuesta + '\'' +System.lineSeparator()+
                        "Seguro: " + seguro +System.lineSeparator()+
                        "Id: " + id +System.lineSeparator()+
                        "Iidioma: " + idioma + '\'' +System.lineSeparator()
        );
        flags.forEach(b -> sb.append(b.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}
