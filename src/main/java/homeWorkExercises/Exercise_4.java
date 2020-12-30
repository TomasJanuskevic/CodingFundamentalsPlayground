package homeWorkExercises;

import java.util.Scanner;

public class Exercise_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        OUTER:
        for (int i = 2; i < number; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue OUTER;
                }
            }
            System.out.println(i);
        }
    }
}
