package daos;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/myDataBase";
    public static final String USER = "jr";
    public static final String PASS = "jr123";

    public static Connection getConnection(){
        try {
           // System.out.println("SQL connection to database established!");
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException ex) {
            //throw new RuntimeException("Error connecting to the database", ex);
            System.err.println(ex);
            return null;
        }
    }

//    public static void main(String[] args) {
//    //   Connection connection =  daos.ConnectionFactory.getConnection();
//
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//
//        }catch (ClassNotFoundException e){
//            System.out.println("MySQL Driver not found");
//            return;
//        }
//
//        getConnection();
//    }

}
