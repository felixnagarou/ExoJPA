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
        em.close();
    }

    public static  List<ToDoList> displayAllTasks(){
        EntityManager em = emf.createEntityManager();
        List<ToDoList>  tasks;

        tasks = em.createQuery("SELECT t from ToDoList t", ToDoList.class).getResultList();

       // for (ToDoList t : tasks){
           // System.out.println(t);
       // }
        em.close();
        return tasks;

    }

    public static  void alterTaskStatus(long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToDoList task = em.find(ToDoList.class, id);
        task.setStatus(true);
        em.getTransaction().commit();
       // em.refresh(task);

    }

    public static void deleteTask(long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ToDoList task = em.find(ToDoList.class, id);
        em.remove(task);
        em.getTransaction().commit();
        //em.refresh(task);
        em.close();
    }

    public static void endConnection(){
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }




}
