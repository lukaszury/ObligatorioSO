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
    private int tiempoProcesado;

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
            for (Proceso p : colaListos) {
                if (p.getEstado() == Estado.Listo) {
                    if (p.getBurstRestante() >= quantum) {
                        p.setEstado(Estado.Procesando);
                        if ((p.getTimepoProcesado() + quantum) >= p.getRealizaES()) {
                            p.setTimepoProcesado(0);
                            if (p.getRealizaES() - quantum > 0) {
                                tiempoProcesado = p.getRealizaES() - quantum;
                                p.setBurstRestante(p.getBurstRestante() - tiempoProcesado);
                            } else {
                                tiempoProcesado =  p.getRealizaES();
                                p.setBurstRestante(p.getBurstRestante() - tiempoProcesado);
                            }
                            p.setEstado(Estado.Bloqueado);
                            p.setPrimerbloqueo(true);
                            colaBloqueados.add(p);
                            logguear(p);
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
                        if ((p.getTimepoProcesado() + quantum) >= p.getRealizaES()) {
                            if (p.getRealizaES() - quantum > 0) {
                                tiempoProcesado = p.getRealizaES() - quantum;
                                p.setBurstRestante(tiempoProcesado);
                            } else {
                                tiempoProcesado =  p.getRealizaES();
                                p.setBurstRestante(tiempoProcesado);
                            }
                        }
                        p.setBurstRestante(0);
                        p.setEstado(Estado.Terminado);
                        logguear(p);
                        colaTerminados.add(p);
                    }
                }
//                for (Proceso pb : colaBloqueados) {
//                    pb.setTiempoRestantebloqueado(pb.getTiempoRestantebloqueado() - quantum);
//                    if (pb.getTiempoRestantebloqueado() <= 0) {
//                        if (!pb.isPrimerbloqueo()) {
//                            pb.setEstado(Estado.Listo);
//                            pb.setTiempoRestantebloqueado(pb.getDesbloqueadES());
//                            loogearDesbloqueo(pb);
//                            aux.add(pb);
//                        }
//                        pb.setPrimerbloqueo(false);
//                    }
//                }
                for (Proceso pb : colaListos) {
                    if (pb.getEstado() == Estado.Bloqueado) {
                        pb.setTiempoRestantebloqueado(pb.getTiempoRestantebloqueado() - tiempoProcesado);
                        if (pb.getTiempoRestantebloqueado() <= 0) {
                            if (!pb.isPrimerbloqueo()) {
                                pb.setEstado(Estado.Listo);
                                pb.setTiempoRestantebloqueado(pb.getDesbloqueadES());
                                loogearDesbloqueo(pb);
                                aux.add(pb);
                            }
                            pb.setPrimerbloqueo(false);
                        }
                    }
                    colaBloqueados.removeAll(aux);
                }

            }
            colaListos.removeAll(colaTerminados);
//            colaListos.addAll(aux);
            aux.clear();
//            colaListos.removeAll(colaBloqueados);
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
            pasos.append("Se comenzo a procesar " + p.getNombre() + " con un tiempo total de " + p.getBurst() + "\n");
        } else {
            pasos.append("Se termino de procesar " + p.getNombre() + " y se marco como " + p.getEstado() + " remain " + p.getBurstRestante() + "\n");
        }
    }

    private void loogearDesbloqueo(Proceso pb) {
        pasos.append("Se desbloqueo" + pb.getNombre() + "remain" + pb.getBurstRestante() +"\n");
    }

    private void loggearBloqueado(Proceso p) {
        pasos.append("Se bloqueo" + p.getNombre() + "\n");
    }
}
