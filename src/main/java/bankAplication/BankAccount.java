package bankAplication;

import java.util.Scanner;

public class BankAccount {
    public int balance;
    public int previousTransaction;
    public String customerName;
    public String customerId;

    public BankAccount(String costumerName, String customerId) {
        this.customerName = costumerName;
        this.customerId = customerId;
    }

    public void deposit(int amountToDeposit) {
        //buisness logic goes here
        if (amountToDeposit > 0) {
            balance += amountToDeposit;
            previousTransaction = amountToDeposit;
        } else {
            System.out.println("Negalima ivesti neigiamos sumos");
        }
    }

    public void withdraw(int amountToWithdraw) {
        //ideti check
        balance -= amountToWithdraw;
        previousTransaction = -amountToWithdraw;
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Buvo ivesta pinigu suma: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Buvo isimta pinigu suma: " + previousTransaction);
        } else {
            System.out.println("Jokiu veiksmu nebuvo atlikta");
        }
    }

    public void showMeniu(CreditCard creditCard) {

        boolean isCreditCardValid = checkCardDetails(creditCard);

        if (isCreditCardValid) {

            char option = 'p';
            Scanner scanner = new Scanner(System.in);
            System.out.println("Sveiki prisijunge " + customerName);
            System.out.println("Jusu vartotojo ID: " + customerId);
            System.out.println();
            System.out.println("a. Saskaitos likutis");
            System.out.println("b. Prideti pinigu");
            System.out.println("c. Isimti pinigu");
            System.out.println("d. Paskutinis veiksmas");
            System.out.println("e. Iseiti is programos");

            do {
                System.out.println("=========================================");
                System.out.println("Pasirinkite norima operacija");
                System.out.println("=========================================");
                option = scanner.next().charAt(0);

                switch (option) {
                    case 'a':
                        System.out.println("=========================================");
                        System.out.println("Jusu saskaitos likutis = " + balance);
                        System.out.println("=========================================");
                        break;

                    case 'b':
                        System.out.println("=========================================");
                        System.out.println("Iveskite pinigu suma kuria norite prideti: ");
                        System.out.println("=========================================");
                        int amountToDeposit = scanner.nextInt();
                        deposit(amountToDeposit);
                        break;

                    case 'c':
                        System.out.println("=========================================");
                        System.out.println("Iveskite pinigu suma kuria norite isimti: ");
                        System.out.println("=========================================");
                        int amountToWithdraw = scanner.nextInt();
                        withdraw(amountToWithdraw);
                        break;

                    case 'd':
                        System.out.println("=========================================");
                        System.out.println("Jusu paskutinis atliktas veiksmas:");
                        if (previousTransaction > 0) {
                            System.out.println("Buvo prideta pinigu " + previousTransaction);
                        } else {
                            System.out.println("Buvo isimta pinigu " + previousTransaction);
                        }
                        System.out.println("=========================================");
                        break;

                    case 'e':
                        System.out.println("Aciu kad naudojates musu banko paslaugomis! Viso gero! :)");
                        break;

                    default:
                        System.out.println("Neteisingai pasirinkta operacija. Bandykie dar karta");

                }

            } while (option != 'e');

        } else {
            System.out.println("Atmesta");
        }
    }

    private boolean checkCardDetails(CreditCard creditCard) {
        System.out.println("IveskitePIN koda: ");
        Scanner scanner = new Scanner(System.in);
        int pin = scanner.nextInt();

        return pin == creditCard.cardPin;
    }

//sukurti atskira klase korteliu validavimui
    //CreditCardValidator
    //jituretu metoda checkCardDetail()
    //CredCarVal validator = new CreditCardValidator()
    //validator.check..CardDet(credCard)


}
