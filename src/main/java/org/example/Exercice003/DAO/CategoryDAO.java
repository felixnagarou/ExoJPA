package org.example.Exercice003.DAO;

import org.example.Exercice003.entity.Category;
import org.example.Exercice003.entity.Person;

import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends EntityDAO<Category> {
    @Override
    public boolean insert(Category element) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        element = new Category();
        em.persist(element);
        em.close();
        return true;
    }

    @Override
    public Category get(long id) {
        EntityManager em = emf.createEntityManager();
        Category element = em.find(Category.class,id);
        return element;
    }

    @Override
    public List<Category> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Category> list;
        list =  em.createNativeQuery("SELECT * FROM category", Category.class).getResultList();
        return list;
    }

    @Override
    public boolean update(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find(Category.class,id);
        category.setName();
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public boolean remove(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        em.remove(category);
        em.getTransaction().commit();
        em.close();
        return false;
    }
}
