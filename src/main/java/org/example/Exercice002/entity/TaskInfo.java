package org.example.Exercice002.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "info")
public class TaskInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "info_id")
    private long id;

    private String taskDesc;

    private Date deadline;

    private int taskPriorityLevel;

    @OneToOne(mappedBy = "info")
    private Task task;

    public TaskInfo(){
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getTaskPriorityLevel() {
        return taskPriorityLevel;
    }

    public void setTaskPriorityLevel(int taskPriorityLevel) {
        this.taskPriorityLevel = taskPriorityLevel;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "id=" + id +
                ", taskDesc='" + taskDesc + '\'' +
                ", deadline=" + deadline +
                ", taskPriorityLevel=" + taskPriorityLevel +
                ", task=" + task +
                '}';
    }
}
