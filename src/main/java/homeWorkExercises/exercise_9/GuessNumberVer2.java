package homeWorkExercises.exercise_9;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberVer2 {
    public static void main(String[] args) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 11);

        int userInput;
        int attempts = 0;
        String userName = getUserName();
        int position = 1;
        String FILE_LOCATION = "src/main/java/homeWorkExercises/exercise_9/highscores.txt";
        Path path = Paths.get(FILE_LOCATION);


        do {
            userInput = getUserInput();
            attempts++;
            if (randomNumber != userInput) {
                System.out.println("Neatspejote bandykite dar karta");
            }
        } while (randomNumber != userInput);

        String information = userName + ", guessed number " + randomNumber + ", number of tries " + attempts;

        try {
            if (!checkIfFileExist(FILE_LOCATION)) {
                createAndWriteToFile(information, FILE_LOCATION);
            } else {
                List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

                for (int i = 0; i < lines.size(); i++) {
                    int userAttempts = Integer.parseInt(information.substring(information.lastIndexOf(" ") + 1));
                    int checkAttempts = Integer.parseInt(lines.get(i).substring(lines.get(i).lastIndexOf(" ") + 1));

                    if (checkAttempts >= userAttempts) {
                        lines.add(i, position + ". " + information);
                        break;
                    } else if (i == lines.size() - 1) {
                        position++;
                        lines.add(position + ". " + information);
                        break;
                    } else {
                        position++;
                    }
                }

                information = position + ". " + information;

                for (int i = position; i < lines.size(); i++) {
                    int newPosition = Integer.parseInt(lines.get(i).substring(0, lines.get(i).indexOf('.'))) + 1;
                    String newInformaition = newPosition + lines.get(i).substring(lines.get(i).indexOf('.'));
                    lines.set(i, newInformaition);
                }

                Files.write(path, lines, StandardCharsets.UTF_8);
            }
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

    private static boolean checkIfFileExist(String FILE_LOCATION) {
        File tempFile = new File(FILE_LOCATION);
        return tempFile.exists();
    }

    private static void createAndWriteToFile(String information, String FILE_LOCATION) throws IOException {
        File file = new File(FILE_LOCATION);

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("1. " + information);
        writer.close();
    }

}


