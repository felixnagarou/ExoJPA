package org.example.Exercice002.entity;

import org.example.Exercice001.EntityManagement.entity.ToDoList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class TaskDAO implements EntityDAO{

    private EntityManagerFactory emf;

    @Override
    public boolean insertTask(Task task) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Task> displayAllTasks() {
        EntityManager em = emf.createEntityManager();
        List<ToDoList>  tasks;

        tasks = em.createQuery("SELECT t from ToDoList t", ToDoList.class).getResultList();
        em.close();

        return null;
    }

    @Override
    public boolean deleteTask(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ToDoList task = em.find(ToDoList.class, id);
        em.remove(task);
        em.getTransaction().commit();
        em.close();

        return false;
    }

    @Override
    public boolean alterTaskStatus(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToDoList task = em.find(ToDoList.class, id);
        task.setStatus(true);
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public TaskInfo displayDescription(long id) {
        EntityManager em = emf.createEntityManager();
        TaskInfo info =  (TaskInfo) em.createNativeQuery("SELECT taskDesc from info where task_id = task(task_id)", TaskInfo.class).getSingleResult();
        info.getTaskDesc();
        return null;
    }

    @Override
    public TaskInfo displayDeadline(long id) {
        EntityManager em = emf.createEntityManager();
        TaskInfo info =  (TaskInfo) em.createNativeQuery("SELECT deadline from info where task_id = task(task_id)", TaskInfo.class).getSingleResult();
        info.getDeadline();

        return info;
    }

    @Override
    public TaskInfo displayPriority(long id) {
        EntityManager em = emf.createEntityManager();
        TaskInfo info = (TaskInfo) em.createNativeQuery("SELECT taskPriorityLevel from info where task_id = task(task_id)", TaskInfo.class).getSingleResult();
        info.getTaskPriorityLevel();

        return info;
    }


    @Override
    public boolean endConnection() {
        return false;
    }


}
