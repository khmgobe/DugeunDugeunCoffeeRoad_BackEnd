package com.easycoffee.backend.coffee.repository;

import com.easycoffee.backend.coffee.entity.Coffee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoffeeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Coffee coffee) {
        em.persist(coffee);
    }

    public Coffee findById(Long id) {
        return em.createQuery("select c from Coffee c join fetch c.coffeeBean where c.id =: id ", Coffee.class).setParameter("id", id).getSingleResult();
    }

    public List<Coffee> find() {
        return em.createQuery("select distinct c from Coffee c join fetch c.coffeeBean", Coffee.class).getResultList();
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
