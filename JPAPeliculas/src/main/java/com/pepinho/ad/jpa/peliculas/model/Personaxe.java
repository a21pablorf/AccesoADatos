package com.pepinho.ad.jpa.peliculas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * CREATE TABLE IF NOT EXISTS `Personaxe` (
 *   `idPersonaxe` int(10) NOT NULL,
 *   `importancia` varchar(16) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `nome` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `nomeOrdenado` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `nomeOrixinal` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `sexo` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `dataNacemento` datetime DEFAULT NULL,
 *   `paisNacemento` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `cidadeNacemento` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `dataDefuncion` datetime DEFAULT NULL,
 *   `paisDefuncion` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `cidadeDefuncion` varchar(125) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `estudio` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `bio` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   `texto` longtext COLLATE utf8_spanish_ci,
 *   `textoFilmografia` longtext COLLATE utf8_spanish_ci,
 *   `revisado` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
 *   PRIMARY KEY (`idPersonaxe`),
 *   UNIQUE KEY `Personaje#PX` (`idPersonaxe`),
 *   KEY `NomPersona` (`nome`),
 *   KEY `País de defunción` (`paisDefuncion`),
 *   KEY `País de nacimiento` (`paisNacemento`),
 *   KEY `PaísPersonaje` (`paisNacemento`),
 *   KEY `PaísPersonaje1` (`paisDefuncion`),
 *   KEY `SexoPersonaxe` (`sexo`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
 */
@Entity
public class Personaxe {
    @Id
    private int idPersonaxe;
    private String importancia;
    private String nome;
    private String nomeOrdenado;
    private String nomeOrixinal;
    private String sexo;
    private LocalDateTime dataNacemento;
    private String paisNacemento;
    private String cidadeNacemento;
    private LocalDateTime dataDefuncion;
    private String paisDefuncion;
    private String cidadeDefuncion;
    private String estudio;
    private String bio;
    @Lob
    private String texto;
    @Lob
    private String textoFilmografia;
    private String revisado;

    @OneToMany(mappedBy = "personaxe")
    @Basic(fetch = FetchType.LAZY)
    private List<PeliculaPersonaxe> peliculas;

    public Personaxe() {
    }

    public Personaxe(int idPersonaxe, String importancia, String nome, String nomeOrdenado, String nomeOrixinal, String sexo, LocalDateTime dataNacemento, String paisNacemento, String cidadeNacemento, LocalDateTime dataDefuncion, String paisDefuncion, String cidadeDefuncion, String estudio, String bio, String texto, String textoFilmografia, String revisado) {
        this.idPersonaxe = idPersonaxe;
        this.importancia = importancia;
        this.nome = nome;
        this.nomeOrdenado = nomeOrdenado;
        this.nomeOrixinal = nomeOrixinal;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.paisNacemento = paisNacemento;
        this.cidadeNacemento = cidadeNacemento;
        this.dataDefuncion = dataDefuncion;
        this.paisDefuncion = paisDefuncion;
        this.cidadeDefuncion = cidadeDefuncion;
        this.estudio = estudio;
        this.bio = bio;
        this.texto = texto;
        this.textoFilmografia = textoFilmografia;
        this.revisado = revisado;
    }

    public int getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(int idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeOrdenado() {
        return nomeOrdenado;
    }

    public void setNomeOrdenado(String nomeOrdenado) {
        this.nomeOrdenado = nomeOrdenado;
    }

    public String getNomeOrixinal() {
        return nomeOrixinal;
    }

    public void setNomeOrixinal(String nomeOrixinal) {
        this.nomeOrixinal = nomeOrixinal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDateTime dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public String getPaisNacemento() {
        return paisNacemento;
    }

    public void setPaisNacemento(String paisNacemento) {
        this.paisNacemento = paisNacemento;
    }

    public String getCidadeNacemento() {
        return cidadeNacemento;
    }

    public void setCidadeNacemento(String cidadeNacemento) {
        this.cidadeNacemento = cidadeNacemento;
    }

    public LocalDateTime getDataDefuncion() {
        return dataDefuncion;
    }

    public void setDataDefuncion(LocalDateTime dataDefuncion) {
        this.dataDefuncion = dataDefuncion;
    }

    public String getPaisDefuncion() {
        return paisDefuncion;
    }

    public void setPaisDefuncion(String paisDefuncion) {
        this.paisDefuncion = paisDefuncion;
    }

    public String getCidadeDefuncion() {
        return cidadeDefuncion;
    }

    public void setCidadeDefuncion(String cidadeDefuncion) {
        this.cidadeDefuncion = cidadeDefuncion;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoFilmografia() {
        return textoFilmografia;
    }

    public void setTextoFilmografia(String textoFilmografia) {
        this.textoFilmografia = textoFilmografia;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public List<PeliculaPersonaxe> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaPersonaxe> peliculas) {
        this.peliculas = peliculas;
    }

    public void addPelicula(PeliculaPersonaxe pelicula) {
        this.peliculas.add(pelicula);
    }


    @Override
    public String toString() {
        return "Personaxe{" +
                "idPersonaxe=" + idPersonaxe +
                ", nome='" + nome + '\'' +
                ", nomeOrdenado='" + nomeOrdenado + '\'' +
                ", nomeOrixinal='" + nomeOrixinal + '\'' +
                ", dataNacemento=" + dataNacemento +
                '}';
    }
}
