package homeWorkExercises;


import java.util.Scanner;

public class Exercise_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] words = text.split(" ");

        for (String word : words) {
            System.out.print(word + " " + word + " ");
        }
    }
}
