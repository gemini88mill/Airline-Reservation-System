package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by raphael on 7/24/16.
 *
 * Deals with all information regarding MySQL Database information
 */
public class MySQLHandler {

    private final String DATABASE = "Raphael_Airlines";
    private final String USERNAME = "java";
    private final String PASSWORD = "jarvis";
    private final String URL = "jdbc:mysql://localhost:3306/";

    private final String[] RECOGNIZED_TABLES = {"Fleet_Manifest", "Flight_Path", "Seat_Information"};


    public void connect(String table, String function, String sqlValuesFleet_Manifest)
            throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
        Statement statement = con.createStatement();

        //condition for table selection.
        if(table.equals(RECOGNIZED_TABLES[0]) || (table.equals(RECOGNIZED_TABLES[1]) ||
                table.equals(RECOGNIZED_TABLES[2]) || table.equals(RECOGNIZED_TABLES[3]))) {
            //stuff
            System.out.println("this if has worked");

            switch(function){
                case "add":
                    table_add(table, con, sqlValuesFleet_Manifest, statement);
                    break;
                case "edit":
                    table_edit(table, statement, con);
                    break;
                case "remove":
                    table_remove(table, statement, con);
                    break;
                case "view":
                    table_view(table, statement, con);
                    break;
                default:
                    break;
            }

        } else{
            System.err.println("Error in Table query, Please re-enter table");
            IO io = new IO();

            String newInput = io.lineInput();
            connect(newInput, function, sqlValuesFleet_Manifest);
        }

        con.close();

    }

    //working

    /**
     * table_add() method, adds values to table in database based on direction of the arguments table (table name),
     * and sqlValues(String) in this case FleetManifest. Main table used would be Passenger Manifest.
     * @param table
     * @param con
     * @param sqlValues
     * @param statement
     */
    public void table_add(String table, Connection con, String sqlValues, Statement statement){
        System.out.println("in add");

        try {
            statement = con.createStatement();

            statement.executeUpdate("INSERT INTO " + table + " VALUES ("+ sqlValues +")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //create add query

    }

    public void table_edit(String table, Statement statement, Connection con){
        System.out.println("in edit");
        try {
            statement = con.createStatement();

            String sql;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //create edit query
    }

    public void table_remove(String table, Statement statement, Connection con){
        System.out.println("in remove");
        //create remove query
    }

    //debug only
    public void table_view(String table, Statement statement, Connection con){
        System.out.println("in view");
        //create view
    }


}
