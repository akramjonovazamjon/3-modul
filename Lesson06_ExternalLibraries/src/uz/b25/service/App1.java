package uz.b25.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) {
        File file=new File("files/data.txt");
        System.out.println(findLongestWord1(file));
    }
    private static String  findLongestWord1(File file){
        String longetsWord="";
        String s = "";
        try (FileReader reader = new FileReader(file)) {
            int i;
            while ((i=reader.read())!=-1){
                if ( (i>=65 && i<=90) || (i>=97 && i<=122)){
                    s=s+(char)i;
                }else {
                    if (s.length()>=longetsWord.length()){
                        longetsWord=s;
                        s="";
                    }else {
                        s="";
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return longetsWord;
    }
    private static int sumAllIntegers2(File file){
        String s="";
        int sum=0;

        try (FileReader reader = new FileReader(file)) {
            int i;
            while ((i=reader.read())!=-1){
                if (i>=48 || i<=57){

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }
}
