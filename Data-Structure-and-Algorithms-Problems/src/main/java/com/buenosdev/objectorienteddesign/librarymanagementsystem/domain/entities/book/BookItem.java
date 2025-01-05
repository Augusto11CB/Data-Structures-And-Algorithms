package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.Rack;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Date;

public class BookItem {

    // There will be several BookItems for a book;
    private int id;

    private Book book;

    private Rack placedAt;

    private LocalDate publicationDate;

    // DG
    private OffsetDateTime borrowed;

    // DG
    private OffsetDateTime dueDate;

    private Status status;

    private LocalDate dateOfInclusion;


    // private BookFormat format;

    // we have to know who was the book borrowed by
    // we must keep track of members interested in borrow the book
}
