package bankApplication;

import java.util.Scanner;

public class CreditCardValidator {
    public boolean checkCardDetail(CreditCard creditCard) {
        for (int i = 2; i >= 0; i--) {
            System.out.println("Iveskite PIN koda: ");
            Scanner scanner = new Scanner(System.in);
            int inputPin = scanner.nextInt();

            if (creditCard.cardPin == inputPin) {
                return true;
            }
            System.out.println("liko bandymu: " + i);
        }
        return false;
    }
}
