package com.buenosdev.filter;

import com.buenosdev.filter.criteria.AndCriteria;
import com.buenosdev.filter.criteria.NameCriteria;
import com.buenosdev.filter.criteria.NotCriteria;
import com.buenosdev.filter.criteria.OrCriteria;
import com.buenosdev.filter.criteria.SearchCriteria;
import com.buenosdev.filter.criteria.SizeCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void test() {
        FileSystem fileSystem = buildFileSystem();

        SearchCriteria nameLarisa = new NameCriteria("larisa");
        SearchCriteria sizeGreaterThan100 = new SizeCriteria(100, ">");
        SearchCriteria nameAugusto = new NameCriteria("augusto");

        // Combine criteria using OrCriteria and NotCriteria
        SearchCriteria orCriteria = new OrCriteria(Arrays.asList(nameLarisa, sizeGreaterThan100));
        SearchCriteria notNameAugusto = new NotCriteria(nameAugusto);

        // Combine using AndCriteria
        SearchCriteria finalCriteria = new AndCriteria(Arrays.asList(orCriteria, notNameAugusto));

        FileSearcher searcher = new FileSearcher();
        List<String> files = searcher.findFiles(fileSystem, finalCriteria);

        System.out.println("================================================================");

        for (String file : files) {
            System.out.println(file);
        }
        System.out.println("****************************************************************");
    }

    public static void main(String[] args) {
        test();
    }

    public static FileSystem buildFileSystem() {
        // Creating some files
        var augusto = new com.buenosdev.filter.File("augusto", "txt", 1234);
        var larissa = new com.buenosdev.filter.File("larissa", "txt", 1234);
        var file1 = new com.buenosdev.filter.File("document", "txt", 1234);
        var file2 = new com.buenosdev.filter.File("photo", "jpg", 5678);
        var file3 = new com.buenosdev.filter.File("presentation", "ppt", 3456);
        var file4 = new com.buenosdev.filter.File("music", "mp3", 7890);

        // Creating a root directory
        List<FileSystem> rootSubDirs = new ArrayList<>();
        List<com.buenosdev.filter.File> rootFiles = new ArrayList<>();
        FileSystem root = new FileSystem("root", true, rootSubDirs, rootFiles);

        // Adding files to the root directory
        root.addFile(file1);
        root.addFile(file2);
        root.addFile(augusto);
        root.addFile(larissa);

        // Creating a subdirectory
        List<FileSystem> subDir1SubDirs = new ArrayList<>();
        List<com.buenosdev.filter.File> subDir1Files = new ArrayList<>();
        FileSystem subDir1 = new FileSystem("subDir1", true, subDir1SubDirs, subDir1Files);

        // Adding files to the subdirectory
        subDir1.addFile(file3);

        // Adding the subdirectory to the root directory
        root.addSubDirectory(subDir1);

        // Creating another subdirectory
        List<FileSystem> subDir2SubDirs = new ArrayList<>();
        List<com.buenosdev.filter.File> subDir2Files = new ArrayList<>();
        FileSystem subDir2 = new FileSystem("subDir2", true, subDir2SubDirs, subDir2Files);

        // Adding files to the second subdirectory
        subDir2.addFile(file4);

        // Adding the second subdirectory to the root directory
        root.addSubDirectory(subDir2);

        // Print the structure
        printFileSystem(root, 0);

        return root;
    }

    public static void printFileSystem(FileSystem fileSystem, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(fileSystem.getName() + (fileSystem.isDirectory() ? "/" : ""));

        for (com.buenosdev.filter.File file : fileSystem.getFiles()) {
            for (int i = 0; i < indent + 1; i++) {
                System.out.print("  ");
            }
            System.out.println(file.getName() + "." + file.getExtension() + " (" + file.getSize() + " bytes)");
        }

        for (FileSystem subDir : fileSystem.getSubDirectories()) {
            printFileSystem(subDir, indent + 1);
        }
    }
}
