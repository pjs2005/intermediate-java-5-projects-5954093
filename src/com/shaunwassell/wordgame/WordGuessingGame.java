package com.shaunwassell.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    // private String[] wordList;
    // private int maxAttempts;

    public WordGuessingGame(String[] wordList, int maxAttempts) {
        // this.wordList = wordList;
        Random rand = new Random();
        this.wordToGuess = wordList[rand.nextInt(wordList.length)].toLowerCase();
        // this.maxAttempts = maxAttempts;
        this.guessedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
        this.attempts = maxAttempts;
    }

    public void play() {
        System.out.println("\n\n\n");
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("The word has " + wordToGuess.length() + " letters.");
        // System.out.println("The word is " + wordToGuess);
        Scanner scanner = new Scanner(System.in);
        boolean userHasWon = false;
        while (attempts > 0 && !userHasWon) {
            System.out.println("Attempts left: " + attempts);
            System.out.println("Current word: " + String.valueOf(guessedLetters));
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);
            
            if(processGuess(guess)) {
                System.out.println("Good guess!");
            }else {
                attempts--;
                System.out.println("Wrong guess!");
            }

            if(isWordGuessed()) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                // return;
                userHasWon = true;
            }
            
            System.out.println(); // Add an empty line for better readability

        }

        if(!userHasWon) {
            System.out.println("Game Over! The word was: " + wordToGuess);
        }

    }

    private boolean isWordGuessed() {
        // for (char c : guessedLetters) {
        //     if (c == '_') {
        //         return false;
        //     }
        // }
        return new String(guessedLetters).equals(wordToGuess);
    }


    private boolean processGuess(char guess) {
        boolean letterFound = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedLetters[i] = guess;
                letterFound = true;
                // break;
            }
        }
        return letterFound;      
    }

}
