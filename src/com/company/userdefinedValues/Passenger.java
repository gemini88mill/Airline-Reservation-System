package com.company.userdefinedValues;

/**
 * Created by raphael on 7/11/16.
 */
public class Passenger {

    //information on passenger

    private String passengerDepartureLocation;
    private String passengerArrivalLocation;

    private String passengerFirstName;
    private String passengerLastName;
    private String passengerPassportNumber;
    private String passengerSeatAssignment;
    private String additonalRequests;

    //passenger constructor
    public Passenger(String passengerDepartureLocation, String passengerArrivalLocation) {
        this.passengerDepartureLocation = passengerDepartureLocation;
        this.passengerArrivalLocation = passengerArrivalLocation;
    }

    public Passenger(String passengerFirstName, String passengerLastName, String passengerPassportNumber,
                     String passengerSeatAssignment, String additionalRequests) {
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.passengerPassportNumber = passengerPassportNumber;
        this.passengerSeatAssignment = passengerSeatAssignment;
        this.additonalRequests = additionalRequests;
    }

    public void sendToSQL(){

    }

    public void viewFromClass(){
        //allows debugging of variables

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

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerPassportNumber() {
        return passengerPassportNumber;
    }

    public void setPassengerPassportNumber(String passengerPassportNumber) {
        this.passengerPassportNumber = passengerPassportNumber;
    }

    public String getPassengerSeatAssignment() {
        return passengerSeatAssignment;
    }

    public void setPassengerSeatAssignment(String passengerSeatAssignment) {
        this.passengerSeatAssignment = passengerSeatAssignment;
    }

    public String getAdditonalRequests() {
        return additonalRequests;
    }

    public void setAdditonalRequests(String additonalRequests) {
        this.additonalRequests = additonalRequests;
    }
}
