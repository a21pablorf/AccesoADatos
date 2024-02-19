package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

@Entity
public class InfoContenido {
    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "genero", length = 50)
    private String genero;

    @Column(name="pais",length = 2)
    private String pais;

    @Column(name="duracion")
    private int duracion;

    @Column(name="año")
    private int año;

    @Column(name="sinopsis")
    @Lob
    private String sinopsis;
}
