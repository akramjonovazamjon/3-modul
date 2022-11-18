package uz.b25.task_online_platform.task2.enums;

public enum CardType {
    UZCARD("SUM"),
    HUMO("SUM"),
    VISA("DOLLAR"),
    UNIONPAY("DOLLAR");
    private String type;

    CardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
