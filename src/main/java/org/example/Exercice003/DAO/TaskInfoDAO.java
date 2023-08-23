package org.example.Exercice003.DAO;

import org.example.Exercice003.entity.TaskInfo;

import javax.lang.model.element.Element;
import java.util.ArrayList;

public class TaskInfoDAO extends EntityDAO<TaskInfo> {
    @Override
    public boolean insert(Element T) {
        return super.insert(T);
    }

    @Override
    public Element get(Element T) {
        return super.get(T);
    }

    @Override
    public ArrayList<TaskInfo> getAll(Element T) {
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
