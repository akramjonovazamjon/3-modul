package uz.b25.testing_system.client.ui;

import uz.b25.testing_system.client.Application;
import uz.b25.testing_system.client.util.ScannerUtil;

public class UserUI {
    public static void adminCabinet() {

        System.out.println();
        System.out.println("1. Add category");
        System.out.println("2. Show categories");
        System.out.println("3. Add question");
        System.out.println("4. Show questions");
        System.out.println("0. Log out");
        System.out.println("Enter operation number");
        int operation = ScannerUtil.SCANNER_NUM.nextInt();

        switch (operation){
            case 1 -> CategoryUI.addCategory();
            case 2 -> CategoryUI.showCategories();
            case 3 -> QuestionUI.addQuestion();
            case 4 -> QuestionUI.showQuestions();
            case 0 -> Application.sessionUser = null;
        }
    }

    public static void userCabinet() {
        System.out.println();
        System.out.println("1. Solve quiz");
        System.out.println("2. Show test history");
        System.out.println("3. Fill balance");
        System.out.println("0. Log out");
        System.out.println("Enter operation number");
        int operation = ScannerUtil.SCANNER_NUM.nextInt();

        switch (operation){
            case 1 -> TestUI.solveTest();
            case 2 -> TestUI.showTestHistory();
            case 3 -> UserUI.fillBalance();
            case 0 -> Application.sessionUser = null;
        }
    }

    private static void fillBalance() {

    }
}
