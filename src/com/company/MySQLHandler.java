package com.company;

import com.company.userdefinedValues.Passenger;

import java.sql.*;

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

    private final String[] RECOGNIZED_TABLES = {"Fleet_Manifest", "Flight_Path", "Seat_Information",
            "Passenger_Manifest"};


    public void connect(String table, String function, Passenger sqlValuesPassenger_Manifest)
            throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
        Statement statement = con.createStatement();

        PreparedStatement stmt = null;

        //condition for table selection.
        if(table.equals(RECOGNIZED_TABLES[0]) || (table.equals(RECOGNIZED_TABLES[1]) ||
                (table.equals(RECOGNIZED_TABLES[2]) || (table.equals(RECOGNIZED_TABLES[3])
                        || (table.equals(RECOGNIZED_TABLES[4])))))) {
            //stuff
            //System.out.println("this if has worked");

            switch(function){
                case "add":
                    table_add(table, con, sqlValuesPassenger_Manifest, statement, stmt);
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
            connect(newInput, function, sqlValuesPassenger_Manifest);
        }

        con.close();

    }

    //working

    /**
     * table_add() method, adds values to table in database based on direction of the arguments table (table name),
     * and sqlValues(String) in this case FleetManifest. Main table used would be Passenger Manifest.
     * @param table String
     * @param con Connection
     * @param sqlValues String
     * @param statement Statement
     * @param stmt
     */
    public void table_add(String table, Connection con, Passenger sqlValues, Statement statement,
                          PreparedStatement stmt){
        System.out.println("in add");

        try {
            String insertStatement = "INSERT INTO "
                    + table
                    + " (First_Name, Last_Name, Passport_Number, Seat_Assignment, Additional_Request) VALUES"
                    + "(?,?,?,?,?)";

            stmt = con.prepareStatement(insertStatement);
            stmt.setString(1, sqlValues.getPassengerFirstName());
            stmt.setString(2, sqlValues.getPassengerLastName());
            stmt.setString(3, sqlValues.getPassengerPassportNumber());
            stmt.setString(4, sqlValues.getPassengerSeatAssignment());
            stmt.setString(5, sqlValues.getAdditonalRequests());

            stmt.executeUpdate();

            //statement = con.createStatement();


            System.out.println(sqlValues.getPassengerFirstName());

            //statement.executeUpdate("INSERT INTO " + table + " VALUES ("+ sqlValues +")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * table_edit() - method that allows for editing of database data
     * @param table String
     * @param statement Statement
     * @param con Connection
     */
    public void table_edit(String table, Statement statement, Connection con){
        System.out.println("in edit");
        try {
            statement = con.createStatement();

            String sqlStmt = "UPDATE " + table + " SET " + "Airplane_ID = '000-HHH' WHERE Airplane_ID = '123-HHH' ";

            //todo make editing more powerful, or just do a delete then re-add

            statement.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * table_remove() - method that allows for removal of data from database tables, requires name of table
     * (String table), statement (open ended statement from java.mysql), and a connection to the database
     * (Connection con)
     * @param table String
     * @param statement Statement
     * @param con Connection
     */
    public void table_remove(String table, Statement statement, Connection con){
        System.out.println("in remove");

        try {
            statement = con.createStatement();

            String sqlStmt = "DELETE FROM " + table + " WHERE " + " Airplane_ID = '000-000'";

            statement.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //create remove query
    }

    //debug only

    /**
     * table_view() - method that allows for the viewing of the table, useful for viewing passenger manifest along with
     * other table viewing properties. Requires table being viewed (String Table), open statement (Statement statement)
     * and database connection.
     * @param table String
     * @param statement Statement
     * @param con Connection
     */
    public void table_view(String table, Statement statement, Connection con){
        System.out.println("in view");
        //create view

        try {
            statement = con.createStatement();

            String sqlStmt = "SELECT * FROM " + table;

            ResultSet resultSet = statement.executeQuery(sqlStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void table_search(String table, Statement statement, Connection con){
        System.out.println("in search");
    }


}
