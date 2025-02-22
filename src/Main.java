import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Game {

    static Scanner input;

    public static void hangman() {
        input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        try {
            File myObj = new File("src/words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                words.add(myReader.nextLine().toUpperCase());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred:" + e.getMessage());
        }

        System.out.println("Welcome to HANGMAN GAME");
        Random obj = new Random();
        int Ran_num = obj.nextInt(words.size());
        String word = words.get(Ran_num);
        String word1 = word.replaceAll("[A-Z]", "_ ");
        System.out.println("Let's play the game");
        startGame(word, word1);
    }

    public static void startGame(String word, String word1) {
        int wrong = 0;
        StringBuilder guesses = new StringBuilder();
        DrawHangman drawHangman = new DrawHangman();

        while (wrong < 6 && word1.contains("_")) {
            System.out.println(word1 + "\n");
            int temp = 6 - wrong;
            if (wrong != 0) {
                System.out.println("You have " + temp + " guesses left.");
            }

            System.out.print("Your Guess (letter or full word): ");
            String guess = input.nextLine().toUpperCase();

            if (guess.equals(word)) {
                System.out.println("Congratulations! You guessed the word: " + word);
                return;
            }

            char letter = guess.charAt(0);
            boolean guessesContainsGuess = (guesses.toString().indexOf(letter)) != -1;
            guesses.append(letter);
            System.out.println();

            if (guessesContainsGuess) {
                System.out.println("You ALREADY guessed " + letter + ". \n");
            }

            boolean guessInWord = (word.indexOf(letter)) != -1;
            if (guessInWord) {
                System.out.println(letter + " is present in the word.");
                System.out.print("\n");
                for (int position = 0; position < word.length(); position++) {
                    if (word.charAt(position) == letter && word1.charAt(position) != letter) {
                        word1 = word1.replaceAll("_ ", "_");
                        String word2 = word1.substring(0, position) + letter + word1.substring(position + 1);
                        word2 = word2.replaceAll("_", "_ ");
                        word1 = word2;
                    }
                }
            } else {
                System.out.println(letter + " is not present in the word.");
                wrong++;
                drawHangman.drawHangman(wrong);
            }
        }

        if (wrong == 6) {
            System.out.println("YOU LOST!, maximum limit of incorrect guesses reached.");
        } else {
            System.out.print("The word is: " + word1 + "\n Well Played, you did it!!");
        }
    }

    public static void main(String[] args) {
        hangman();
    }
}