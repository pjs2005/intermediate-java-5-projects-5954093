package com.shaunwassell.filemanager;

public class FileManager {

    public void listFiles(String directorypath) {
        // Code to list files in the specified directory
        System.out.println("Listing files in directory: " + directorypath);

    }

    public void createDirectory(String directorypath) {
        // Code to create a new directory at the specified path
        System.out.println("Creating directory: " + directorypath);
    }

    public void deleteFileOrDirectory(String path) {
        // Code to delete a file or directory at the specified path
        System.out.println("Deleting file or directory: " + path);
    }

}
