/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proxecto_examen;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author A21PabloRF
 */
public class Examen {
    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Examen{" + "materia=" + materia + ", fecha=" + fecha + ", participantes=" + participantes + '}';
    }
    
    
    
}
