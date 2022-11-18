package com.company.service;

import com.company.entitiy.Comment;
import com.company.entitiy.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App3 {
    static String BASE_FOLDER="src/main/resources";
    public static void main(String[] args) {
        ObjectMapper mapper=new ObjectMapper();

        try {
            URL url=new URL("https://jsonplaceholder.typicode.com/comments");
            Comment[] comments = mapper.readValue(url, Comment[].class);
            ArrayList<Comment> comments1 = new ArrayList<>(List.of(comments));
            for (Comment comment : comments1) {
                System.out.println(comment+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
