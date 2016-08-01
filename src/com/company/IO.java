package com.company;

import com.company.userdefinedValues.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IO {


    /**
     * Main function - program starts here.
     * @param args
     */
    public static void main(String[] args) {
	    // write your code here
        IO io = new IO();
        UserCredentials uc = null;

        //Chronology

        //Enter User information
        //uc = io.inputField(uc);

        //get send user credentials to classes
        //Passenger passenger = new Passenger(uc.getName(), uc.getClassPreference(), uc.getSeatPreference(),
         //       "AC707 (String Literal)", null);


        //--------------------------------------------------------------------------------------------------------------
        //Database part of the program.
        /*Pull information from mySql Database
        *   -Flight Path information
        *   -Fleet Information
        *   -Seat Descriptions
        *   -Passenger Manifest*/

        Passenger passenger = new Passenger("Raphael", "Miller", "AB0123456", null, null);

        MySQLHandler sqlHandler = new MySQLHandler();

        String table = "Passenger_Manifest";
        String sqlValueToChange = "Airplane_ID";
        String valueTomark = "Airplane_ID";

        String function = "add";

        //String sqlValuesFleet_Manifest = "'111-HHH',  '747-8', 9800, 400, 1, 1";
        PreparedStatement insertPassenger = null;



        try {
            sqlHandler.connect(table, function, passenger);
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //-------------------------------------------------------------------------------------------------------------
        //done with my sql, passenger information is placed in mysql for saving,

        //place passenger on board, save information to mySql.




        //---------------------------------------------------------------

        Date flightTime = new Date();

        //todo work on a consistent way for date and calendar to work together

        DateFormat dfm = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        System.out.println(dfm.format(flightTime.getTime()));

        //Airplane Boeing777 = new Airplane(new Passenger[300], new Seat[300], "777", "777");



        //Flight flight = new Flight(MiaToAtl, Boeing777);
        //flight.enterFlightInformation(passenger);

        //passenger.viewFromClass(); //good check out //



        //select flight

        //book flight
    }



    /**
     * Simple IO input method, allows input from computer to be sent to various varibles within the program.
     * Additionally, can be accessed from all classes.
     * @return String
     */
    public String lineInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * InputField - gives prompts to the user to enter in passenger information. Thus allowing the flow of the program.
     * @param uc
     * @return UserCredentials
     */
    public UserCredentials inputField(UserCredentials uc){

        final String FIRST = "FIRST";
        final String BUSINESS = "BUSINESS";
        final String ECONOMY = "ECONOMY";
        final String NA = "NA";

        final String SEAT_WINDOW = "WINDOW";
        final String SEAT_AISLE = "AISLE";
        final String SEAT_NA = "NA";

        Date departureDate = null;
        Date returnDate = null;

        //Dateformat declaration for calendar.
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        //input field for chronological program format
        System.out.println("Enter Passenger Name:");
        String userName = lineInput().toUpperCase();
        if(userName.length() > 100){
            System.err.println("Name too long");
            inputField(uc);
        }

        System.out.println("Enter Class Preference (First, Business, Economy)");
        String classPreference = lineInput().toUpperCase();
        //todo: this isn't working properly, always throwing errors
        if(!classPreference.equals(FIRST) || !classPreference.equals(BUSINESS) || !classPreference.equals(ECONOMY)){
            System.err.println("Not accepted class preference");
        }

        System.out.println("Enter Seat Preference:");
        String seatPreference = lineInput().toUpperCase();
        //todo: this isn't working properly, always throwing errors
        if(!seatPreference.equals(SEAT_WINDOW) || !seatPreference.equals(SEAT_AISLE) || !seatPreference.equals(SEAT_NA)){
            System.err.println("Seat selection not valid");
        }

        System.out.println("Enter date of departure: (MM-DD-YYYY)");
        String departureDateString = lineInput();

        System.out.println("Enter date of Return: (MM-DD_YYYY)");
        String returnDateString = lineInput();

        try {
            departureDate = df.parse(departureDateString);
            returnDate = df.parse(returnDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert departureDate != null;
        if(departureDate.before(new Date()))
            System.err.println("Selected date " + departureDate.toString() + " before today's date:");

        assert returnDate != null;
        if(returnDate.before(departureDate) || returnDate.before(new Date()))
            System.err.println("Selected date " + returnDate.toString() + " before departure date: " +
                    departureDate.toString() + " You are not a time lord");

        uc = new UserCredentials(userName, classPreference, seatPreference, departureDate, returnDate);
        return uc;
    }
}
