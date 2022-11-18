package uz.b25.task_online_platform.task2.service;


import uz.b25.task_online_platform.task2.CardTypeNotMatch;
import uz.b25.task_online_platform.task2.NotEnoughMoney;
import uz.b25.task_online_platform.task2.entity.Card;

public class DepositMoney {
    public static String  sentMoney(Card card1, Card card2, long money) throws NotEnoughMoney, CardTypeNotMatch {
        if (card1.getBalance()<money*1.01){
            throw new NotEnoughMoney("Card has not enough money.");
        }

        if (!card1.getCardType().getType().equals(card2.getCardType().getType())){
            throw new CardTypeNotMatch("Cards don't match each other.");
        }

        card1.setBalance((long) (card1.getBalance()-money*1.01));
        card2.setBalance(card2.getBalance()+money);
        return money+" "+ card1.getCardType().getType()+" successfully transferred.\n";//+card1.getOwner()+" balance: "+card1.getBalance()+"\n"
              //  +card2.getOwner()+" balance: "+card2.getBalance();
    }
}
