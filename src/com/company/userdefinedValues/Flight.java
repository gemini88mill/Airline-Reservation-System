package com.company.userdefinedValues;

import com.company.IO;

import java.util.Date;

/**
 * Flight - A class defining all the aspects of the Flight of a particular airline company
 *
 * has two variables, FlightPath and Airplane. Both are program defined classes that allow for the path designation and
 * type of airplane on said flight path.
 *
 * Flight path would be a route that a particular airline would take. ex. (Miami to Atlanta)
 * Airplane would be the type of aircraft required on the flight. ex. 737-800
 *
 * Created by raphael on 7/15/16.
 */
public class Flight {

    private FlightPath flightPath;
    private Airplane airplane;

    //new elements from flight

    //flight needs to call with the arguments, where is the flight going, when is it leaving, can when can the flight
    //come back

    /*For example, when declaring a flight, the flight will be defined the MIA to ATL flight, FLight needs to know what
    * aircraft is getting on this flight, the flight path, and the times that this flight is leaving throughout a 24
    * hour period.
    *
    * from the main method, if we were to declare Flight(String departureLocation, String ArrivalLocation) it doesn't
    * need the declaration of the flight */
    private Date departureTime;

    //-------------------------------------Constructor------------------------------------------------------------------
    public Flight(FlightPath flightPath, Airplane airplane) {
        this.flightPath = flightPath;
        this.airplane = airplane;
    }

    public Flight(FlightPath flightPath) {
        this.flightPath = flightPath;
    }

    //------------------------------------------------------------------------------------------------------------------


    public void enterFlightInformation(Passenger passenger) {
        //enter in information for flight

        IO io = new IO();

        System.out.println("Please enter in departure location:");
        String departure = io.lineInput();
        System.out.println("Please Enter Arrival Location");
        String arrival = io.lineInput();

        passenger.setPassengerDepartureLocation(departure);
        passenger.setPassengerArrivalLocation(arrival);
    }

    //------------------------------------------------------------------------------------------------------------------


    public FlightPath getFlightPath() {
        return flightPath;
    }

    public void setFlightPath(FlightPath flightPath) {
        this.flightPath = flightPath;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}
