package com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.usecase.delivery;

import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.Member;
import com.buenosdev.objectorienteddesign.librarymanagementsystem.domain.entities.book.BookItem;

public interface ReturnUseCase {

    public boolean returnBookItem(Member member, BookItem bookItem);
}
