package com.company.service;

import com.company.entity.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class App4 {
    static String BASE_FOLDER="src/main/resources";
    public static void main(String[] args) {
        List<Book> bookList=new ArrayList<>();
        bookList.add(new Book(10, "Java", "A`zamjon", 50d));
        bookList.add(new Book(20, "JavaScript", "Sobir", 30d));
        bookList.add(new Book(30, "Java", "Sobir", 50d));
        File file=new File(BASE_FOLDER,"books.json");
        Gson gson=new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println(gson.toJson(bookList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
