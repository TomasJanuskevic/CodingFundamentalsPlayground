package homeWorkExercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int indexOfLargestText = 0;
        int lengthOfText = 0;
        ArrayList<String> inputs = new ArrayList<>();

        do {
            userInput = scanner.nextLine();
            inputs.add(userInput);
            if (userInput.equals("")) {
                System.out.println("No text provided");
            }
        } while (
                !userInput.equals("Enough!")
        );

        for (int i = 0; i < inputs.size() - 1; i++) {
            if (lengthOfText < inputs.get(i).length()) {
                indexOfLargestText = i;
                lengthOfText = inputs.get(i).length();
            }
        }
        System.out.println(inputs.get(indexOfLargestText));


    }
}
