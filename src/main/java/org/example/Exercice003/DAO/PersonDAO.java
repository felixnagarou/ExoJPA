package org.example.Exercice003.DAO;

import org.example.Exercice003.entity.Person;

import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends EntityDAO<Person> {
    @Override
    public boolean insert(Person element) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        element = new Person();
        em.persist(element);
        return true;
    }

    @Override
    public Person get(long id) {
        EntityManager em = emf.createEntityManager();
        Person element = em.find(Person.class,id);
        return element;
    }

    @Override
    public List<Person> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Person> list;
        list =  em.createNativeQuery("SELECT * FROM person", Person.class).getResultList();
        return list;
    }

    @Override
    public boolean update(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class,id);
        person.setName();
        person.setFirst_name();
        person.setTaskList();
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public boolean remove(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.remove(person);
        em.getTransaction().commit();
        em.close();
        return false;
    }
}