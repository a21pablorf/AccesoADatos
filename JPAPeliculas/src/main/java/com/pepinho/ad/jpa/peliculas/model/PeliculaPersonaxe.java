package com.pepinho.ad.jpa.peliculas.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.*;

/**
 *
 CREATE TABLE IF NOT EXISTS `PeliculaPersonaxe` (
 `idPersonaxe` int(10) NOT NULL,
 `idPelicula` int(10) NOT NULL,
 `ocupacion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
 `personaxeInterpretado` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
 PRIMARY KEY (`idPelicula`,`idPersonaxe`,`ocupacion`),
 KEY `OcupaciónPelícula_Personaje` (`ocupacion`),
 KEY `PersonajePelícula_Personaje` (`idPersonaxe`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
 */
@Entity
public class PeliculaPersonaxe {

    @EmbeddedId
    private IdPeliculaPersonaxe idPeliculaPersonaxe;

    @ManyToOne
    @MapsId("idPelicula")
    @JoinColumn(name = "idPelicula")
    private Pelicula pelicula;

    @ManyToOne
    @MapsId("idPersonaxe")
    @JoinColumn(name = "idPersonaxe")
    private Personaxe personaxe;

    @ManyToOne
    @MapsId("ocupacion")
    @JoinColumn(name = "ocupacion")
    private Ocupacion ocupacion;

    private String personaxeInterpretado;

    public PeliculaPersonaxe() {
    }

    public PeliculaPersonaxe(IdPeliculaPersonaxe idPeliculaPersonaxe, String personaxeInterpretado) {
        this.idPeliculaPersonaxe = idPeliculaPersonaxe;
        this.personaxeInterpretado = personaxeInterpretado;
    }

    public IdPeliculaPersonaxe getIdPeliculaPersonaxe() {
        return idPeliculaPersonaxe;
    }

    public void setIdPeliculaPersonaxe(IdPeliculaPersonaxe idPeliculaPersonaxe) {
        this.idPeliculaPersonaxe = idPeliculaPersonaxe;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }


    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }


    public Personaxe getPersonaxe() {
        return personaxe;
    }

    public void setPersonaxe(Personaxe personaxe) {
        this.personaxe = personaxe;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getPersonaxeInterpretado() {
        return personaxeInterpretado;
    }

    public void setPersonaxeInterpretado(String personaxeInterpretado) {
        this.personaxeInterpretado = personaxeInterpretado;
    }

    @Override
    public String toString() {
        return " [" + personaxe +
                "] (" + ocupacion +
                ") as '" + personaxeInterpretado + '\'';
    }
}
