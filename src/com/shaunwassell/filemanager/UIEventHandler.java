package com.shaunwassell.filemanager;

public interface UIEventHandler {
    public void onListFiles(String path);
    public void onCreateDirectory(String path);
    public void onDeleteFileOrDirectory(String path);

}
