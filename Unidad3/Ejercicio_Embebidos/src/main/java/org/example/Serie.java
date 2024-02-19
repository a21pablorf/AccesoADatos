package org.example;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSerie;

    @ManyToOne
    @JoinColumn(name = "info_contenido_id")
    private InfoContenido informacion;

    private LocalDate fechaEstreno;
    private int temporadas;
    private int capitulos;
    private List<String> directores;

    // Constructor, getters y setters
    public Serie() {
    }

    public Serie(InfoContenido informacion, LocalDate fechaEstreno, int temporadas, int capitulos, List<String> directores) {
        this.informacion = informacion;
        this.fechaEstreno = fechaEstreno;
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.directores = directores;
    }

    public long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(long idSerie) {
        this.idSerie = idSerie;
    }

    public InfoContenido getInformacion() {
        return informacion;
    }

    public void setInformacion(InfoContenido informacion) {
        this.informacion = informacion;
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
