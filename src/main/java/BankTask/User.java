package BankTask;

public class User implements Runnable {
    private CreditCard creditCard;
    private String name;

    public User(CreditCard creditCard, String name) {
        this.creditCard = creditCard;
        this.name = name;
    }

    @Override
    public void run() {
        while (creditCard.isEnoughMoney()){
            try {
                creditCard.makeWithDraw(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }
}
