package org.example;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nba");

        // Crear una instancia del EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Departamento departamento = new Departamento("Ventas");
        Departamento departamento2 = new Departamento("Marketing");
        Persona persona = new Persona("Juan");

        persona.setDepartamento(departamento2);
        departamento.setPersona(persona);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(departamento);
            entityManager.persist(departamento2);
            entityManager.persist(persona);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error en la transaccion: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
                System.out.println("Rollback realizado");
            }
        }finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
