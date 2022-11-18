package com.company.service2;

import com.company.entitiy.Todo;
import com.company.entitiy.User;
import com.company.files.WorkWithFiles;

import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<User> users = WorkWithFiles.getUsers();
        List<Todo> todos = WorkWithFiles.getTodos();
        long countTrue, countFalse;
        System.out.printf("%-35s %-25s %-25s \n\n", "user name", "completed", "notcompleted");
        for (int i = 0; i < users.size(); i++) {
            User user=users.get(i);

            countTrue=todos.stream()
                    .filter(todo -> todo.getUserId().equals(user.getId()))
                    .filter(Todo::isCompleted)
                    .count();

            countFalse=todos.stream()
                    .filter(todo -> todo.getUserId().equals(user.getId()))
                    .filter(todo -> !todo.isCompleted())
                    .count();

            System.out.printf("%-35s %-25s %-25s \n\n", user.getName(), countTrue+" ✅", countFalse+" ❌");
        }
    }
}
