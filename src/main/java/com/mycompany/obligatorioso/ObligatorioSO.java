/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorioso;

import com.mycompany.obligatorioso.Modelo.CPU;
import com.mycompany.obligatorioso.UI.FrmSimulacion;
import com.mycompany.obligatorioso.Modelo.ManejadorArchivosGenerico;
import com.mycompany.obligatorioso.Modelo.Proceso;
import java.util.Vector;

/**
 *
 * @author lukas
 */
public class ObligatorioSO {

    public static void main(String[] args) {
        FrmSimulacion frm = new FrmSimulacion();
        frm.setVisible(true);
        
//        CPU cpu = new CPU();
//        Vector<Proceso> procesosAgregar = new Vector<>();
//        
//        String[] procesos = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\com\\mycompany\\obligatorioso\\Modelo\\Procesos.txt");
//        for (String proceso : procesos) {
//            String[] datos = proceso.split(",");
//            Proceso p = new Proceso(datos[0],Integer.parseInt(datos[1]));
//            procesosAgregar.add(p);
//        }
//        
//        cpu.cargarProcesosCPU(procesosAgregar);
//        
//        cpu.imprimirAllProcesos();
//        cpu.procesar();
    }
}
