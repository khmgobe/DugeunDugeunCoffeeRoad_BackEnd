package com.easycoffee.backend.coffeebook.repository;

import com.easycoffee.backend.coffeebook.entity.CoffeeBookLike;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoffeeBookLikeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(CoffeeBookLike coffeeBookLike) {
        em.persist(coffeeBookLike);
    }

    public List<CoffeeBookLike> find() {
        return em.createQuery("select c from CoffeeBookLike c", CoffeeBookLike.class).getResultList();
    }
}
