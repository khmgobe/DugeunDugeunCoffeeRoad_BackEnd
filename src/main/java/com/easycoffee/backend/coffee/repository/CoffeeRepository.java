package com.easycoffee.backend.coffee.repository;

import com.easycoffee.backend.coffee.dto.CoffeeResponseDto;
import com.easycoffee.backend.coffee.entity.Coffee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CoffeeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Coffee coffee) {
        em.persist(coffee);
    }

    public Coffee find(Long id) {
        return em.find(Coffee.class, id);
    }

    public void update(Coffee coffee) {
        em.merge(coffee);
    }

    public void remove(Long id) {
        em.createQuery("delete from Coffee c where c.id = : id ")
                .setParameter("id", id)
                .executeUpdate();
        em.flush();
        em.clear();
    }
}
