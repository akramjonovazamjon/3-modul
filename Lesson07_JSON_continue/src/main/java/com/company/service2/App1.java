package com.company.service2;

import com.company.entitiy.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App1 {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/users.json"))) {

            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();

            User[] users = gson.fromJson(reader, User[].class);
            ArrayList<User> users1 = new ArrayList<>(List.of(users));
            users1.forEach(user -> System.out.println(user.getName()+" : "+user.getPhone()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
