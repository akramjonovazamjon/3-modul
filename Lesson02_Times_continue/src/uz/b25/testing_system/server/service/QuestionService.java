package uz.b25.testing_system.server.service;

import uz.b25.testing_system.server.database.Database;
import uz.b25.testing_system.server.entity.Question;
import uz.b25.testing_system.server.payload.QuestionDTO;
import uz.b25.testing_system.server.payload.Result;

import java.util.*;

public class QuestionService {
    public static Result addQuestion(QuestionDTO questionDTO) {
        String check  = checkParameters(questionDTO);
        if(!check.equals("ok")){
            return new Result(check, false);
        }

        if (!Database.QUESTION_MAP.containsKey(questionDTO.getCategoryName().toUpperCase())) {
            return new Result("Category not found", false);
        }

        List<String> variants = new ArrayList<>(
                List.of(questionDTO.getWrongVariants().split("/")));
        variants.add(questionDTO.getCorrectAnswer());

        Question question = new Question(questionDTO.getText(),
                questionDTO.getCorrectAnswer(), variants);

        List<Question> questionList = Database.QUESTION_MAP.get(questionDTO.getCategoryName());
        questionList.add(question);

        return new Result("Question added", true);
    }

    private static String checkParameters(QuestionDTO questionDTO) {
        // todo check parameters

        if (questionDTO==null) return "Please enter questions fully";

        String wrongVariants = questionDTO.getWrongVariants().toUpperCase();
        String[] split = wrongVariants.split("/");

        Set<String> set = new HashSet<>(List.of(split));
        if(set.size() != 3) return "Duplicates in wrong variants";

        if(set.contains(questionDTO.getCorrectAnswer().toUpperCase())){
            return "Correct answer in the wrong variants";
        }

        return "ok";
    }

    public static List<Question> getQuestionListByCategory(String categoryName) {

        if (!Database.QUESTION_MAP.containsKey(categoryName)) {
            return new ArrayList<>();
        }

        return Database.QUESTION_MAP.get(categoryName);
    }
}
