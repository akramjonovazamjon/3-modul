package uz.b25.testing_system.server.entity;

import java.time.LocalDateTime;

public class TestHistory {
    private Long id;
    private Long userId;
    private String subjectName;
    private int quantity;
    private int score;
    private LocalDateTime createdAt = LocalDateTime.now();

    public TestHistory(Long userId, String  subjectName,
                       int quantity, int score) {
        this.userId = userId;
        this.subjectName = subjectName;
        this.quantity = quantity;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setSubjectId(String  subjectName) {
        this.subjectName = subjectName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestHistory{" +
                "  subjectName=" + subjectName +
                ", quantity=" + quantity +
                ", score=" + score +
                ", createdAt=" + createdAt +
                '}';
    }
}
