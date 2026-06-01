package com.shaunwassell.passwords;

public interface UserInterface {
public int getPasswordLength();
public boolean useLowercase();
public boolean useUppercase();
public boolean useNumbers();
public boolean useSpecialChars();
public void displayPassword(String password);
}
