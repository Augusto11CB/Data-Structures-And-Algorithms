package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Date;
import java.util.List;

public class Book {

    private String ispb;

    private String title;

    private String author;

    private String subjectCategory;

    private String rackNumber;

    private List<BookItem> bookCopies;

    private LocalDate creationDate;

}
