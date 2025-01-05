package com.buenosdev.usecase.show.observer;

import com.buenosdev.entity.Show;

public interface ShowSubject {
    void addObserver(ShowObserver observer);
    void notifyAll(Show show);
}
