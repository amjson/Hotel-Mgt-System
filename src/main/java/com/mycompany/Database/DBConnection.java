/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JoeAlpha
 */
public class DBConnection {
    // setting connection to the database
    public static Connection setConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/my_hotel_mgt", "root", "");
        
        return conn;
    }
}
