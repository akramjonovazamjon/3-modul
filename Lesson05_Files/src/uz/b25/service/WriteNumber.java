package uz.b25.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WriteNumber {
    public static void main(String[] args) throws IOException {
        File file1=new File("files/b25.txt");
        File file2=new File("files/sort_ratings.txt");
        TreeMap<Integer, ArrayList<String>> map=new TreeMap<>(Collections.reverseOrder());



        String s="";
        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
             PrintWriter writer=new PrintWriter(new FileWriter(file2));) {
            while ((s=reader.readLine())!=null){
                String[] split = s.split(" = ");
                if (!map.containsKey(Integer.valueOf(split[1]))){
                    ArrayList<String > ss=new ArrayList<>();
                    ss.add(split[0]);
                    map.put(Integer.valueOf(split[1]), ss);
                }else {
                    map.get(Integer.valueOf(split[1])).add(split[0]);
                }

            }
            for (Integer key : map.keySet()) {
                Collections.sort(map.get(key));
            }
            System.out.println(map);

            for (Integer key : map.keySet()) {
                ArrayList<String> list = map.get(key);
                for (String s1 : list) {
                    writer.println(s1+" = "+key);
                }
            }
        }



    }
}
