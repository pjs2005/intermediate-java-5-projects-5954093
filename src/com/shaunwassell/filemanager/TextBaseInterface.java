package com.shaunwassell.filemanager;

import java.util.Scanner;

public class TextBaseInterface implements UserInterface {
    UIEventHandler handler = null; // Assuming a maximum of 10 event handlers

    @Override
    public void start() {
        // Code to start the text-based user interface
        System.out.println("Welcome to the File Manager!");
        System.out.println("1. List files in a directory");
        System.out.println("2. Create a new directory");
        System.out.println("3. Delete a file or directory");
        System.out.println("4. Exit");
        System.out.println("Please enter a command (1-4):");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the directory path to list files:");
                    String listPath = scanner.nextLine();
                    if (handler != null) {      
                        handler.onListFiles(listPath);
                    }
                    break;
                case 2:       
                    System.out.println("Enter the directory path to create:");
                    String createPath = scanner.nextLine();
                    if (handler != null) {
                        handler.onCreateDirectory(createPath);
                    }
                    break;
                case 3:
                    System.out.println("Enter the file or directory path to delete:");
                    String deletePath = scanner.nextLine();
                    if (handler != null) {
                        handler.onDeleteFileOrDirectory(deletePath);
                    }
                    break;
                case 4:
                    System.out.println("Exiting the File Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please enter a number between 1 and 4.");
            }
         }

        // Here you would add code to read user input and trigger events based on the commands
    }

    @Override
    public void subscribe(UIEventHandler handler) {
        if(this.handler == null){
            this.handler = handler;
        }
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

}
