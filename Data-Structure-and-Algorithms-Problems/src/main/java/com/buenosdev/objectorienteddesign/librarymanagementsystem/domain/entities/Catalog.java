package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.BookItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {

    private int totalBooks;

    private Map<String, List<BookItem>> books = new HashMap<>();

    private Map<String, List<BookItem>> booksAuthors = new HashMap<>();

    private Map<String, List<BookItem>> booksC = new HashMap<>();


}
