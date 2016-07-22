package com.company.userdefinedValues;

import java.util.Calendar;
import java.util.Date;

/**
 * Flight Path - Class that defines the path that a flight will take. Flight path has the function of providing the
 * information of the flight path along with the times of the flight. Along with the expected arrival and departure time
 *
 *
 *
 * Created by raphael on 7/15/16.
 */
public class FlightPath {

    private Date flightStart;
    private Date flightEnd;
    private String flightDestinationLocation;
    private String flightArrivalLocation;


    public FlightPath(Date flightStart, Date flightEnd, String flightDestinationLocation, String flightArrivalLocation) {
        this.flightStart = flightStart;
        this.flightEnd = flightEnd;
        this.flightDestinationLocation = flightDestinationLocation;
        this.flightArrivalLocation = flightArrivalLocation;
    }

    public FlightPath() {
        //blank constructor
    }

    public Date getFlightStart() {
        return flightStart;
    }

    public void setFlightStart(Date flightStart) {
        this.flightStart = flightStart;
    }

    public Date getFlightEnd() {
        return flightEnd;
    }

    public void setFlightEnd(Date flightEnd) {
        this.flightEnd = flightEnd;
    }

    public String getFlightDestinationLocation() {
        return flightDestinationLocation;
    }

    public void setFlightDestinationLocation(String flightDestinationLocation) {
        this.flightDestinationLocation = flightDestinationLocation;
    }

    public String getFlightArrivalLocation() {
        return flightArrivalLocation;
    }

    public void setFlightArrivalLocation(String flightArrivalLocation) {
        this.flightArrivalLocation = flightArrivalLocation;
    }
}
