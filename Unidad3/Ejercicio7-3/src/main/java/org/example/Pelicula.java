package org.example;

import jakarta.persistence.*;

@Entity
public class Pelicula {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int idPelicula;

     @Embedded
     @AttributeOverride(name = "pais", column = @Column(name = "paisPelicula"))
     private InfoContenido informacion;


     public Pelicula() {
     }

     public Pelicula(InfoContenido informacion) {
          this.informacion = informacion;
     }

     public int getIdPelicula() {
          return idPelicula;
     }

        public void setIdPelicula(int idPelicula) {
            this.idPelicula = idPelicula;
        }

     public InfoContenido getInformacion() {
          return informacion;
     }

     public void setInformacion(InfoContenido informacion) {
          this.informacion = informacion;
     }
}
