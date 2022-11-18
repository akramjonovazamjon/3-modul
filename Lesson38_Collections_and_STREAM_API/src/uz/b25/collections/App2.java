package uz.b25.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of(
                "Sarvar", "Sardor", "Azamjon", "Sarvar", "Shodiyorbek", "Zamir"));

        Comparator<String > comparator=(o1, o2) -> o1.length()-o2.length();

        String max = Collections.max(list, comparator);
        System.out.println("max = " + max);
        Collections.sort(list, comparator);
        System.out.println(list);

        Collections.sort(list, (o1, o2) -> {
            if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else {
                return o1.length()-o2.length();
            }
        });
        System.out.println(list);
    }
}