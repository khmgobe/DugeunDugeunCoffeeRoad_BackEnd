package com.easycoffee.backend.coffeebean.repository;

import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CoffeeBeanRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(CoffeeBean coffeeBean) {
        em.persist(coffeeBean);
    }
}
