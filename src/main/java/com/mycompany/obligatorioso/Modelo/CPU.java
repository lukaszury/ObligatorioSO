/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorioso.Modelo;

import com.mycompany.obligatorioso.UI.FrmSimulacion;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author lukas
 */
public class CPU {

    private int quantum = 2;
    private Vector<Proceso> colaListos;
    private Vector<Proceso> colaBloqueados;
    private Vector<Proceso> colaTerminados;
    private Proceso actual;
    private int indiceActual;
    private boolean procesando;
    private ArrayList<FrmSimulacion> observers;

    public CPU() {
        colaListos = new Vector<>();
        colaBloqueados = new Vector<>();
        colaTerminados = new Vector<>();
        observers = new ArrayList<>();
        actual = null;
        indiceActual = 0;
        procesando = false;
    }

    public void procesar() {
        procesando = true;

        System.out.println("Procesando");

        while (procesando) {

            while (!colaListos.isEmpty()) {
                for (Proceso proceso : colaListos) {
                    actual = proceso;
                    if (proceso.getEstado() == Estado.Listo) {
                        proceso.setEstado(Estado.Procesando);
                        notifyObserver();
                        try {
                            if (proceso.getRemainingBurstTime() > quantum) {
                                Thread.sleep(1000 * quantum);
                                proceso.setRemainingBurstTime(proceso.getRemainingBurstTime() - quantum);
                                System.out.println(proceso.toString());
                                proceso.setEstado(Estado.Listo);
                                notifyObserver();
                            } else {
                                Thread.sleep(1000 * proceso.getRemainingBurstTime());
                                proceso.setRemainingBurstTime(0);
                                System.out.println(proceso.toString());
                                proceso.setEstado(Estado.Terminado);
                                notifyObserver();
                                colaTerminados.add(proceso);
                                System.out.println("Termino proceso: " + proceso.getNombre());
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }
                colaListos.removeAll(colaTerminados);
            }
            procesando = false;

        }
        System.out.println("Termino");

    }
    
    public void addObserver(FrmSimulacion o){
        this.observers.add(o);
    }
    
    public void removeObserver(FrmSimulacion o){
        this.observers.remove(o);
    }
    
    private void notifyObserver(){
        for (FrmSimulacion obs : observers) {
            obs.update();
        }
    }
    
    public void cargarProcesosCPU(Vector<Proceso> procesos) {
        for (Proceso proceso : procesos) {
            colaListos.add(proceso);
        }
    }

    public void agregarProceso(Proceso p) {
        this.colaListos.add(p);
    }

    public Vector<Proceso> getColaListos() {
        return colaListos;
    }

    public void setColaListos(Vector<Proceso> colaListos) {
        this.colaListos = colaListos;
    }

    public Vector<Proceso> getColaBloqueados() {
        return colaBloqueados;
    }

    public void setColaBloqueados(Vector<Proceso> colaBloqueados) {
        this.colaBloqueados = colaBloqueados;
    }

    public Vector<Proceso> getColaTerminados() {
        return colaTerminados;
    }

    public void setColaTerminados(Vector<Proceso> colaTerminados) {
        this.colaTerminados = colaTerminados;
    }
    
    

    public void imprimirAllProcesos() {
        for (Proceso procesos : colaListos) {
            System.out.println(procesos.toString());
        }
    }

}
