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
    private Estado estado;

    public Proceso(String nombre, int burstTime) {
        this.nombre = nombre;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;
        this.estado = Estado.Listo;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
    public void imprimir(){
        System.out.println(nombre +  " " + burstTime);
    }

    @Override
    public String toString() {
        return "Proceso: " + nombre + " - Tiempo requerido = " + burstTime;
    }

    
}
