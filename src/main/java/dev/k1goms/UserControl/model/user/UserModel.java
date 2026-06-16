package dev.k1goms.UserControl.model.user;

import dev.k1goms.UserControl.model.task.TaskModel;
import jakarta.persistence.*;
import java.util.List;

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

    public UserModel() {
    }

    public UserModel(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
