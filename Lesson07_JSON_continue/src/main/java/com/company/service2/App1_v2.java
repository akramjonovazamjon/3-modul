package com.company.service2;

import com.company.entitiy.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App1_v2 {
    public static void main(String[] args) {

        ObjectMapper mapper=new ObjectMapper();
        try {
            User[] users = mapper.readValue(new File("src/main/resources/users.json"), User[].class);
            ArrayList<User> users1 = new ArrayList<>(List.of(users));
            System.out.println(users1.stream()
                    .filter(user -> user.getId() == 1)
                    .findFirst().get().getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
