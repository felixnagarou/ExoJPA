package org.example.Exercice002.entity;

import javax.persistence.*;


@Entity
@Table(name = "task")
public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "task_id")
        private long id;

        @Column(name = "title" )
        private String title;

        @Column (name = "status")
        private boolean status;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "task_id", nullable = false, unique = true)
        private TaskInfo info;

        public  Task(){
        }

        public Task(String title, boolean status){
            this.title = title;
            this.status = status;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", info=" + info +
                '}';
    }
}

