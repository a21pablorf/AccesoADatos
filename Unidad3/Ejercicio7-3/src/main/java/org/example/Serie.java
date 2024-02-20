package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idSerie;

    @Embedded
    private InfoContenido infoContenido;

    @Column(name = "fechaEstreno", length = 10)
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate fechaEstreno;

    private int temporadas;

    private int capitulos;

    @ElementCollection
    @CollectionTable(name = "directores", joinColumns = @JoinColumn(name = "idSerie"))
    private List<String> directores;

    public Serie() {
    }

    public Serie(InfoContenido infoContenido, LocalDate fechaEstreno, int temporadas, int capitulos, List<String> directores) {
        this.infoContenido = infoContenido;
        this.fechaEstreno = fechaEstreno;
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.directores = directores;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public InfoContenido getInfoContenido() {
        return infoContenido;
    }

    public void setInfoContenido(InfoContenido infoContenido) {
        this.infoContenido = infoContenido;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public List<String> getDirectores() {
        return directores;
    }

    public void setDirectores(List<String> directores) {
        this.directores = directores;
    }
}
