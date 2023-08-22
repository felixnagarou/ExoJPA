package org.example.Exercice002.entity;

import java.util.List;

public interface EntityDAO {

    public boolean insertTask(Task task);

    public List<Task> displayAllTasks();

    public boolean deleteTask(long id);

    public boolean alterTaskStatus(long id);

    public TaskInfo displayDescription(long id);

    public TaskInfo displayDeadline(long id);

    public TaskInfo displayPriority(long id);
    public boolean endConnection();


}
