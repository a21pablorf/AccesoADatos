package org.example;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "departamento")   // This is the name of the table in the database
@Entity(name = "Departamento")  // This is the name of the class in Java
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private int idDepartamento;
    @Column(name = "nombre")
    private String nombre;

    @OneToOne(mappedBy = "departamento")
    private Persona persona;

    public Departamento() {
    }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
