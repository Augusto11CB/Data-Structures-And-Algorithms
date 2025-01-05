package com.buenosdev.amz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    public List<File> searchFiles(File directory, FileSearchCriteria criteria) {
        List<File> result = new ArrayList<>();
        if (directory.isDirectory()) {
            searchDirectory(directory, criteria, result);
        }
        return result;
    }

    private void searchDirectory(File directory, FileSearchCriteria criteria, List<File> result) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchDirectory(file, criteria, result);
                } else {
                    if (matchesCriteria(file, criteria)) {
                        result.add(file);
                    }
                }
            }
        }
    }

    private boolean matchesCriteria(File file, FileSearchCriteria criteria) {
        boolean matches = true;

        if (criteria.getName().isPresent()) {
            matches = file.getName().contains(criteria.getName().get());
        }

        if (matches && criteria.getExtension().isPresent()) {
            matches = file.getName().endsWith("." + criteria.getExtension().get());
        }

//        if (matches && criteria.getMinSize().isPresent()) {
//            matches = file.length() >= criteria.getMinSize().get();
//        }
//
//        if (matches && criteria.getMaxSize().isPresent()) {
//            matches = file.length() <= criteria.getMaxSize().get();
//        }

        if (matches && criteria.getSize().isPresent() && criteria.getOperator().isPresent()) {

            switch (criteria.getOperator().get()) {
                case ">":
                    matches = file.length() > criteria.getSize().get();
                    break;
                case ">=":
                    matches = file.length() >= criteria.getSize().get();
                    break;
                case "<":
                    matches = file.length() < criteria.getSize().get();
                    break;
                case "<=":
                    matches = file.length() <= criteria.getSize().get();
                    break;
                case "==":
                    matches = file.length() == criteria.getSize().get();
                    break;
                default:
                    matches = false;
            }
        }
        return matches;
    }
}
