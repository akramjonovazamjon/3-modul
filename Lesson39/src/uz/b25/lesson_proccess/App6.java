package uz.b25.lesson_proccess;

import java.util.Scanner;

public class App6 {
    public static void main(String[] args) {
        int firstIndex = 0;
        int lastIndex = 0;
        try {
            Scanner scannerText = new Scanner(System.in);
            Scanner scannerNumber = new Scanner(System.in);
            System.out.println("Satr kiriting: ");
            String text = scannerText.nextLine();
            try {
                System.out.println("First index=");
                firstIndex = scannerNumber.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println("Last index=");
                lastIndex = scannerNumber.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                String newText = text.substring(firstIndex, lastIndex);
                System.out.println(newText);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
