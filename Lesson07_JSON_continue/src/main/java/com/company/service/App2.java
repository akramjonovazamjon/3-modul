package com.company.service;

import com.company.entitiy.Post;
import com.company.entitiy.Todo;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App2 {
    static String BASE_FOLDER="src/main/resources";
    public static void main(String[] args) {
        ObjectMapper mapper=new ObjectMapper();

        try {
            URL url=new URL("https://jsonplaceholder.typicode.com/posts");
            Post[] posts = mapper.readValue(url, Post[].class);
            ArrayList<Post> todos1 = new ArrayList<>(List.of(posts));
            todos1.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
