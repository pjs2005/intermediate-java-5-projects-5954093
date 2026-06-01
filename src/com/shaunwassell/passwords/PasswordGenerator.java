package com.shaunwassell.passwords;

public class PasswordGenerator {

    public String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialChars) {
        StringBuilder password = new StringBuilder();
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        StringBuilder charPool = new StringBuilder();
        if (useLowercase) {
            charPool.append(lowercaseChars);
        }
        if (useUppercase) {
            charPool.append(uppercaseChars);
        }
        if (useNumbers) {
            charPool.append(numberChars);
        }
        if (useSpecialChars) {
            charPool.append(specialChars);
        }

        String charOptions = charPool.toString();

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * charOptions.length());
            password.append(charOptions.charAt(randomIndex));
        }

        return password.toString();

    }
    

}
