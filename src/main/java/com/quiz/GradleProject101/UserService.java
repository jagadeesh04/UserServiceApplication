package com.quiz.GradleProject101;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {

    private Map<Integer, User> users = DataSource.getUsers();

    public UserService() {
        users.put(1, new User(1, "apple", "apple@apple.com"));
        users.put(2, new User(2, "banana", "banana@banana.com"));
    }

    public List<User> getAllUsers() {
        return new ArrayList<User>(users.values());
    }


    public User updateUser(User user) {

        if(user.getId()<=0){
            return null;
        }

        users.put(user.getId(), user);
        return user;
    }

}
