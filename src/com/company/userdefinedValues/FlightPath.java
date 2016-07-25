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

    private final String departureLocation;
    private final String arrivalLocation;
    private final int flightTimeinHours;

    public static class Builder{
        //required perams
        private final String departureLocation;
        private final String arrivalLocation;

        //optional perameters
        private int flightTimeinHours = 1;

        public Builder(String departureLocation, String arrivalLocation) {
            this.departureLocation = departureLocation;
            this.arrivalLocation = arrivalLocation;
        }

        public Builder flightTimeinHours(int val){
            flightTimeinHours = val;
            return this;
        }

        public FlightPath build(){
            return new FlightPath(this);
        }


    }

    private FlightPath(Builder builder){
        departureLocation = builder.departureLocation;
        arrivalLocation = builder.arrivalLocation;
        flightTimeinHours = builder.flightTimeinHours;
    }
}
