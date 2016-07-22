package com.company.userdefinedValues;

/**
 * Airplane - a class that defines the airplane that is being used on any particular flight. All planes of the fleet and
 * its definitions should go here.
 *
 * Created by raphael on 7/15/16.
 */
public class Airplane {

    private Passenger[] passengers;
    private Seat[] seats;
    private String airplaneName;
    private String airplaneType;

    public Airplane(Passenger[] passengers, Seat[] seats, String airplaneName, String airplaneType) {
        this.passengers = passengers;
        this.seats = seats;
        this.airplaneName = airplaneName;
        this.airplaneType = airplaneType;
    }

    public Airplane() {
        //blank constructor
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }
}
