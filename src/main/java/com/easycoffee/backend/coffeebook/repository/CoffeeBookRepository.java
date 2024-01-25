package com.easycoffee.backend.coffeebook.repository;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoffeeBookRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(CoffeeBook coffeeBook) {
        em.persist(coffeeBook);
    }

    public CoffeeBook findById(Long id) {
        return em.find(CoffeeBook.class, id);
    }

    public List<CoffeeBook> find() {
         return  em.createQuery("select c from CoffeeBook c", CoffeeBook.class).getResultList();
    }

    public void update(CoffeeBook coffeeBook) {
        em.merge(coffeeBook);
    }

    public void remove(Long id) {
        em.createQuery("delete from CoffeeBook c where c.id =: id ").
                setParameter("id", id).executeUpdate();

        em.flush();
        em.clear();
    }
}
