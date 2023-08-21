package org.example.EntityManagement;

import org.example.entity.ToDoList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Management {

    private static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("jpa_demo_postgres2");

    public Management(){
    }

    public static void insertTask(String title, boolean status){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        ToDoList toDo = new ToDoList(title, status);
        em.persist(toDo);
        em.getTransaction().commit();
    }

    public static  List<ToDoList> displayAllTasks(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<ToDoList>  tasks = null;

        tasks = em.createQuery("SELECT t from ToDoList t", ToDoList.class).getResultList();

        for (ToDoList t : tasks){
            System.out.println(t);
        }
        return tasks;
    }

    public static  void alterTaskStatus(long id){
        EntityManager em = emf.createEntityManager();
        ToDoList task = em.find(ToDoList.class, id);
        task.setStatus(true);
        em.refresh(task);
    }

    public static void deleteTask(long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction();

        ToDoList task = em.find(ToDoList.class, id);
        em.remove(task);
        em.refresh(task);
    }

    public static void endConnection(){
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }




}
