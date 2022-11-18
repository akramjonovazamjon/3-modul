package uz.b25.hw;

import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        int result= 0;
        try {
            result = divide(10, 0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static int  divide(int a, int b) throws Exception {
        if (b==0){
            throw new Exception("No`lga bo`lib bo`lmaydi");
        }
        return a/b;
    }
}
