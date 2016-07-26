package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


    public void connect(String table, String function) throws ClassNotFoundException, SQLException,
            IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);

        //condition for table selection.
        if(table.equals(RECOGNIZED_TABLES[0]) || (table.equals(RECOGNIZED_TABLES[1]) ||
                table.equals(RECOGNIZED_TABLES[2]) || table.equals(RECOGNIZED_TABLES[3]))) {
            //stuff
            System.out.println("this if has worked");

            switch(function){
                case "add":
                    table_add();
                    break;
                case "edit":
                    table_edit();
                    break;
                case "remove":
                    table_remove();
                    break;
                case "view":
                    table_view();
                    break;
                default:
                    break;
            }

        } else{
            System.err.println("Error in Table query, Please re-enter table");
            IO io = new IO();

            String newInput = io.lineInput();
            connect(newInput, function);
        }
    }

    public void table_add(){
        System.out.println("in add");

    }

    public void table_edit(){
        System.out.println("in edit");
    }

    public void table_remove(){
        System.out.println("in remove");
    }

    //debug only
    public void table_view(){
        System.out.println("in view");
    }


}
