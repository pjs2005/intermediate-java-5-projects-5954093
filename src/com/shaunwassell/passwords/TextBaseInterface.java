package com.shaunwassell.passwords;

import java.util.Scanner;

public class TextBaseInterface implements UserInterface {
    private Scanner scanner;
    private int passwordLength;
    private boolean useLowercase;
    private boolean useUppercase;
    private boolean useNumbers;
    private boolean useSpecialChars;

    public TextBaseInterface() {
        this.scanner = new Scanner(System.in);


    }

    @Override
    public int getPasswordLength() {
         System.out.print("Enter desired password length: ");
         return scanner.nextInt();
    }

    @Override
    public boolean useLowercase() {
        System.out.print("Include lowercase letters? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useUppercase() {
        System.out.print("Include uppercase letters? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useNumbers() {
        System.out.print("Include numbers? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useSpecialChars() {
        System.out.print("Include special characters? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public void displayPassword(String password) {
        System.out.println("Generated Password: " + password);
    }

}
