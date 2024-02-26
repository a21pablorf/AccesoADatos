package com.pepinho.ad.jpa.peliculas.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * CREATE TABLE IF NOT EXISTS `Ocupacion` (
 *   `ocupacion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `orde` int(11) NOT NULL,
 *   UNIQUE KEY `Ocupación#PX` (`ocupacion`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
 */
@Entity
public class Ocupacion {
    @Id
    private String ocupacion;
    private int orde;

    @OneToMany(mappedBy = "ocupacion")
    @Basic(fetch = jakarta.persistence.FetchType.LAZY)
    private List<PeliculaPersonaxe> peliculaPersonaxes;

    public Ocupacion() {
    }

    public Ocupacion(String ocupacion, int orde) {
        this.ocupacion = ocupacion;
        this.orde = orde;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getOrde() {
        return orde;
    }

    public void setOrde(int orde) {
        this.orde = orde;
    }

    public List<PeliculaPersonaxe> getPeliculaPersonaxes() {
        return peliculaPersonaxes;
    }

    public void setPeliculaPersonaxes(List<PeliculaPersonaxe> peliculaPersonaxes) {
        this.peliculaPersonaxes = peliculaPersonaxes;
    }

    public void addPeliculaPersonaxe(PeliculaPersonaxe peliculaPersonaxe) {
        this.peliculaPersonaxes.add(peliculaPersonaxe);
    }

    @Override
    public String toString() {
        return "[" + ocupacion + "] (" + orde + ')';
    }
}
