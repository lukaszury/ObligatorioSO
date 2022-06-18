/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorioso.Modelo;

/**
 *
 * @author lukas
 */
public class Proceso implements Comparable<Proceso>{
    private String nombre;
    private static int PIDanterior;
    private int burst;
    private int burstRestante;
    private int timepoProcesado;
    private int PID;
    private Estado estado;
    private int realizaES;
    private int desbloqueadES;
    private int tiempoRestantebloqueado;

    public Proceso(String nombre, int burst, int realizaES, int desbloqueadES) {
        this.nombre = nombre;
        this.burst = burst;
        this.burstRestante = burst;
        this.realizaES = realizaES;
        this.desbloqueadES = desbloqueadES;
        this.PID = PIDanterior++;
        this.estado = Estado.Listo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getRealizaES() {
        return realizaES;
    }

    public void setRealizaES(int realizaES) {
        this.realizaES = realizaES;
    }

    public int getDesbloqueadES() {
        return desbloqueadES;
    }

    public void setDesbloqueadES(int desbloqueadES) {
        this.desbloqueadES = desbloqueadES;
    }

    public int getBurst() {
        return burst;
    }

    public void setBurst(int burst) {
        this.burst = burst;
    }

    public int getTimepoProcesado() {
        return timepoProcesado;
    }

    public void setTimepoProcesado(int timepoProcesado) {
        this.timepoProcesado = timepoProcesado;
    }

    public int getBurstRestante() {
        return burstRestante;
    }

    public void setBurstRestante(int burstRestante) {
        this.burstRestante = burstRestante;
    }

    public int getTiempoRestantebloqueado() {
        return tiempoRestantebloqueado;
    }

    public void setTiempoRestantebloqueado(int tiempoRestantebloqueado) {
        this.tiempoRestantebloqueado = tiempoRestantebloqueado;
    }
    
    

    @Override
    public String toString() {
        return "Proceso = " + nombre + " - PID = " + PID + " Tiempo de ejecucion " + burst +" - estado = " + estado + " - E/S cada = " + realizaES + " - Tiempo bloqueado = " + desbloqueadES;
    }

    @Override
    public int compareTo(Proceso p) {
        return this.tiempoRestantebloqueado - p.getTiempoRestantebloqueado();
    }

}
