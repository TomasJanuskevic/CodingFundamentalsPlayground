package homeWorkExercises;

import java.util.Scanner;

public class Exercise_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float bmi;
        System.out.println("Irasykite savo svori, kg");
        float weight = scanner.nextFloat();
        System.out.println("Irasykite savo ugi, cm");
        int height = scanner.nextInt();
        float heightM = (float)height/100;

        bmi = weight / (heightM * heightM);
        System.out.println("Bmi yra " + bmi);
        if (bmi > 18.5 && bmi < 24.9) {
            System.out.println("BMI optimal");
        } else {
            System.out.println("BMI not optimal");
        }
    }
}
