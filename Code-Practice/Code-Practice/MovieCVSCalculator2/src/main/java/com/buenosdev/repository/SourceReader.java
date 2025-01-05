package com.buenosdev.repository;

import com.buenosdev.converter.Converter;

import java.util.List;
public interface SourceReader<T> {
    List<T> read(String path, Converter<T> converter);
}
