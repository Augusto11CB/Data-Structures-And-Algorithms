package com.buenosdev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderUseCase {

    public void readFile(String fileName){
        // A path can point to either a file or a directory
        Path file = Paths.get(fileName);
        byte[] fileArray;
        String fileString;
        List<String> fileAllLines;

        try {
            fileArray = Files.readAllBytes(file);
            fileString = Files.readString(file);
            fileAllLines = Files.readAllLines(file);

            int length = fileArray.length;

            System.out.println("length: " + length);
            System.out.println("fileArray: " + fileArray);
            System.out.println("fileString: " + fileString);
            System.out.println("fileAllLines: " + fileAllLines);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
