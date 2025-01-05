package com.buenosdev.repository;

import com.buenosdev.converter.Converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader<T> implements SourceReader<T> {
    public List<T> read(String path, Converter<T> converter) {
        List<T> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(converter.convert(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
