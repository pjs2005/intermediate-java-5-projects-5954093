package com.shaunwassell.dice;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Simulator {

    private final static Scanner scanner = new Scanner(System.in);
    private final static Random rand = new Random();

    public static void main(String[] args) {

        userRoll();
        // System.out.println(showDice(rollDice()));
        // System.out.println(showDice(6));
    }

    public static void userRoll() {
        rollDiceNumber(getInput());
    }

    public static int getInput() {
        int rolls = 0;
        do {
            try {
                System.out.println("Please enter number of rolls: ");
                rolls = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input not valid");
                scanner.next();
            }
        } while (rolls == 0);
        return rolls;
    }

    private static int rollDice() {
        return rand.nextInt(6) + 1;
    }

    public static void rollDiceNumber(int rolls) {
        for (int current = 0; current < rolls; current++) {
            System.out.println(showDice(rollDice()));
        }
    }

    public static String showDice(int number) {
        switch (number) {
            case 1:
                return "---------\n|       |\n|   o   |\n|       | \n---------";
            case 2:
                return "---------\n|   o   |\n|       |\n|   o   | \n---------";
            case 3:
                return "---------\n|0      |\n|   o   |\n|      o| \n---------";
            case 4:
                return "---------\n|0     o|\n|       |\n|o     o| \n---------";
            case 5:
                return "---------\n|0     o|\n|   o   |\n|o     o| \n---------";
            case 6:
                return "---------\n|0     o|\n|0     o|\n|o     o| \n---------";
            default:
                return "";
        }

    }
}
