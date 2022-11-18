package com.company.service;

import com.company.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.io.*;
import java.util.List;

public class App1 {
    public static void main(String[] args) {
        User user1=new User(1, "azamjon", "1999", List.of("Java", "Database"));
        User user2=new User(2, "elshod", "2003", List.of("Python", "Database"));
        System.out.println(user1);
        Gson gson=new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        String json=gson.toJson(user1);
        System.out.println("json = " + json);
        File file=new File("src/main/resources/users.json");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(gson.toJson(user1));
            writer.println(gson.toJson(user2));
            System.out.println("ok");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
