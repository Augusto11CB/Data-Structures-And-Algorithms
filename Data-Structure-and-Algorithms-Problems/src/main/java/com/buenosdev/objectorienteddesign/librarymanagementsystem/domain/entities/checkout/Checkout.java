package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.checkout;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.Book;
import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.Member;

import java.time.OffsetDateTime;
import java.util.Date;

public class Checkout {

    private Book book;

    private Member member;

    private OffsetDateTime createDateTime;

    private OffsetDateTime returnDate;

    // private OffsetDateTime dueDate;

    private Status reservationStatus;

}
