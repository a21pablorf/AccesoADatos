package org.example;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "persona")
@Entity(name = "Persona")
public class Persona implements Serializable {
    //A clave primaria de persona é a clave do departamento co que está relacionada. En realidad non ten clave primaria "propia".

    @Id
    @Column(name = "id_persona")
    private int idPersona;
    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_persona")
    private Departamento departamento;

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
