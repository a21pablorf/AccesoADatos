package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");

        // Crear una instancia del EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        InfoContenido infoContenido = new InfoContenido("The Godfather", "Drama", "US", 175, 1972, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        Pelicula pelicula = new Pelicula(infoContenido);

        // Iniciar una transacción
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            // Persistir las entidades
            //entityManager.persist(infoContenido);
            entityManager.persist(pelicula);

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // Si ocurre un error, hacer rollback de la transacción
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
