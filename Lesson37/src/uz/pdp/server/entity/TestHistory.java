package uz.pdp.server.entity;

import java.time.LocalDateTime;

public class TestHistory {
    private Long id;
    private Long userId;
    private Long subjectId;
    private int quantity;
    private int score;
    private LocalDateTime createdAt=LocalDateTime.now();

    public TestHistory(Long id, Long userId, Long subjectId, int quantity, int score) {
        this.id = id;
        this.userId = userId;
        this.subjectId = subjectId;
        this.quantity = quantity;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSubjectId() {
        return subjectId;
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

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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
                "id=" + id +
                ", userId=" + userId +
                ", subjectId=" + subjectId +
                ", quantity=" + quantity +
                ", score=" + score +
                ", createdAt=" + createdAt +
                '}';
    }
}
