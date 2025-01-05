package com.buenosdev;

import java.io.*;
import java.util.*;

public class PropertiesFileHelper {
    public static String APPLICATION_PROPERTIES = "application.properties";
    public static final String CSV_FILE_NAME_KEY = "csv.file.name";
    public static final String DEFAULT_FILE_NAME = "default.csv";

    private  Properties properties = new Properties();

    public static String csvFileNameFromProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(APPLICATION_PROPERTIES)) {
            properties.load(input);
            return properties.getProperty(CSV_FILE_NAME_KEY, DEFAULT_FILE_NAME);
        } catch (IOException e) {
            // Log the exception (optional)
            e.printStackTrace();
            return DEFAULT_FILE_NAME;
        }
    }
}
