package hangMan;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameMain {
    public static void main(String[] args) {
        //susikuriame zodziu sarasa
        String[] initialWordList = {"varna", "stalas", "medis", "namas", "buratinas"};
        int numberOfTries = 5;
        //skaiciusreikalingas atsitiktiniam skaiciui
        int randomNumber = ThreadLocalRandom.current().nextInt(0, initialWordList.length);
        String randomWord = initialWordList[randomNumber];
        int randomWordLength = randomWord.length();
        //Susikuriame printer klases objekta
        HangManPrinter hangManPrinter = new HangManPrinter();

        // klase ledzianti konstruoti eilutes
        StringBuffer stringBuffer = new StringBuffer();


        for (int i = 0; i < randomWordLength; i++) {
            stringBuffer.append("*");  //konstruojame ****** eilute, kuri atvazuos uzslepta zodi
        }
        String hiddenWord = stringBuffer.toString();

        //paslepta zodi paverskime i simboliu masyva
        char[] hiddenWordSymbolArray = hiddenWord.toCharArray();
        //random zodi pavercciame i simboliu masyva
        char[] randomWordSymbolArray = randomWord.toCharArray();

        System.out.println("Sveiki atvyke i zaidima kartuves!");
        System.out.println();
        System.out.println("Atspekite zodi - jus turite 5 bandymus suklysti. Speliokite po viena raide");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Spekite raide: ");
            char raide = scanner.next().charAt(0);

            //patikrimkime ar random zodyje egzistuoja ivestas simbolis
            if (randomWord.indexOf(raide) != -1) {
                System.out.println("--------------------------------------------------");
                System.out.println("Atspejote raide! Teisinga raide buvo [" + raide + "] Spekite tuoliau");
                // atidengiam raide
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWordSymbolArray[i] == raide) {
                        hiddenWordSymbolArray[i] = raide;
                    }
                }
                String hiddenWordSimbolArrayString = new String(hiddenWordSymbolArray);
                //jaigu nebera neatspetu simboliu, isspausdiname teksta ir nutraukiame cikla
                if (!hiddenWordSimbolArrayString.contains("*")) {
                    //jai zodis atspetas
                    System.out.println("Sveikiname! Atspejote zodi ->>>>" + hiddenWordSimbolArrayString);
                    break;
                } else {
                    //jeigu neatspetas
                    System.out.println("Zodis, kuri turi atspeti dabar atrodo taip: " + hiddenWordSimbolArrayString);
                }
            } else {
                //jei raides atspeti nepavyko, kvieciame HangManPrinter klases ir atspausdiname pakaruokli
                numberOfTries = hangManPrinter.invokePrinting(numberOfTries);
                if (numberOfTries > 0) {
                    System.out.println("Neatspejai! Bandyk dar karta! liko baandymu: " + numberOfTries);
                }
            }
        } while (numberOfTries > 0);
        System.out.println("Zaidimas baigtas");
    }
}
