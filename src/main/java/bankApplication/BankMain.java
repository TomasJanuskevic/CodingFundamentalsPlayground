package bankApplication;

public class BankMain {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(1234,"Super Mario");
        BankAccount bankAccount = new BankAccount("Super Mario", 1);
        bankAccount.showMeniu(creditCard);
    }
}
