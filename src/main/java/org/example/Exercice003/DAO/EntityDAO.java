package org.example.Exercice003.DAO;

import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public abstract class EntityDAO<T> {
    public  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres2");

    public EntityDAO(){
    }


    public abstract boolean insert(T element);

    public abstract T get(long id);

    public abstract List<T> getAll();


    public abstract boolean update(long id);

    public abstract boolean remove(long id);

}
