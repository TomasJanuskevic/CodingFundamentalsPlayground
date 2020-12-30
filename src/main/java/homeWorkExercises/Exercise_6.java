package homeWorkExercises;

import java.util.Scanner;

public class Exercise_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int countSpace = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                countSpace++;
            }
        }
        System.out.println(((double) countSpace /  text.length()) * 100 + "%");
    }
}
