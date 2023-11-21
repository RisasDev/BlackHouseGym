/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.blackhousegym.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author cetecom
 */
public class DatabaseController {
    
    private final Connection connection;
    
    private final String INSERT_MIEMBRO_SQL = "INSERT INTO miembro"
            + "(rut, nombre, appaterno, apmaterno, taller, dias_inscritos, cuota_mensual) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?);";
    private final String UPDATE_MIEMBRO_SQL = "UPDATE miembro SET "
            + "rut = ?, nombre = ?, appaterno = ?, apmaterno = ?, taller = ?, dias_inscritos = ?, cuota_mensual = ? "
            + "WHERE rut = ?;";
    private final String DELETE_MIEMBRO_SQL = "DELETE FROM miembro WHERE rut = ?;";
    private final String SELECT_MIEMBRO_SQL = "SELECT * FROM miembro WHERE rut = ?;";
    private final String SELECT_MIEMBROS_SQL = "SELECT * FROM miembro;";
    
    public DatabaseController(Connection connection) {
        this.connection = connection;
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
    public int agregarMiembro(String rut, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String taller, int diasInscritos, String cuotaMensual) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MIEMBRO_SQL);
            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellidoPaterno);
            preparedStatement.setString(4, apellidoMaterno);
            preparedStatement.setString(5, taller);
            preparedStatement.setInt(6, diasInscritos);
            preparedStatement.setInt(7, Integer.parseInt(cuotaMensual));
            return preparedStatement.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int eliminarMiembro(String rut) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MIEMBRO_SQL);
            preparedStatement.setString(1, rut);
            return preparedStatement.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public ResultSet obtenerMiembro(String rut) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MIEMBRO_SQL);
            preparedStatement.setString(1, rut);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? resultSet : null;
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public int modificarMiembro(String rutIngresado, String rut, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String taller, int diasInscritos, String cuotaMensual) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MIEMBRO_SQL
                    .replace("%rut_miembro%", rutIngresado));
            
            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellidoPaterno);
            preparedStatement.setString(4, apellidoMaterno);
            preparedStatement.setString(5, taller);
            preparedStatement.setInt(6, diasInscritos);
            preparedStatement.setInt(7, Integer.parseInt(cuotaMensual));
            preparedStatement.setString(8, rutIngresado);
            return preparedStatement.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public ResultSet listarMiembros() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MIEMBROS_SQL);
            return preparedStatement.executeQuery();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public boolean existeMiembro(String rut) {
       try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MIEMBRO_SQL);
            preparedStatement.setString(1, rut);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) return false;
            
            return resultSet.getInt(1) > 0;
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
