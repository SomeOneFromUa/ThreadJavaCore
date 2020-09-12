package BankTask;

public class BankAccount {
    private volatile int summ;

    public BankAccount(int summ) {
        this.summ = summ;
    }

    public int getSumm() {
        return summ;
    }

    public void withdraw(int sumTOwitdraw) {
        this.summ -= sumTOwitdraw;
    }
}
