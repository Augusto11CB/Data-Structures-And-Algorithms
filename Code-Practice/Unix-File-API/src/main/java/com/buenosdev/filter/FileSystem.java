package com.buenosdev.filter;

import java.util.List;

public class FileSystem {

    private String name;

    private boolean isDirectory;

    private List<FileSystem> subDirectories;

    private List<File> files;

    public FileSystem(String name, boolean isDirectory, List<FileSystem> subDirectories, List<File> files) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.subDirectories = subDirectories;
        this.files = files;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addSubDirectory(FileSystem subDirectory) {
        this.subDirectories.add(subDirectory);
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public List<FileSystem> getSubDirectories() {
        return subDirectories;
    }

    public List<File> getFiles() {
        return files;
    }

    public String getName() {
        return name;
    }
}
