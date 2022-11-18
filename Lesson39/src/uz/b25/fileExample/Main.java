package uz.b25.fileExample;

import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        File file=new File("MyFolder/InnerFolder/DeepInnerFolder/text.txt");

        try (Reader reader = new FileReader(file)) {
            char[] chars=new char[(int) file.length()];
            reader.read(chars);
            System.out.println(String.valueOf(chars));
        }

    }
}
