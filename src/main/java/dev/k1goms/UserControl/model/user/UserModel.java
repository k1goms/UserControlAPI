package dev.k1goms.UserControl.model.user;

import dev.k1goms.UserControl.model.task.TaskModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor //Nao se cria um allargs, porque o id é gerado automaticamente pelo banco
@Entity
@Table(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private Integer age;

    //um user tem apenas uma task, mas varios users podem estar na mesma task
    @ManyToOne
    @JoinColumn(name = "task_id") //Chave estrangeira
    private TaskModel task;

    public UserModel(String name, String email, Integer age, TaskModel task) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.task = task;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", task=" + (task != null ? task.getName() : "no task") +
                '}';
    }
}
