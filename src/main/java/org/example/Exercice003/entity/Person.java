package org.example.Exercice003.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private  int id;

    private String name;

    private  String first_name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private ArrayList<Task> taskList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
}
