package uz.b25.task_online_platform.task2.entity;

import uz.b25.task_online_platform.task2.enums.CardType;

public class Card {
    private long id;
    private String owner;
    private long balance;
    private CardType cardType;
    public Card() {
    }

    public Card(long id, String owner, long balance, CardType cardType) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.cardType = cardType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
