package com.quiz.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table
public class User implements Serializable {

    @Id
    private Integer id;

    @NotBlank(message = "User Name cannot be blank")
    private String username;

    @Email(message = "Email should have proper format. E.g: abc@abc.com")
    private String email;

    public User(){}

    public User(Integer id, String username, String email){
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
