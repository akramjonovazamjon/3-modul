package uz.b25.task_online_platform.task1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();
        try {
            System.out.println(checkText(str));
        } catch (NotextException e) {
            System.out.println(e.getMessage());
        }


    }
    static int  checkText(String text) throws NotextException {
        if (text.length()==0) {
            throw new NotextException("Kiritilgan satr bo`sh bo`lmasligi kerak!");
        }
        return text.length();
    }
}
