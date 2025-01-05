package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.notification;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.Member;
import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.BookItem;
import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.checkout.Checkout;

public class NotificationRegistry {

    private BookItem loan;

    private Member member;

    private NotificationType type;

}
