package homeWorkExercises;

import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float radius = scanner.nextFloat();
        System.out.printf("Apskritimo perimetras = %.2f", 2*Math.PI*radius);
    }
}
