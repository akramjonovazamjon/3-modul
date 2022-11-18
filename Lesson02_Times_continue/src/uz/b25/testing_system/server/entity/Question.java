package uz.b25.testing_system.server.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Question {
    private Long id;
    private Long subjectId;
    private String text;
    private String correctAnswer;
    private List<String> variants;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Question(String text, String correctAnswer, List<String> variants) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.variants = variants;
    }

    public Question(Long id, Long subjectId, String text,
                    String correctAnswer, List<String> variants) {
        this.id = id;
        this.subjectId = subjectId;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.variants = variants;
    }

    public Long getId() {
        return id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getVariants() {
        return variants;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", text='" + text + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", variants=" + variants +
                ", createdAt=" + createdAt +
                '}';
    }
}
