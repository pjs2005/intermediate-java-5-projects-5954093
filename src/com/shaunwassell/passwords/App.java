package com.shaunwassell.passwords;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();
        // String password = generator.generatePassword(12, true, true, true, true);
        // System.out.println("Generated Password: " + password);

        UserInterface ui = new TextBaseInterface();
        int length = ui.getPasswordLength();
        boolean useLowercase = ui.useLowercase();
        boolean useUppercase = ui.useUppercase();
        boolean useNumbers = ui.useNumbers();
        boolean useSpecialChars = ui.useSpecialChars();
        String customPassword = generator.generatePassword(length, useLowercase, useUppercase, useNumbers, useSpecialChars);
        ui.displayPassword(customPassword);

        

    }

}
