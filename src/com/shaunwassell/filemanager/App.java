package com.shaunwassell.filemanager;

public class App {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        TextBaseInterface textInterface = new TextBaseInterface();

        // Subscribe the file manager to the user interface events
        textInterface.subscribe(new UIEventHandler() {
            @Override
            public void onListFiles(String path) {
                fileManager.listFiles(path);
            }

            @Override
            public void onCreateDirectory(String path) {
                fileManager.createDirectory(path);
            }

            @Override
            public void onDeleteFileOrDirectory(String path) {
                fileManager.deleteFileOrDirectory(path);
            }
        });

        // Start the user interface
        textInterface.start();
    }

}
