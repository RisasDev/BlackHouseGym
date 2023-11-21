/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.blackhousegym;

/**
 *
 * @author Mauricio
 */
public class Validaciones {
       
    public boolean isValidarCuota(String cuota) {
        try {
            return Integer.parseInt(cuota) > 0;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
}
