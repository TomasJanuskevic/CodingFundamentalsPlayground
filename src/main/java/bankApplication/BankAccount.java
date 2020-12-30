package bankApplication;

import java.util.Scanner;

public class BankAccount {
    public int balance;
    public int previousTransaction;
    public String customerName;
    public int customerId;

    public BankAccount(String costumerName, int customerId) {
        this.customerName = costumerName;
        this.customerId = customerId;
    }
    private void showStartMeniu() {
        System.out.println("Sveiki prisijunge: " + customerName);
        System.out.println("Jusu vartotojo ID: " + customerId);
        System.out.println();
        System.out.println("a. Saskaitos likutis");
        System.out.println("b. Prideti pinigu");
        System.out.println("c. Isimti pinigu");
        System.out.println("d. Paskutinis veiksmas");
        System.out.println("e. Iseiti is programos");
    }

    private int getUserMoneyInput() {
        int userMoneyInput;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.matches("[0-9]+")) {
                userMoneyInput = Integer.parseInt(userInput);
                break;
            } else if (userInput.matches("e")) {
                return -1;
            } else {
                System.out.println("Blogai ivedete pinigu suma, veskite dar karta arba spauskite 'e' noredami iseiti");
            }
        }
        return userMoneyInput;
    }

    private void deposit(int amountToDeposit) {
        balance += amountToDeposit;
        previousTransaction = amountToDeposit;
    }

    private void withdraw(int amountToWithdraw) {
        if (amountToWithdraw <= balance) {
            balance -= amountToWithdraw;
            previousTransaction = -amountToWithdraw;
        } else {
            System.out.println("Nepakankamas likutis");
        }

    }

    private void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Buvo ivesta pinigu suma: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Buvo isimta pinigu suma: " + previousTransaction);
        } else {
            System.out.println("Jokiu veiksmu nebuvo atlikta");
        }
    }

    private boolean chooseOption(char option) {
        switch (option) {
            case 'a':
                System.out.println("=========================================");
                System.out.println("Jusu saskaitos likutis = " + balance);
                System.out.println("=========================================");
                return true;

            case 'b':
                System.out.println("=========================================");
                System.out.println("Iveskite pinigu suma kuria norite prideti: ");
                System.out.println("=========================================");
                int amountToDeposit = getUserMoneyInput();
                if (amountToDeposit == -1) {
                    return chooseOption('e');
                } else {
                    deposit(amountToDeposit);
                    return true;
                }

            case 'c':
                System.out.println("=========================================");
                System.out.println("Iveskite pinigu suma kuria norite isimti: ");
                System.out.println("=========================================");
                int amountToWithdraw = getUserMoneyInput();
                if (amountToWithdraw == -1) {
                    return chooseOption('e');
                } else {
                    withdraw(amountToWithdraw);
                    return true;
                }

            case 'd':
                System.out.println("=========================================");
                System.out.println("Jusu paskutinis atliktas veiksmas:");
                getPreviousTransaction();
                System.out.println("=========================================");
                return true;

            case 'e':
                System.out.println("Aciu kad naudojates musu banko paslaugomis! Viso gero! :)");
                return false;

            default:
                System.out.println("Neteisingai pasirinkta operacija. Bandykie dar karta");
                return true;
        }
    }

    public void showMeniu(CreditCard creditCard) {
        CreditCardValidator validator = new CreditCardValidator();

        boolean isCreditCardValid = validator.checkCardDetail(creditCard);

        if (isCreditCardValid) {
            boolean continueApplication;
            char option;
            Scanner scanner = new Scanner(System.in);
            showStartMeniu();

            do {
                System.out.println("=========================================");
                System.out.println("Pasirinkite norima operacija");
                System.out.println("=========================================");
                option = scanner.next().charAt(0);

                continueApplication = chooseOption(option);

            } while (continueApplication);

        } else {
            System.out.println("Atmesta");
        }
    }
}
