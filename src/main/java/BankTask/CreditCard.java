package BankTask;

public class CreditCard {
    private volatile BankAccount bankAccount;
    private boolean isEnoughMoney;

    public CreditCard(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.isEnoughMoney = true;
    }
//  synchronized - в сигнатурі
    public synchronized void makeWithDraw (int amounyTOwithDraw) throws InterruptedException {
        //synchronized - для блока коду - блокує об*єкт (можна this або інший клас)
        synchronized (this) {
            if (bankAccount.getSumm() >= amounyTOwithDraw) {
                System.out.println(Thread.currentThread().getName() + " " + "is withdrowing money");
                Thread.sleep(500);
                this.bankAccount.withdraw(amounyTOwithDraw);
                System.out.println(Thread.currentThread().getName() + " " + "is withdrawn, remains on account: " + bankAccount.getSumm());

            } else {
                this.isEnoughMoney = false;
            }
        }

    }

    public boolean isEnoughMoney() {
        return isEnoughMoney;
    }
}
