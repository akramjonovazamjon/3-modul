package uz.pdp;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main2 {
    public static void main(String[] args) {
        File file=new File("files/pdp","student.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.write(System.getProperty("line.separator"));
            writer.write("How are you");
            writer.write("How are you, feeling");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
