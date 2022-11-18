package uz.b25.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App1 {
    public static void main(String[] args) {
//        int[] arr = {10, 20, 30};
//        System.out.println(Arrays.toString(arr));

//        Collections

        List<Integer> list = new ArrayList<>(List.of(10, 230, 30, 7, -4, 7, 10, 8));
        System.out.println("list = " + list);

        //        list.add(25);
//        list.add(15);
        Collections.addAll(list, 25, 15);

        System.out.println("list = " + list);

        System.out.println();
        //Collections.sort(list);
        list.sort(Collections.reverseOrder());

        System.out.println("list = " + list);

        System.out.println("list.indexOf(7) = " + list.indexOf(7));
        System.out.println("list.contains(7) = " + list.contains(7));

        int binarySearch = Collections.binarySearch(list, 7, Collections.reverseOrder());
        System.out.println("binarySearch = " + binarySearch);

        binarySearch = Collections.binarySearch(list, 230, Collections.reverseOrder());
        System.out.println("binarySearch = " + binarySearch);

        System.out.println();
        Collections.reverse(list);

        System.out.println("list = " + list);

        System.out.println();
        List<Integer> listCopy = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            listCopy.add(i);
        }
        System.out.println("listCopy = " + listCopy);

        Collections.fill(listCopy, 1);
        System.out.println("listCopy = " + listCopy);

        Collections.copy(listCopy, list);
        System.out.println("listCopy = " + listCopy);
        System.out.println("list = " + list);

        System.out.println();
        listCopy.removeAll(list);
        listCopy.add(7);

        System.out.println("listCopy = " + listCopy);

        boolean disjoint = Collections.disjoint(list, listCopy);
        System.out.println("disjoint = " + disjoint);

        System.out.println("list = " + list);

        System.out.println("Collections.frequency(list, 7) = " +
                Collections.frequency(list, 7));

        System.out.println("Collections.frequency(list, 1000) = " +
                Collections.frequency(list, 1000));

        // list dagi har bir element necha martadan qatnashgan?

        for (Integer number : new HashSet<>(list)) {
            System.out.println(number + " -> "+Collections.frequency(list, number));
        }
        System.out.println();
        // list dagi eng ko'p marta qatnashgan elementlarni aniqlash?
        // method - 1

        Set<Integer> frequencies = new HashSet<>();

        for (Integer number : new HashSet<>(list)) {
            frequencies.add(Collections.frequency(list, number));
        }

        int maxFrequency = Collections.max(frequencies);

        for (Integer number : new HashSet<>(list)) {
            if(Collections.frequency(list, number) == maxFrequency){
                System.out.println( number + " -> "+maxFrequency);
            }
        }

        System.out.println();
        // method - 2
        // nechta ekanligi, qaysi sonlar ekanligi
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (Integer number : new HashSet<>(list)) {
            int frequency = Collections.frequency(list, number);

            map.merge(frequency, new ArrayList<>(List.of(number)),
                    (oldList, newList) -> {oldList.addAll(newList); return oldList; });

//            if(map.containsKey(frequency)){
//                map.get(frequency).add(number);
//            }else{
//                map.put(frequency, new ArrayList<>(List.of(number)));
//            }
        }

        System.out.println("map = " + map);
        System.out.println("map.lastEntry() = " + map.lastEntry());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(list);

        Optional<Integer> max = list.stream().max(Integer::compareTo);
        max.ifPresent(System.out::println);

        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        reduce.ifPresent(System.out::println);


        list.stream().distinct().forEach(System.out::println);

        long count = list.stream().filter(integer -> integer == 10).count();
        System.out.println(count);
        System.out.println("=============================================================\n\n");

        list.stream().filter(integer -> integer>10).forEach(System.out::println);


        Optional<Integer> min = list.stream().min((o1, o2) -> o1 - o2);
        min.ifPresent(System.out::println);
        System.out.println("==============\n");
        int frequency = Collections.frequency(list, 100);
        System.out.println("frequency = " + frequency);

        int i = Collections.binarySearch(list, 7);
        System.out.println("i = " + i);


        System.out.println("list = " + list);



        Collections.shuffle(list);
        System.out.println("list = " + list);


        Collections.swap(list, 5, 7);
        System.out.println(list);


        Collections.reverse(list);
        System.out.println(list);

    }
}
