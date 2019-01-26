package com.quiz.GradleProject101;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DataSource {

    private static Map<Integer, User> users = new HashMap();

    public static Map<Integer, User> getUsers(){
        return users;
    }

}
