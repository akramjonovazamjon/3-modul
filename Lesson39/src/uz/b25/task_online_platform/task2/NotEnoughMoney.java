package uz.b25.task_online_platform.task2;

public class NotEnoughMoney extends Exception{
    String message;

    public NotEnoughMoney(String message) {
        super(message);
    }
}
