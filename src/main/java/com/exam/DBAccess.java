/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Instructor
 */
public class DBAccess {

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123456");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
