package com.quiz.GradleProject101;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class User implements Serializable {

    private int id;
    @NotBlank(message = "User Name cannot be blank")
    private String userName;
    @Email(message = "Email should have proper format. E.g: abc@abc.com")
    private String email;

    public User(){}

    public User(int id, String userName, String email){
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
