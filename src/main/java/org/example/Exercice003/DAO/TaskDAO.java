package org.example.Exercice003.DAO;

import org.example.Exercice003.entity.Category;
import org.example.Exercice003.entity.Person;
import org.example.Exercice003.entity.Task;
import org.example.Exercice003.utils.IHM;

import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO extends EntityDAO<Task>{
    @Override
    public boolean insert(Task element) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        element = new Task();
        em.persist(element);
        return false;
    }

    @Override
    public Task get(long id) {
        EntityManager em = emf.createEntityManager();
        Task element = em.find(Task.class,id);
        return element;
    }

    @Override
    public List<Task> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Task> list;
        list =  em.createNativeQuery("SELECT * FROM task", Task.class).getResultList();
        return list;
    }

    @Override
    public boolean update(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Task task = em.find(Task.class,id);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean remove(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        em.remove(task);
        em.getTransaction().commit();
        em.close();
        return false;
    }
}
