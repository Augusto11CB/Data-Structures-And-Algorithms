package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.usecase.checkout;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.BookItem;

public interface CheckoutUseCase {

    public boolean checkoutBookItem(BookItem bookItem);
}
