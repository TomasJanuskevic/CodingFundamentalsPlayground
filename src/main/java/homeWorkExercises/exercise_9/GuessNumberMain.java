package homeWorkExercises.exercise_9;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberMain {
    public static void main(String[] args) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 11);
        int userInput;
        int attempts = 0;
        String userName = getUserName();

        do {
            userInput = getUserInput();
            attempts++;
            if (randomNumber != userInput) {
                System.out.println("Neatspejote bandykite dar karta");
            }
        } while (randomNumber != userInput);
        String information = userName + ", guessed number " + randomNumber + ", number of tries " + attempts;

        final String FILE_LOCATION = "src/main/java/homeWorkExercises/exercise_9/highscores.txt";
        Path path = Paths.get("src/main/java/homeWorkExercises/exercise_9/highscores.txt");

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int position = 1;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_LOCATION));
            String singleFileLine = bufferedReader.readLine();

            while (true) {
                if (singleFileLine == null) {
                    lines.add(position - 1, position + ". " + information);
                    Files.write(path, lines, StandardCharsets.UTF_8);
                    break;
                } else if (
                        Integer.parseInt(singleFileLine.substring(singleFileLine.lastIndexOf(" ") + 1)) <
                                Integer.parseInt(information.substring(information.lastIndexOf(" ") + 1))
                ) {
                    position++;
                    singleFileLine = bufferedReader.readLine();
                } else {
                    lines.add(position - 1, position + ". " + information);
                    Files.write(path, lines, StandardCharsets.UTF_8);
                    break;
                }
            }
            information = position + ". " + information;

        } catch (IOException e) {
            System.out.println("Error");
        }
        System.out.println(information);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spekite skaiciu nuo 1 iki 10");
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.matches("[1-9]|10")) {
                return Integer.parseInt(userInput);
            }
            System.out.println("blogai ivedete skaiciu");
        }
    }

    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite savo varda");
        return scanner.nextLine();
    }
}


