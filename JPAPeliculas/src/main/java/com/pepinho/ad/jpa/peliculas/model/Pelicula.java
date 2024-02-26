package com.pepinho.ad.jpa.peliculas.model;

import jakarta.persistence.*;
import java.util.List;

/**
 *
 CREATE TABLE IF NOT EXISTS `pelicula` (
 `idPelicula` int(10) NOT NULL,
 `musica` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
 `orixinal` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 `ingles` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 `castelan` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 `xenero` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
 `anoInicio` smallint(5) DEFAULT NULL,
 `anoFin` smallint(5) DEFAULT NULL,
 `pais` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 `duración` smallint(5) DEFAULT NULL,
 `outrasDuracions` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
 `cor` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
 `son` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL,
 `video` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
 `laserDisc` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
 `texto` longtext COLLATE utf8_spanish_ci,
 `poster` longblob,
 `revisado` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
 PRIMARY KEY (`idPelicula`),
 UNIQUE KEY `Película#PX` (`idPelicula`),
 KEY `Género` (`xenero`),
 KEY `GéneroPelícula` (`xenero`),
 KEY `OriginalAnyo` (`orixinal`,`anoFin`),
 KEY `País` (`pais`),
 KEY `PaísPelícula` (`pais`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

 */
@Entity
@Table(name = "Pelicula")
@NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.castelan LIKE :titulo")
public class Pelicula {
    @Id
    private Integer idPelicula;
    @Column(length = 50, nullable = true, unique = false, name = "musica")
    private String musica;
    private String orixinal;
    private String ingles;
    private String castelan;
    private String xenero;
    private Short anoInicio;
    private Short anoFin;
    private String pais;
    @Column(name = "duracion")
    private Short duracion;
    private String outrasDuracions;
    private String cor;
    private String son;
    private String video;
//    private String laserDisc;
    @Lob
    private String texto;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] poster;
    private String revisado;

    @OneToMany(mappedBy = "pelicula")
    @Basic(fetch = jakarta.persistence.FetchType.LAZY)
    @OrderBy("ocupacion DESC")
    private List<PeliculaPersonaxe> personaxes;


    public Pelicula() {
    }

    public Pelicula(Integer idPelicula, String musica, String orixinal, String ingles, String castelan, String xenero, Short anoInicio, Short anoFin, String pais, Short duracion, String outrasDuracions, String cor, String son, String video, String laserDisc, String texto, byte[] poster, String revisado) {
        this.idPelicula = idPelicula;
        this.musica = musica;
        this.orixinal = orixinal;
        this.ingles = ingles;
        this.castelan = castelan;
        this.xenero = xenero;
        this.anoInicio = anoInicio;
        this.anoFin = anoFin;
        this.pais = pais;
        this.duracion = duracion;
        this.outrasDuracions = outrasDuracions;
        this.cor = cor;
        this.son = son;
        this.video = video;
//        this.laserDisc = laserDisc;
        this.texto = texto;
        this.poster = poster;
        this.revisado = revisado;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

//    public String getLaserDisc() {
//        return laserDisc;
//    }
//
//    public void setLaserDisc(String laserDisc) {
//        this.laserDisc = laserDisc;
//    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getOrixinal() {
        return orixinal;
    }

    public void setOrixinal(String orixinal) {
        this.orixinal = orixinal;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getCastelan() {
        return castelan;
    }

    public void setCastelan(String castelan) {
        this.castelan = castelan;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public Short getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Short anoInicio) {
        this.anoInicio = anoInicio;
    }

    public Short getAnoFin() {
        return anoFin;
    }

    public void setAnoFin(Short anoFin) {
        this.anoFin = anoFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public String getOutrasDuracions() {
        return outrasDuracions;
    }

    public void setOutrasDuracions(String outrasDuracions) {
        this.outrasDuracions = outrasDuracions;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<PeliculaPersonaxe> getPersonaxes() {
        return personaxes;
    }

    public void setPersonaxes(List<PeliculaPersonaxe> personaxes) {
        this.personaxes = personaxes;
    }

    public void addPersonaxe(PeliculaPersonaxe personaxe) {
        this.personaxes.add(personaxe);
    }


    public String getPersonaxesString() {
        StringBuilder sb = new StringBuilder();
        for (PeliculaPersonaxe personaxe : personaxes) {
            sb.append(personaxe);
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return  "[" + idPelicula +
                "] " + castelan +
                ", ('" + orixinal + ')' +
                " (" + xenero +
                " de " + anoFin + "), '" + pais + '\'' +
                " " + duracion +
                " minutos. " + System.lineSeparator() +
                getPersonaxesString();
    }
}
