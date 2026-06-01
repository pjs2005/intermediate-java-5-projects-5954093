package com.shaunwassell.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    private String[] wordList;
    private int maxAttempts;

    private Scanner scanner;
    private Random rand;

    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;

    public WordGuessingGame(String[] wordList, int maxAttempts) {
        this.wordList = wordList;
        this.maxAttempts = maxAttempts;
        this.rand = new Random();
        setNewWordToGuess(wordList);
        this.scanner = new Scanner(System.in);
        
        
    }

    private void setNewWordToGuess(String[] wordList) {
        this.wordToGuess = wordList[rand.nextInt(wordList.length)].toLowerCase();
        this.guessedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
         this.attempts = this.maxAttempts;
        
    }

    public void gameLoop(){
        boolean wantsToContinue = true;
        while(wantsToContinue){
            play();
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if(response.toLowerCase().equals("yes")){
                setNewWordToGuess(wordList);
            }else {
                wantsToContinue = false;
                System.out.println("Thanks for playing! Goodbye!");
            }
            System.out.println("Wins : " + gamesWon + " Losses: " + gamesLost);

        }
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Games Won: " + gamesWon);
        System.out.println("Games Lost: " + gamesLost);
    }

    public void play() {
        System.out.println("\n\n\n");
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("The word has " + wordToGuess.length() + " letters.");
        // System.out.println("The word is " + wordToGuess);
        gamesPlayed++;
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
                gamesWon++;
                // return;
                userHasWon = true;
            }
            
            System.out.println(); // Add an empty line for better readability

        }

        if(!userHasWon) {
            System.out.println("Game Over! The word was: " + wordToGuess);
            gamesLost++;
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
