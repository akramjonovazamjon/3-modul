package uz.pdp.server.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Question {
    private Long id;
    private Long subjectId;
    private String text;
    private String correctAnswers;
    private List<String > variants;
    private LocalDateTime createdAt=LocalDateTime.now();

    public Question(Long id, Long subjectId, String text, String correctAnswers, List<String> variants) {
        this.id = id;
        this.subjectId = subjectId;
        this.text = text;
        this.correctAnswers = correctAnswers;
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

    public String getCorrectAnswers() {
        return correctAnswers;
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

    public void setCorrectAnswers(String correctAnswers) {
        this.correctAnswers = correctAnswers;
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
                ", correctAnswers='" + correctAnswers + '\'' +
                ", variants=" + variants +
                ", createdAt=" + createdAt +
                '}';
    }
}
