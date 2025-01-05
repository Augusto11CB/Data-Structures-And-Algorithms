package com.buenosdev.filter;

public class File {
    private String name;
    private String extension;
    private int size;

    public File(String name, String extension, int size) {
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public int getSize() {
        return size;
    }
}
