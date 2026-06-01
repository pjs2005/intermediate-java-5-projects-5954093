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

        String generatedPassword = password.toString();

        if (doesMatchRequirements(useLowercase, useUppercase, useNumbers, useSpecialChars, generatedPassword, lowercaseChars, uppercaseChars,
                numberChars, specialChars)){
            return generatedPassword;
        } else {
            return generatePassword(length, useLowercase, useUppercase, useNumbers, useSpecialChars);
        }
                

    }

    private boolean doesMatchRequirements(boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialChars,
            String password, String lowercaseChars, String uppercaseChars, String numberChars,
            String specialChars) {
                System.out.println("Checking password: " + password);
        if(useLowercase && !doesContain(password.toString(), lowercaseChars)) {
            return false;
        } if(useUppercase && !doesContain(password.toString(), uppercaseChars)) {
            return false;
        } if(useNumbers && !doesContain(password.toString(), numberChars)) {
            return false;
        } if(useSpecialChars && !doesContain(password.toString(), specialChars)) {
            return false;
        }
        return true;
    }

    private boolean doesContain(String password, String charSet) {
        for (char c : charSet.toCharArray()) {
            if (password.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
    

}
