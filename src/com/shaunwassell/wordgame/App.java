package com.shaunwassell.wordgame;

public class App {

    public static void main(String[] args) {
        String[] wordList = {"java", "python", "kotlin", "javascript"};
        int maxAttempts = 6;
        WordGuessingGame game = new WordGuessingGame(wordList, maxAttempts);
        game.gameLoop();
    }

}
