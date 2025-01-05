package com.buenosdev.converter;

public interface Converter<T> {
    T convert(String[] data);

    T convert(String s);
}
