package dev.k1goms.UserControl.model.task;

import dev.k1goms.UserControl.enums.Priority;
import dev.k1goms.UserControl.enums.Status;
import dev.k1goms.UserControl.model.user.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor //Nao se cria um allargs, porque o id é gerado automaticamente pelo banco
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

    public TaskModel(String name, Priority priority, Status status, List<UserModel> users) {
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.users = users;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", users=" + users.stream().map(UserModel::getId).toList() +
                '}';
    }
}
