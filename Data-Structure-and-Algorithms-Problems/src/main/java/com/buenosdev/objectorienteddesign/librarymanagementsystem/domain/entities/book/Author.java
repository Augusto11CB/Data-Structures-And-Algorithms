package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private List<Book> books;

    private String name;

    public Author(List<Book> books, String name) {
        this.books = books;
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }
}
