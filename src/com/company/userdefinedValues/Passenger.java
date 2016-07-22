package com.company.userdefinedValues;

/**
 * Created by raphael on 7/11/16.
 */
public class Passenger {

    //information on passenger
    private String passengerName;
    private String passengerPreferredClass;
    private String passengerPreferredSeatType;
    private String passengerFlight;
    private String passengerSeatAssignment;

    private String passengerDepartureLocation;
    private String passengerArrivalLocation;

    //passenger constructor
    public Passenger(String passengerName, String passengerPreferredClass, String passengerPreferredSeatType,
                     String passengerFlight, String passengerSeatAssignment) {
        this.passengerName = passengerName;
        this.passengerPreferredClass = passengerPreferredClass;
        this.passengerPreferredSeatType = passengerPreferredSeatType;
        this.passengerFlight = passengerFlight;
        this.passengerSeatAssignment = passengerSeatAssignment;
    }

    public Passenger(String passengerDepartureLocation, String passengerArrivalLocation) {
        this.passengerDepartureLocation = passengerDepartureLocation;
        this.passengerArrivalLocation = passengerArrivalLocation;
    }

    public void sendToSQL(){

    }

    public void viewFromClass(){
        //allows debugging of variables
        System.out.println("From Passenger Class:");
        System.out.println(getPassengerName());
        System.out.println(getPassengerFlight());
        System.out.println(getPassengerPreferredClass());
        System.out.println(getPassengerPreferredSeatType());
        System.out.println(getPassengerSeatAssignment());
        System.out.println(getPassengerDepartureLocation());
        System.out.println(getPassengerArrivalLocation());
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerPreferredClass() {
        return passengerPreferredClass;
    }

    public void setPassengerPreferredClass(String passengerPreferredClass) {
        this.passengerPreferredClass = passengerPreferredClass;
    }

    public String getPassengerPreferredSeatType() {
        return passengerPreferredSeatType;
    }

    public void setPassengerPreferredSeatType(String passengerPreferredSeatType) {
        this.passengerPreferredSeatType = passengerPreferredSeatType;
    }

    public String getPassengerFlight() {
        return passengerFlight;
    }

    public void setPassengerFlight(String passengerFlight) {
        this.passengerFlight = passengerFlight;
    }

    public String getPassengerSeatAssignment() {
        return passengerSeatAssignment;
    }

    public void setPassengerSeatAssignment(String passengerSeatAssignment) {
        this.passengerSeatAssignment = passengerSeatAssignment;
    }

    public String getPassengerDepartureLocation() {
        return passengerDepartureLocation;
    }

    public void setPassengerDepartureLocation(String passengerDepartureLocation) {
        this.passengerDepartureLocation = passengerDepartureLocation;
    }

    public String getPassengerArrivalLocation() {
        return passengerArrivalLocation;
    }

    public void setPassengerArrivalLocation(String passengerArrivalLocation) {
        this.passengerArrivalLocation = passengerArrivalLocation;
    }
}
