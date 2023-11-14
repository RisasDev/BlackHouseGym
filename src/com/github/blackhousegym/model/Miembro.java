/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.blackhousegym.model;

/**
 *
 * @author cetecom
 */
public class Miembro {
    
    private int id, diasInscrito, cuotaMensual;
    private String rut, nombre, apellidoPaterno, apellidoMaterno, taller;

    public Miembro() {
    }

    public Miembro(int id, int diasInscrito, int cuotaMensual, String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String taller) {
        this.id = id;
        this.diasInscrito = diasInscrito;
        this.cuotaMensual = cuotaMensual;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.taller = taller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiasInscrito() {
        return diasInscrito;
    }

    public void setDiasInscrito(int diasInscrito) {
        this.diasInscrito = diasInscrito;
    }

    public int getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(int cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }
}
