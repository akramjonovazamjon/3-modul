package com.company.service2;

import com.company.entitiy.Todo;
import com.company.entitiy.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static String BASE_FOLDER="src/main/resources/users.json";
    public static void main(String[] args) {
        ObjectMapper mapper1=new ObjectMapper();
        ObjectMapper mapper2=new ObjectMapper();

        try {
            Todo[] todos = mapper1.readValue("https://jsonplaceholder.typicode.com/todos", Todo[].class);
            User[] users = mapper2.readValue(BASE_FOLDER, User[].class);
            ArrayList<Todo> todos1 = new ArrayList<>(List.of(todos));
            ArrayList<User> users1 = new ArrayList<>(List.of(users));

            System.out.printf("%-25s %-25s %s %s \n\n", "todoId", "user name", "title", "completed");
            for (int i = 0; i < todos1.size(); i++) {
                String userName="";
                Integer todoId = todos1.get(i).getId();
                Integer userId = todos1.get(i).getUserId();
                String title = todos1.get(i).getTitle();
                boolean completed = todos1.get(i).isCompleted();
                for (int i1 = 0; i1 < users1.size(); i1++) {
                    if (users1.get(i).getId()==userId) {
                         userName = users1.get(i).getName();
                    }
                }
                System.out.printf("%-25s %-25s %-25s %s \n\n", todoId, userName, title, completed);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
