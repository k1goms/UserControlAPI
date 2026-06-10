package dev.k1goms.UserControl.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    Integer age;

    public UserModel() {
    }

    public UserModel(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

}
