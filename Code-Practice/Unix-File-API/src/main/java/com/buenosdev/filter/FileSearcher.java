package com.buenosdev.filter;

import com.buenosdev.filter.criteria.SearchCriteria;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearcher {
    public List<File> searchFiles(File directory, SearchCriteria criteria) {
        List<File> result = new ArrayList<>();
        if (directory.isDirectory()) {
            searchDirectory(directory, criteria, result);
        }
        return result;
    }

    private void searchDirectory(File directory, SearchCriteria criteria, List<File> result) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchDirectory(file, criteria, result);
                } else {
                    if (criteria.matches(file)) {
                        result.add(file);
                    }
                }
            }
        }
    }

    public List<String> findFiles(FileSystem directory, SearchCriteria criteria) {
        List<String> result = new ArrayList<>();
        Queue<FileSystem> queue = new LinkedList<>();
        queue.add(directory);

        while (!queue.isEmpty()) {
            FileSystem current = queue.poll();
            for (com.buenosdev.filter.File file : current.getFiles()) {
                if (criteria.matches(file)) {
                    result.add(file.getName());
                }
            }
            queue.addAll(current.getSubDirectories());
        }
        return result;
    }

}
