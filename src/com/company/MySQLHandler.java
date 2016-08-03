package com.company;

import com.company.userdefinedValues.Passenger;

import java.sql.*;

/**
 * Created by raphael on 7/24/16.
 *
 * Deals with all information regarding MySQL Database information
 */
public class MySQLHandler {

    //------------------------------------------------------------------

    private final String DATABASE = "Raphael_Airlines";
    private final String USERNAME = "java";
    private final String PASSWORD = "jarvis";
    private final String URL = "jdbc:mysql://localhost:3306/";

    //------------------------------------------------------------------

    private final String[] RECOGNIZED_TABLES = {"Fleet_Manifest", "Flight_Path", "Seat_Information",
            "Passenger_Manifest"};

    private final String COLUMNS_PASSENGER =
            "(First_Name, Last_Name, Passport_Number, Seat_Assignment, Additional_Request) ";


    public void connect(String table, String function, Passenger sqlValues, String marker,
                        int markerColumnTag)
            throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        //connects to MySQL Database
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
        Statement statement = con.createStatement();

        PreparedStatement stmt = null;

        //gets meta data from table asked for
        ResultSet rs = statement.executeQuery("SELECT * FROM " + table);
        ResultSetMetaData metaData = rs.getMetaData();
        String[] columns = new String[metaData.getColumnCount()];

        //puts names into string for later use.
        for (int x = 0; x < metaData.getColumnCount(); x++){
            columns[x] = metaData.getColumnName(x + 1);
            //System.out.println(columns[x]);
        }

        String markerTagString = metaData.getColumnName(markerColumnTag);

        //condition for table selection.
        if(table.equals(RECOGNIZED_TABLES[0]) || (table.equals(RECOGNIZED_TABLES[1]) ||
                (table.equals(RECOGNIZED_TABLES[2]) || (table.equals(RECOGNIZED_TABLES[3])
                        || (table.equals(RECOGNIZED_TABLES[4])))))) {
            //stuff
            //System.out.println("this if has worked");

            switch(function){
                case "add":
                    table_add(table, con, sqlValues);
                    break;
                case "edit":
                    table_edit(table, con, sqlValues, columns, marker, markerTagString);
                    break;
                case "remove":
                    table_remove(table, statement, con);
                    break;
                case "view":
                    table_view(table, statement, con, sqlValues);
                    break;
                default:
                    break;
            }

        } else{
            System.err.println("Error in Table query, Please re-enter table");
            IO io = new IO();

            String newInput = io.lineInput();
            connect(newInput, function, sqlValues, marker, markerColumnTag);
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
     */
    public void table_add(String table, Connection con, Passenger sqlValues){
        System.out.println("in add");
        PreparedStatement stmt;

        try {
            String insertStatement = "INSERT INTO "
                    + table
                    + COLUMNS_PASSENGER
                    + " VALUES"
                    + "(?,?,?,?,?)";

            stmt = con.prepareStatement(insertStatement);
            stmt.setString(1, sqlValues.getPassengerFirstName().toUpperCase());
            stmt.setString(2, sqlValues.getPassengerLastName().toUpperCase());
            stmt.setString(3, sqlValues.getPassengerPassportNumber().toUpperCase());
            stmt.setString(4, sqlValues.getPassengerSeatAssignment());
            stmt.setString(5, sqlValues.getAdditonalRequests());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * table_edit() - method that allows for editing of database data
     *
     * Uses Marker and marker value to ditate where the ENTIRE query should be modified. Make sure passenger has
     * correct values otherwise huge problems can arise.
     * @param table String
     * @param con Connection
     * @param sqlValues Passenger
     * @param columns String[]
     * @param markerValue String
     * @param marker String
     */
    public void table_edit(String table, Connection con, Passenger sqlValues,
                           String[] columns, String markerValue, String marker){
        System.out.println("in edit");
        try {

            StringBuilder sqlQuery = new StringBuilder();

            for (String column : columns) {
                sqlQuery.append(column);
                sqlQuery.append("= ?, ");
            }

            sqlQuery.delete(sqlQuery.length() - 2, sqlQuery.length() - 1);

            System.out.println(sqlQuery);
            //get information from sql server

            String sqlStmt = "UPDATE "
                    + table
                    + " SET "
                    + sqlQuery //5 ?'s
                    +" WHERE "
                    + marker + " = ?";

            PreparedStatement stmt = con.prepareStatement(sqlStmt);
            stmt.setString(1, sqlValues.getPassengerFirstName().toUpperCase());
            stmt.setString(2, sqlValues.getPassengerLastName().toUpperCase());
            stmt.setString(3, sqlValues.getPassengerPassportNumber().toUpperCase());
            stmt.setString(4, sqlValues.getPassengerSeatAssignment());
            stmt.setString(5, sqlValues.getAdditonalRequests());
            stmt.setString(6, markerValue);

            stmt.executeUpdate();
            //todo make editing more powerful, or just do a delete then re-add
            //todo update table edit with preparedStatement method. Along with other methods

            //statement.executeUpdate(sqlStmt);
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
    public void table_view(String table, Statement statement, Connection con, Passenger passenger){
        System.out.println("in view");
        //create view

        try {
            statement = con.createStatement();

            String sqlStmt = "SELECT * FROM " + table;

            ResultSet resultSet = statement.executeQuery(sqlStmt);
            ResultSetMetaData rsmd = resultSet.getMetaData();

            int columnNo = rsmd.getColumnCount();

            System.out.println("Departure Location: " + passenger.getPassengerDepartureLocation());
            System.out.println("Arrival Location: " + passenger.getPassengerArrivalLocation());

            while (resultSet.next()) {
                for (int x = 1; x < columnNo; x++) {
                    System.out.print(rsmd.getColumnName(x) + ":\t");
                    System.out.println("\t\t" + resultSet.getString(x));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void table_search(String table, Statement statement, Connection con){
        System.out.println("in search");
    }


}
