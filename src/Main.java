import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader filereader = new FileReader();

        String thoughtWord = filereader.getBank().get((int) (Math.random() * filereader.getBank().size()));
        int numberTrials = 0;
        StringBuilder guessingWord = new StringBuilder();
        guessingWord.append("_".repeat(thoughtWord.length()));


        while (true) {

            System.out.print("Key in one character or your guess word: ");
            Scanner scanner = new Scanner(System.in);
            String userStr = scanner.nextLine();


            if (userStr.length() != 1) {

                if (userStr.equals(thoughtWord)) {
                    numberTrials++;
                    System.out.println("Trial " + numberTrials + ": " + userStr);
                    System.out.println("Congratulation!");
                    System.out.println("You got in " + numberTrials + " trials");
                } else {
                    System.out.println("You lost!");
                }
                break;
            } else {

                if (thoughtWord.contains(userStr)) {

                    numberTrials++;

                    StringBuilder helpStr = new StringBuilder();
                    for (int i = 0; i < thoughtWord.length(); i++) {
                        helpStr.append((thoughtWord.charAt(i) != userStr.charAt(0)) ? guessingWord.charAt(i) : userStr);
                    }
                    guessingWord = new StringBuilder(helpStr.toString());

                    System.out.println("Trial " + numberTrials + ": " + guessingWord);

                    if (guessingWord.toString().equals(thoughtWord)) {
                        System.out.println("Congratulation!");
                        System.out.println("You got in " + numberTrials + " trials");
                        break;
                    }

                } else {
                    numberTrials++;
                    System.out.println("Trial " + numberTrials + ": " + guessingWord);
                }
            }

        }
    }
}
