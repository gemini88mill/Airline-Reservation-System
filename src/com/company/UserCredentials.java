package com.company;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by raphael on 7/9/16.
 */
public class UserCredentials {

    private String name;
    private String classPreference;
    private String seatPreference;
    private Date departureDate;
    private Date returnDate;

    public UserCredentials(String name, String classPreference, String seatPreference, Date departureDate,
                           Date returnDate) {
        this.name = name;
        this.classPreference = classPreference;
        this.seatPreference = seatPreference;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassPreference() {
        return classPreference;
    }

    public void setClassPreference(String classPreference) {
        this.classPreference = classPreference;
    }

    public String getSeatPreference() {
        return seatPreference;
    }

    public void setSeatPreference(String seatPreference) {
        this.seatPreference = seatPreference;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
