package com.company.service;


import com.company.entity.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {


        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ObjectMapper mapper=new ObjectMapper();
            Todo[] todos = mapper.readValue(inputStream, Todo[].class);
            List<Todo> todos1 = List.of(todos);
            for (Todo todo : todos1) {
                System.out.println(todo+"\n");
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
