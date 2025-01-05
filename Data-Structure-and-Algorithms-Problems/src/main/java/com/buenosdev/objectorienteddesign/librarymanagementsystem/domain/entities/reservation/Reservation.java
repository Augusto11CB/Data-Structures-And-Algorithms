package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.reservation;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.Book;
import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.Member;

import java.time.OffsetDateTime;
import java.util.Date;

public class Reservation {

    private Member member;

    private Book book;

    private ReservationStatus reservation;

    private OffsetDateTime creationDateTime;
}
