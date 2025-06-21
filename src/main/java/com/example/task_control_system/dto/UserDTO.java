package com.example.task_control_system.dto;
import com.example.task_control_system.entity.User;
import com.example.task_control_system.role.EnumRole;
import org.springframework.beans.BeanUtils;
import java.util.Objects;

public class UserDTO {

    //ATRIBUTES
    private Long id;
    private String name;
    private String email;
    private String userName;
    private String password;
    private EnumRole profile;

    //NOARGCONTRUCTOR
    public UserDTO(){
    }

    //ALLARGCONTRUCTOR
    public UserDTO(User entity){
        BeanUtils.copyProperties(entity,this);
    }

    //GETETERS AND SETTERS

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    //toString

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
