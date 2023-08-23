package org.example.Exercice003.DAO;

import javax.lang.model.element.Element;
import java.util.ArrayList;

public abstract class EntityDAO<T> {

    public boolean insert(Element T){
        return true;
    }

    public Element get(Element T){
        Element t = null;
        return t;

    }

    public ArrayList<T>  getAll(Element T){
        ArrayList<T> list = null;
        return list;
    }

    public boolean update(long id){
        return true;
    }

    public boolean remove(long id){
        return true;
    }

}
