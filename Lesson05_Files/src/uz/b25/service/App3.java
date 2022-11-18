package uz.b25.service;

import java.awt.geom.GeneralPath;
import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class App3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("files/b25.txt"))) {
            String s;
            while ((s= reader.readLine())!=null){
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
