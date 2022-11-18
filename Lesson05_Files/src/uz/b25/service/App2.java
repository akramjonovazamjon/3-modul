package uz.b25.service;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;

public class App2 {
    public static void main(String[] args) {
        DayOfWeek[] values = DayOfWeek.values();
int i=0;
        while (i<=6){
            File file=new File("files/dayofweeks/"+values[i].name()+".txt");
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                parentFile.mkdirs();

            }file.delete();
            i++;
        }

    }
}
