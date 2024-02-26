package com.pepinho.ad.jpa.peliculas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class IdPeliculaPersonaxe implements java.io.Serializable {
    @Column(name = "idPelicula")
    private Integer idPelicula;

    @Column(name = "idPersonaxe")
    private Integer idPersonaxe;

    @Column(name = "ocupacion")
    private String ocupacion;

    public IdPeliculaPersonaxe() {
    }

    public IdPeliculaPersonaxe(Integer idPelicula, Integer idPersonaxe, String ocupacion) {
        this.idPelicula = idPelicula;
        this.idPersonaxe = idPersonaxe;
        this.ocupacion = ocupacion;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(Integer idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdPeliculaPersonaxe that = (IdPeliculaPersonaxe) o;
        return Objects.equals(idPelicula, that.idPelicula) && Objects.equals(idPersonaxe, that.idPersonaxe) && Objects.equals(ocupacion, that.ocupacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, idPersonaxe, ocupacion);
    }

    @Override
    public String toString() {
        return "IdPeliculaPersonaxe{" + "idPelicula=" + idPelicula + ", idPersonaxe=" + idPersonaxe + ", ocupacion=" + ocupacion + '}';
    }
}
