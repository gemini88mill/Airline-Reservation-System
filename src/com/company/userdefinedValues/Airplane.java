package com.company.userdefinedValues;

/**
 * Airplane - a class that defines the airplane that is being used on any particular flight. All planes of the fleet and
 * its definitions should go here.
 *
 * Created by raphael on 7/15/16.
 */
public class Airplane {

    private final int numberOfClasses;
    private final Seat[] seats;
    private final String airplaneName;
    private String airplaneType;

    public static class Builder{

        //required values
        private final String name;
        private final Seat[] seat;

        //optional values
        private int numberOfClasses = 0;


        public Builder(String name, Seat[] seat) {
            this.name = name;
            this.seat = seat;
        }

        public Builder numberOfClasses(int val) {
            numberOfClasses = val;
            return this;
        }

        public Airplane build() {
            return new Airplane(this);
        }
    }

    private Airplane(Builder builder) {
        seats = builder.seat;
        airplaneName = builder.name;
        numberOfClasses = builder.numberOfClasses;

    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }
}
