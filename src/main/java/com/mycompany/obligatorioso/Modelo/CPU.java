/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorioso.Modelo;

import com.mycompany.obligatorioso.UI.FrmSimulacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author lukas
 */
public class CPU {

    private int quantum;
    private ArrayList<Proceso> colaListos;
    private ArrayList<Proceso> colaBloqueados;
    private ArrayList<Proceso> colaTerminados;
    private Proceso procesoEnCPU;
    private StringBuilder pasos;

    public CPU() {
        colaListos = new ArrayList<>();
        colaBloqueados = new ArrayList<>();
        colaTerminados = new ArrayList<>();
        quantum = 2;
        pasos = new StringBuilder();
    }

    public void procesar() {
        ArrayList<Proceso> aux = new ArrayList<>();
        pasos.append("Se comenzo a procesar procesos\n");
        while (!colaListos.isEmpty() || !colaBloqueados.isEmpty()) {
            Collections.sort(colaBloqueados);
            for (Proceso pb : colaBloqueados) {
                pb.setDesbloqueadES(pb.getDesbloqueadES() - quantum);
                if (pb.getDesbloqueadES() <= 0) {
                    pb.setEstado(Estado.Listo);
                    pb.setTiempoRestantebloqueado(pb.getRealizaES());
                    loogearDesbloqueo(pb);
                    colaListos.add(pb);
                    aux.add(pb);
                }
            }
            colaBloqueados.removeAll(aux);
            for (Proceso p : colaListos) {
                if (p.getEstado() == Estado.Listo) {
                    if (p.getBurstRestante() > quantum) {
                        p.setEstado(Estado.Procesando);
                        if ((p.getTimepoProcesado() + quantum) > p.getRealizaES()) {
                            p.setTimepoProcesado(0);
                            p.setBurstRestante(p.getBurstRestante() - (p.getRealizaES() - quantum));
                            p.setEstado(Estado.Bloqueado);
                            colaBloqueados.add(p);
                            loggearBloqueado(p);

                        } else {
                            p.setTimepoProcesado(p.getTimepoProcesado() + quantum);
                            logguear(p);
                            p.setBurstRestante(p.getBurstRestante() - quantum);
                            p.setEstado(Estado.Listo);
                            logguear(p);
                        }
                    } else {
                        p.setEstado(Estado.Procesando);
                        logguear(p);
                        p.setBurstRestante(0);
                        p.setEstado(Estado.Terminado);
                        logguear(p);
                        colaTerminados.add(p);
                    }
                }
            }
            colaListos.removeAll(colaTerminados);
            colaListos.removeAll(colaBloqueados);
        }
        pasos.append("Finalizo el procesado\n");
    }

    public void agregarProcesoAListo(Proceso p) {
        this.colaListos.add(p);
    }

    public ArrayList<Proceso> getColaListos() {
        return colaListos;
    }

    public void setColaListos(ArrayList<Proceso> colaListos) {
        this.colaListos = colaListos;
    }

    public ArrayList<Proceso> getColaBloqueados() {
        return colaBloqueados;
    }

    public void setColaBloqueados(ArrayList<Proceso> colaBloqueados) {
        this.colaBloqueados = colaBloqueados;
    }

    public ArrayList<Proceso> getColaTerminados() {
        return colaTerminados;
    }

    public void setColaTerminados(ArrayList<Proceso> colaTerminados) {
        this.colaTerminados = colaTerminados;
    }

    public Proceso getProcesoEnCPU() {
        return procesoEnCPU;
    }

    public void setProcesoEnCPU(Proceso procesoEnCPU) {
        this.procesoEnCPU = procesoEnCPU;
    }

    public String getPasos() {
        return pasos.toString();
    }

    public void setPasos(StringBuilder pasos) {
        this.pasos = pasos;
    }

    private void logguear(Proceso p) {
        if (p.getEstado() == Estado.Procesando) {
            pasos.append("Se comenzo a procesar " + p.getNombre() + " con un tiempo total de " + p.getBurst() + " tiempo restante " + p.getBurstRestante() + "\n");
        } else {
            pasos.append("Se termino de procesar " + p.getNombre() + " y se marco como " + p.getEstado() + "\n");
        }
    }

    private void loogearDesbloqueo(Proceso pb) {
        pasos.append("Se desbloqueo" + pb.getNombre()+ "\n");
    }

    private void loggearBloqueado(Proceso p) {
        pasos.append("Se bloqueo" + p.getNombre()+ "\n");
    }
}
