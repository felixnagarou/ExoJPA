package org.example.Exercice003.DAO;

import org.example.Exercice003.entity.Task;

import javax.lang.model.element.Element;
import java.util.ArrayList;

public class TaskDAO extends EntityDAO<Task>{
    @Override
    public boolean insert(Element T) {
        return super.insert(T);
    }

    @Override
    public Element get(Element T) {
        return super.get(T);
    }

    @Override
    public ArrayList<Task> getAll(Element T) {
        return super.getAll(T);
    }

    @Override
    public boolean update(long id) {
        return super.update(id);
    }

    @Override
    public boolean remove(long id) {
        return super.remove(id);
    }
}
