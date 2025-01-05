package com.buenosdev.amz;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.out.println("Usage: java Main <directory> [name] [extension] [minSize] [maxSize]");
//            return;
//        }

//        File directory = new File(args[0]);
        File directory = new File("/home/augusto/workspace/Data-Structures-And-Algorithms/Code-Practice/Unix-File-API/src/main/resources");
//        String name = args.length > 1 ? args[1] : null;
        String name = "file";
        String extension = args.length > 2 ? args[2] : null;
        String operator = ">=";
        Long size = 100L;
//        Long minSize = args.length > 3 ? Long.parseLong(args[3]) : null;
//        Long maxSize = args.length > 4 ? Long.parseLong(args[4]) : null;

//        FileSearchCriteria criteria = new FileSearchCriteria(name, extension, minSize, maxSize);
        FileSearchCriteria criteria = new FileSearchCriteria(name, extension, size, operator);
        FileSearcher searcher = new FileSearcher();

        List<File> files = searcher.searchFiles(directory, criteria);

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
