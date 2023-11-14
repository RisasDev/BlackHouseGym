/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.blackhousegym.database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author cetecom
 */
public class DatabaseConnection {
    
    private Connection connection;

    public void connect() {        
        try{
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bdjava", 
                    "root", 
                    "");
            System.out.println("Database conectada correctamente.");
        }
        catch(Exception ex ){
            System.out.println("Database no conectada.");
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public boolean isConnected() {
        return connection != null;
    }
}
