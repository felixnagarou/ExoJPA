package org.example.Exercice003.DAO;

import org.example.Exercice003.entity.Category;
import org.example.Exercice003.entity.Person;
import org.example.Exercice003.entity.TaskInfo;

import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TaskInfoDAO extends EntityDAO<TaskInfo> {


    @Override
    public boolean insert(TaskInfo element) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        element = new TaskInfo();
        em.persist(element);
        return false;
    }

    @Override
    public TaskInfo get(long id) {
        EntityManager em = emf.createEntityManager();
        TaskInfo element = em.find(TaskInfo.class,id);
        return element;
    }

    @Override
    public List<TaskInfo> getAll() {
        EntityManager em = emf.createEntityManager();
        List<TaskInfo> list;
        list =  em.createNativeQuery("SELECT * FROM info", TaskInfo.class).getResultList();
        return list;
    }

    @Override
    public boolean update(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TaskInfo info = em.find(TaskInfo.class,id);
        info.setDeadline();
        em.getTransaction().commit();
        em.close();
        return false;
        return false;
    }

    @Override
    public boolean remove(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TaskInfo info = em.find(TaskInfo.class, id);
        em.remove(info);
        em.getTransaction().commit();
        em.close();
        return false;
    }
}
