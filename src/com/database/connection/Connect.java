package com.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static String url = "jdbc:mysql://localhost:3306/test";
    public static String user = "root";
    public static String pass = "";

    public static Connection Con()throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            return con;
        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
