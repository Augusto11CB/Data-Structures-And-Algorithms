package com.buenosdev.account;
import com.buenosdev.Person;
import com.buenosdev.enums.AccountStatus;
import com.buenosdev.parkingspot.ParkingSpot;

public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    // public boolean resetPassword();
}


