/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorioso.Modelo;

/**
 *
 * @author lukas
 */
public class Proceso {
    private String nombre;
    private int burstTime;
    private int remainingBurstTime;
    private boolean activo;

    public Proceso(String nombre, int burstTime) {
        this.nombre = nombre;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;
        this.activo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getRemainingBurstTime() {
        return remainingBurstTime;
    }

    public void setRemainingBurstTime(int remainingBurstTime) {
        this.remainingBurstTime = remainingBurstTime;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    public void imprimir(){
        System.out.println(nombre +  " " + burstTime);
    }

    @Override
    public String toString() {
        return "Procesando actualmente: " + nombre + " - Tiempo requerido = " + burstTime + " - Tiempo restante = " + remainingBurstTime;
    }

    
}
