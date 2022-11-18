package uz.b25.task;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        //1-task
//        Stream.generate(() -> new Random().nextInt(101))
//                .filter(n ->n%2!=0)
//                .limit(10)
//                .forEach(System.out::println);
//        System.out.println();
//
//        //2-task
//        List<Integer> list=Stream.generate(() -> new Random().nextInt(100))
//                .limit(5)
//                .collect(Collectors.toList());
//        System.out.println(list);
//        System.out.println(list.stream().max(Comparator.naturalOrder()));

        //3-task

        List<Integer> list = Stream.iterate(2, n -> n+2)
                .limit(10)
                .filter(number -> number>10)
                .toList();
        System.out.println(list);
    }
}
