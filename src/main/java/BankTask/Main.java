package BankTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(60);
        CreditCard creditCard = new CreditCard(bankAccount);
        User husband = new User(creditCard, "husband");
        User wife = new User(creditCard, "wife");

        Thread threadHusband = new Thread(husband, husband.getName());
        Thread threadWife = new Thread(wife, wife.getName());

        threadHusband.start();
        threadWife.start();

        threadHusband.join();
        threadWife.join();
        System.out.println("final amount is " + bankAccount.getSumm());

        //volatile -  команда потокам не робити локальну копію для цього
        // значення. Використовується тільки для полів.
        // volatile  не вирішує прооблему (виводило -10 незважаючи на перевірку)
   /////////////////////////////////////////////////////////////////////////
//wife is withdrowing money
//husband is withdrowing money
//wife is withdrawn, remains on account: 40
//husband is withdrawn, remains on account: 50
//wife is withdrowing money
//husband is withdrowing money
//wife is withdrawn, remains on account: 30
//husband is withdrawn, remains on account: 20
//husband is withdrowing money
//wife is withdrowing money
//husband is withdrawn, remains on account: 10
//husband is withdrowing money
//wife is withdrawn, remains on account: 0
//husband is withdrawn, remains on account: -10
//final amount is -10
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Проблема в тому шо потоки зашли в кредитку в один момент часу побачили там 10 і обоє зробили по -10
        // два потоки одночасно виконували один метод.
        // потрібно заблокувати роботу інших потоків поки з ним вже працює один потік
        //synchronized в сигнатурі метода або блоці коду
        // такий метод називається thread safe

    }
}
