package uz.b25.lesson_proccess;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a, b;
        boolean test;
        while (true) {
            try {
                System.out.print("a= ");
                a = scanner.nextInt();
                System.out.print("b= ");
                b = scanner.nextInt();
                System.out.println("a+b= " + (a + b));
                System.out.println("a-b= " + (a - b));
                System.out.println("a*b= " + (a * b));
                System.out.println("a/b= " + (a / b));
            } catch (Exception e) {
                System.out.println("Integer toifasida son kiriting");
                scanner=new Scanner(System.in);
            }
        }

    }
}
