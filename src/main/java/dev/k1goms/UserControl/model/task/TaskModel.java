package dev.k1goms.UserControl.model.task;

import dev.k1goms.UserControl.enums.Priority;
import dev.k1goms.UserControl.enums.Status;
import dev.k1goms.UserControl.model.user.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    //uma task pode ter varios users
    @OneToMany(mappedBy = "task")
    private List<UserModel> users;

    public TaskModel() {
    }

    public TaskModel(String name, Priority priority, Status status, List<UserModel> users) {
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
