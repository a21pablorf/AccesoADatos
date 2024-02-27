package com.pepinho.ad.jpa.peliculas;

import com.pepinho.ad.jpa.peliculas.model.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.h2.util.json.JsonConstructorUtils;

import java.util.List;

public class AppPeliculas {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        TypedQuery<Pelicula> q=em.createQuery("SELECT p FROM Pelicula p WHERE p.castelan LIKE :titulo", Pelicula.class);
        q.setParameter("titulo","%amor%");
        List<Pelicula> resultado=q.getResultList();
        System.out.println(resultado);

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }

}
