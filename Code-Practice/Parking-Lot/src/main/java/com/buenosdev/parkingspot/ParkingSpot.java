package com.buenosdev.parkingspot;

import com.buenosdev.enums.ParkingSpotType;
import com.buenosdev.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public boolean IsFree() {
        return free;
    }

    public String getNumber() {
        return number;
    }

    public ParkingSpotType getType() {
        return this.type;
    }
    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;

        return true;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;

        return true;
    }

}






