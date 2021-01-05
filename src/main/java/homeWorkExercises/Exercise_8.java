package homeWorkExercises;

import java.util.Scanner;

public class Exercise_8 {
    public static void main(String[] args) {
        double diselPrice = 1.02;
        double petrolPrice = 1.2;
        double totalPrice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fuel type diesel/petrol");
        String fuel = scanner.nextLine();
        System.out.println("Enter fuel amount");
        int amount = scanner.nextInt();

        if (fuel.equalsIgnoreCase("diesel")) {
            totalPrice = calcPrice(amount, diselPrice);
            showInfo(fuel, amount, diselPrice, totalPrice);
        } else if (fuel.equalsIgnoreCase("petrol")) {
            totalPrice = calcPrice(amount, petrolPrice);
            showInfo(fuel, amount, petrolPrice, totalPrice);
        } else {
            System.out.println("Dont have this type of fuel");
        }
    }


    private static double calcPrice(int amount, double price) {
        return amount * price;
    }

    private static void showInfo(String fuel, int amount, double price, double totalPrice) {
        System.out.printf("************\nFuel type: %s\nPrice: %.2f eur/l\nAmount: %d l\nTotal price: %.2f eur\n************",
                fuel, price, amount, totalPrice);
    }
}
