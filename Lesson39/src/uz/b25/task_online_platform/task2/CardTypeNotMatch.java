package uz.b25.task_online_platform.task2;

public class CardTypeNotMatch extends Exception{
    String message;

    public CardTypeNotMatch(String message) {
        super(message);
    }
}
