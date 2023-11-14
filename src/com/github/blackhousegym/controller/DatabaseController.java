/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.blackhousegym.controller;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author cetecom
 */
public class DatabaseController {
    
    private final Connection connection;
    
    private final String CREAR_MIEMBRO_SQL = "INSERT INTO miembro values("
            + "null, 'rut', 'nombre', 'apellidoPaterno', 'apellidoMaterno', 'taller', dias, cuota)";
    
    public DatabaseController(Connection connection) {
        this.connection = connection;
    }
    
    public void crearMiembro(String rut, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String taller, int diasInscritos, int cuotaMensual) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREAR_MIEMBRO_SQL
                    .replace("rut", rut)
                    .replace("nombre", nombre)
                    .replace("apellidoPaterno", apellidoPaterno)
                    .replace("apellidoMaterno", apellidoMaterno)
                    .replace("taller", taller)
                    .replace("dias", String.valueOf(diasInscritos))
                    .replace("cuota", String.valueOf(cuotaMensual)));
        } 
        catch (Exception e) {
            System.out.println("Error al crear un miembro.");
        }
    }
}
