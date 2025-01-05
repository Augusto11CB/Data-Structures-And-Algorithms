package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.checkout.Checkout;
import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.reservation.Reservation;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

public class Member {

    private int id;

    private String name;

    private String email;

    private String phone;

    private OffsetDateTime registrationDate;

    private List<Checkout> checkoutList;

    private List<Reservation> reservation;
}
