package uz.b25.testing_system.client;

import uz.b25.testing_system.client.ui.MainUI;
import uz.b25.testing_system.client.util.ScannerUtil;
import uz.b25.testing_system.server.database.Database;
import uz.b25.testing_system.server.entity.Question;
import uz.b25.testing_system.server.entity.User;
import uz.b25.testing_system.server.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {

    public static User sessionUser  = null;

//    /*static {
//        User admin = new User((long) (Database.USERS.size()+1),
//                "admin", "+998901234567", "4567");
//        admin.setRole(Role.ADMIN);
//
//        Database.USERS.add(admin);
//
//        User user = new User((long) (Database.USERS.size()+1),
//                "user", "+998901112233", "2233");
//        Database.USERS.add(user);
//        Database.TEST_HISTORY_MAP.put(user, new ArrayList<>());
//
//        Database.QUESTION_MAP.put("MATH", new ArrayList<>());
//        Database.QUESTION_MAP.put("ENGLISH", new ArrayList<>());
//
//        List<Question> questionList=new ArrayList<>();
//        List<String > variants=new ArrayList<>();
//        variants.add("8");
//        variants.add("10");
//        variants.add("6");
//        variants.add("4");
//        List<String > variants1=new ArrayList<>();
//        variants1.add("8");
//        variants1.add("3");
//        variants1.add("6");
//        variants1.add("4");
//        List<String > variants2=new ArrayList<>();
//        variants2.add("10");
//        variants2.add("15");
//        variants2.add("6");
//        variants2.add("4");
//        List<String > variants3=new ArrayList<>();
//        variants3.add("10");
//        variants3.add("15");
//        variants3.add("0");
//        variants3.add("20");
//        questionList.add(new Question("2+2*2=?", "6", variants));
//        questionList.add(new Question("2+2/2=?", "3", variants1));
//        questionList.add(new Question("4+2*3=?", "10", variants2));
//        questionList.add(new Question("(10-10)*10=?", "0", variants3));
//        Database.QUESTION_MAP.put("MATH", questionList);
//
//        List<Question> questionListEnglish=new ArrayList<>();
//        List<String > variantsE=new ArrayList<>();
//        variantsE.add("A");
//        variantsE.add("THE");
//        variantsE.add("TH");
//        variantsE.add("TO");
//        List<String > variantsE1=new ArrayList<>();
//        variantsE1.add("SPEAKS");
//        variantsE1.add("SPEAK");
//        variantsE1.add("SPOKEN");
//        variantsE1.add("SPOKE");
//        List<String > variantsE2=new ArrayList<>();
//        variantsE2.add("A");
//        variantsE2.add("AN");
//        variantsE2.add("TOO");
//        variantsE2.add("THE");
//        List<String > variantsE3=new ArrayList<>();
//        variantsE3.add("BILIM");
//        variantsE3.add("AQIL");
//        variantsE3.add("BILMOQ");
//        variantsE3.add("O`QIMOQ");
//        questionListEnglish.add(new Question("I am ... doctor.", "A", variantsE));
//        questionListEnglish.add(new Question("Do you ... English?", "SPEAK", variantsE1));
//        questionListEnglish.add(new Question("Tashkent is ... most modern city all over the world?", "THE", variantsE2));
//        questionListEnglish.add(new Question("Translate into Uzber 'knowledge'", "BILIM", variantsE3));
//        Database.QUESTION_MAP.put("ENGLISH", questionListEnglish);
//    }*/

    public static void main(String[] args) {
        MainUI.run();
    }
}
