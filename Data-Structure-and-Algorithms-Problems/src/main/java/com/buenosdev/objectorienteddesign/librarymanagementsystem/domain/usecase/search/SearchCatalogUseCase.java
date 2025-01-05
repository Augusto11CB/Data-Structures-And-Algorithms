package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.usecase.search;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.Book;
import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.Subject;

import java.util.Date;
import java.util.List;

public interface SearchCatalogUseCase {

    List<Book> byAuthorName(String authorName);

    List<Book> byBookName(String bookName);

    Book byBookIspb(String ispb);

    List<Book> byBookSubject(Subject bookSubject);

    List<Book> byBookPublicationDate(Date publicationDate);
}
