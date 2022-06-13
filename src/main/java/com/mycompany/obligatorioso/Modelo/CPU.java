/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorioso.Modelo;

import java.util.Vector;

/**
 *
 * @author lukas
 */
public class CPU {

    private int quantum = 2;
    private Vector<Proceso> colaListos;
    private Vector<Proceso> colaBloqueados;
    private Proceso actual;
    private int indiceActual;
    private boolean procesando;

    public CPU() {
        colaListos = new Vector<>();
        colaBloqueados = new Vector<>();
        actual = null;
        indiceActual = 0;
        procesando = false;
    }

    public void procesar() {
        procesando = true;
        Vector<Proceso> procesosListos = new Vector<>();

        System.out.println("Procesando");

        while (procesando) {

            while (!colaListos.isEmpty()) {
                for (Proceso proceso : colaListos) {
                    actual = proceso;
                    try {
                        if (proceso.getRemainingBurstTime() > quantum) {
                            Thread.sleep(1000 * quantum);
                            proceso.setRemainingBurstTime(proceso.getRemainingBurstTime() - quantum);
                            System.out.println(proceso.toString());
                        } else {
                            Thread.sleep(1000 * proceso.getRemainingBurstTime());
                            proceso.setRemainingBurstTime(0);
                            System.out.println(proceso.toString());
                            procesosListos.add(proceso);
                            System.out.println("Termino proceso: " + proceso.getNombre());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                colaListos.removeAll(procesosListos);

            }
            procesando = false;

        }
        System.out.println("Termino");

    }

    public void cargarProcesosCPU(Vector<Proceso> procesos) {
        for (Proceso proceso : procesos) {
            colaListos.add(proceso);
        }
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

    public void imprimirAllProcesos() {
        for (Proceso procesos : colaListos) {
            System.out.println(procesos.toString());
        }
    }

}
