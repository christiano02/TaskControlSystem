package com.example.task_control_system.entity;

import com.example.task_control_system.role.EnumRole;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name="tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private EnumRole profile;

    public User() {
    }

    public User(Long id, String email, String name, String password, EnumRole profile) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }
    //getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumRole getProfile() {
        return profile;
    }

    public void setProfile(EnumRole profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
