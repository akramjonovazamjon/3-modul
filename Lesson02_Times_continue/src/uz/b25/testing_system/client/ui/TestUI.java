package uz.b25.testing_system.client.ui;

import uz.b25.testing_system.client.Application;
import uz.b25.testing_system.client.util.ScannerUtil;
import uz.b25.testing_system.server.database.Database;
import uz.b25.testing_system.server.entity.Question;
import uz.b25.testing_system.server.entity.TestHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestUI {
    public static void solveTest() {
        if (CategoryUI.showCategories()) {
            System.out.println("Enter category to solve problems this type");
            String category= ScannerUtil.SCANNER_STR.nextLine().toUpperCase();
            if (category!=null&&!category.isBlank()){
                if (Database.QUESTION_MAP.containsKey(category)){
                    List<Question> questionList= Database.QUESTION_MAP.get(category);
                    if(questionList.size()>0){
                        System.out.println("Now We have "+questionList.size()+" questions ");
                        System.out.println("How many questions will you solve?");
                        int n=ScannerUtil.SCANNER_NUM.nextInt();
                        if (n> questionList.size()){
                            System.out.println("Please enter number of questions to solve less than "+questionList.size());
                        }else {
                            int trueAnswers=0;
                            for (int i = 0; i < n; i++) {
                                System.out.println((i+1)+"-savol: "+questionList.get(i).getText());
                                System.out.println(questionList.get(i).getVariants());
                                System.out.println("Enter your answer");
                                String userAnswer=ScannerUtil.SCANNER_STR.nextLine().toUpperCase();
                                if (userAnswer.equals(questionList.get(i).getCorrectAnswer())){
                                    System.out.println("It is correct!");
                                    trueAnswers++;
                                }else {
                                    System.out.println("It is wrong!");
                                }
                            }
                            int wrongAnswers=n-trueAnswers;
                            List<TestHistory> testHistories=new ArrayList<>();
                            testHistories.add(new TestHistory(Application.sessionUser.getId(), category, n, trueAnswers));
                            Database.TEST_HISTORY_MAP.put(Application.sessionUser, testHistories);
                            System.out.println(testHistories.get(0));
                        }
                    }else {
                        System.out.println("There is no questions here yet.");
                    }
                }else {
                    System.out.println("There is no this type of category, try again");
                }

            }else {
                System.out.println("Enter category correct.");
            }
        }
    }

    public static void showTestHistory() {
        if (CategoryUI.showCategories()) {
            System.out.println("Which history of category will you see please enter ");
            String category=ScannerUtil.SCANNER_STR.nextLine().toUpperCase();
            List<TestHistory> testHistories = Database.TEST_HISTORY_MAP.get(Application.sessionUser);
            AtomicBoolean has = new AtomicBoolean(false);
            testHistories.forEach(testHistory -> {
                if (testHistory.getSubjectName().equals(category)){
                    System.out.println(testHistory);
                    has.set(true);
                }
            });
            if (!has.get()){
                System.out.println("There is no history with this category");
            }
        }
    }
}
