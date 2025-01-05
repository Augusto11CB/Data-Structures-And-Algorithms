//package com.buenosdev;
//
//import com.buenosdev.enums.ParkingSpotType;
//import com.buenosdev.parkingspot.CompactSpot;
//import com.buenosdev.parkingspot.ElectricSpot;
//import com.buenosdev.parkingspot.HandicappedSpot;
//import com.buenosdev.parkingspot.LargeSpot;
//import com.buenosdev.parkingspot.MotorbikeSpot;
//import com.buenosdev.parkingspot.ParkingSpot;
//import com.buenosdev.vehicle.Vehicle;
//import com.buenosdev.notimplemented.*;
//
//import java.util.HashMap;
//
//public class ParkingFloor {
//    private String name;
//    private HashMap<String, HandicappedSpot> handicappedSpots;
//    private HashMap<String, CompactSpot> compactSpots;
//    private HashMap<String, LargeSpot> largeSpots;
//    private HashMap<String, MotorbikeSpot> motorbikeSpots;
//    private HashMap<String, ElectricSpot> electricSpots;
//    private HashMap<String, CustomerInfoPortal> infoPortals;
//    private ParkingDisplayBoard displayBoard;
//
//    public ParkingFloor(String name) {
//        this.name = name;
//    }
//
//    public void addParkingSpot(ParkingSpot spot) {
//        switch (spot.getType()) {
//            case HANDICAPPED:
//                handicappedSpots.put(spot.getNumber(), (HandicappedSpot) spot);
//                break;
//            case COMPACT:
//                compactSpots.put(spot.getNumber(), (CompactSpot) spot);
//                break;
//            case LARGE:
//                largeSpots.put(spot.getNumber(), (LargeSpot) spot);
//                break;
//            case MOTORBIKE:
//                motorbikeSpots.put(spot.getNumber(), (MotorbikeSpot) spot);
//                break;
//            case ELECTRIC:
//                electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
//                break;
//            default:
//                throw new RuntimeException("Wrong parking spot type!");
//        }
//    }
//
//    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
//        spot.assignVehicle(vehicle);
//        switch (spot.getType()) {
//            case ParkingSpotType.HANDICAPPED:
//                updateDisplayBoardForHandicapped(spot);
//                break;
//            case ParkingSpotType.COMPACT:
//                updateDisplayBoardForCompact(spot);
//                break;
//            case ParkingSpotType.LARGE:
//                updateDisplayBoardForLarge(spot);
//                break;
//            case ParkingSpotType.MOTORBIKE:
//                updateDisplayBoardForMotorbike(spot);
//                break;
//            case ParkingSpotType.ELECTRIC:
//                updateDisplayBoardForElectric(spot);
//                break;
//            default:
//                print("Wrong parking spot type!");
//        }
//    }
//
//    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
//        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
//            // find another free handicapped parking and assign to displayBoard
//            for (String key : handicappedSpots.keySet()) {
//                if (handicappedSpots.get(key).isFree()) {
//                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
//                }
//            }
//            this.displayBoard.showEmptySpotNumber();
//        }
//    }
//
//    private void updateDisplayBoardForCompact(ParkingSpot spot) {
//        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
//            // find another free compact parking and assign to displayBoard
//            for (String key : compactSpots.keySet()) {
//                if (compactSpots.get(key).isFree()) {
//                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
//                }
//            }
//            this.displayBoard.showEmptySpotNumber();
//        }
//    }
//
//    public void freeSpot(ParkingSpot spot) {
//        spot.removeVehicle();
//        switch (spot.getType()) {
//            case ParkingSpotType.HANDICAPPED:
//                freeHandicappedSpotCount++;
//                break;
//            case ParkingSpotType.COMPACT:
//                freeCompactSpotCount++;
//                break;
//            case ParkingSpotType.LARGE:
//                freeLargeSpotCount++;
//                break;
//            case ParkingSpotType.MOTORBIKE:
//                freeMotorbikeSpotCount++;
//                break;
//            case ParkingSpotType.ELECTRIC:
//                freeElectricSpotCount++;
//                break;
//            default:
//                print("Wrong parking spot type!");
//        }
//    }
//}
