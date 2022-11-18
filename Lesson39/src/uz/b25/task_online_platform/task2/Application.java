package uz.b25.task_online_platform.task2;

import uz.b25.task_online_platform.task2.entity.Card;
import uz.b25.task_online_platform.task2.enums.CardType;
//import uz.b25.task_online_platform.task2.exceptios.CardTypeNotMatch;
//import uz.b25.task_online_platform.task2.exceptios.NotEnoughMoney;
import uz.b25.task_online_platform.task2.service.DepositMoney;

public class Application {

       static Card card1=new Card(1, "A`zamjon", 1000000, CardType.VISA);
       static Card card2=new Card(2, "Ali", 500000, CardType.HUMO);
       static Card card3=new Card(3, "Vali", 1000000, CardType.UZCARD);
       static Card card4=new Card(4, "Sarvarbek", 200000, CardType.UNIONPAY);

    public static void main(String[] args) {
        try {
            printCardBalance(card4, card3);
            System.out.println();
            String transferredMoney = DepositMoney.sentMoney(card4, card3, 20000);

            System.out.println(transferredMoney);
            printCardBalance(card4, card3);

        } catch (NotEnoughMoney e) {
            System.out.println(e.getMessage());
        } catch (CardTypeNotMatch e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printCardBalance(Card card1, Card card2) {
        System.out.println(card1.getOwner()+" balance: "+card1.getBalance());
        System.out.println(card2.getOwner()+" balance: "+card2.getBalance());
    }
}
