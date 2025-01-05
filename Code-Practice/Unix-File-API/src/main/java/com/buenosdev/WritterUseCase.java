package com.buenosdev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WritterUseCase {

    public void write(String filePath, List<String> content){
        Path file = Paths.get(filePath);
        try {
            Files.write(file, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeWithFilesWrite(String filePath, List<String> content){
        try {
            Path file = Paths.get(filePath);
            Files.write(file, content, StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
        }
    }
}
