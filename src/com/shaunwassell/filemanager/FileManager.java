package com.shaunwassell.filemanager;

import java.io.File;

public class FileManager {

    public void listFiles(String directorypath) {
        // Code to list files in the specified directory
        System.out.println("Listing files in directory: " + directorypath);
        File directory = new File(directorypath);
        if (directory.exists() && directory.isDirectory()) {
            File[] contents = directory.listFiles();
            if (contents != null) {
                for (File file : contents) {
                    if (file.isDirectory()) {
                        System.out.println("[DIR]: " + file.getName());
                    } else {
                        System.out.println("[FILE]: " + file.getName());
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist. " + " Please check the path and try again. " + "Directory: "
                    + directorypath);
        }
    }

    public void createDirectory(String directorypath) {
        // Code to create a new directory at the specified path
        System.out.println("Creating directory: " + directorypath);
        File directory = new File(directorypath);
        if (directory.exists()) {
            System.out.println("Directory already exists: " + directorypath);
        } else {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Directory created successfully: " + directorypath);
            } else {
                System.out.println("Failed to create directory: " + directorypath);
            }
        }

    }

    public void deleteFileOrDirectory(String path) {
        // Code to delete a file or directory at the specified path
        System.out.println("Deleting file or directory: " + path);
        File fileOrDirectory = new File(path);
        if (fileOrDirectory.exists()) {
            boolean deleted = fileOrDirectory.delete();
            if (deleted) {
                System.out.println("Deleted successfully: " + path);
            } else {
                System.out.println("Failed to delete: " + path);
            }
        } else {
            System.out.println("File or directory does not exist: " + path);
        }
    }

}
