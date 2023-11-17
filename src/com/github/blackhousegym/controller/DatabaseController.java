/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.blackhousegym.controller;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cetecom
 */
public class DatabaseController {
    
    private final Connection connection;
    
    private final String CREAR_MIEMBRO_SQL = "INSERT INTO miembro(rut, nombre, appaterno, apmaterno, taller, dias_inscritos, cuota_mensual) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?);";
    
    public DatabaseController(Connection connection) {
        this.connection = connection;
    }
    
    public void crearMiembro(Component parentComponent, String rut, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String taller, int diasInscritos, String cuotaMensual) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREAR_MIEMBRO_SQL);
            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellidoPaterno);
            preparedStatement.setString(4, apellidoMaterno);
            preparedStatement.setString(5, taller);
            preparedStatement.setInt(6, diasInscritos);
            preparedStatement.setString(7, cuotaMensual);
            
            if (preparedStatement.executeUpdate() > 0){
                     JOptionPane.showMessageDialog(parentComponent, "Registro insertado exitosamente.");
            } 
            else {
                JOptionPane.showMessageDialog(parentComponent, 
                       "No se pudo insertar el registro.", 
                       "Error", 
                       JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(parentComponent,
                        "Error al ejecutar la consulta.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
