/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes.RegistroTablas;

import com.mycompany.proyecto1lenguajes.AlmacenadorReportes.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariano
 */
public class ReporteErrores {
    //utilizamos un array list para errores
    public static void completarTabla(ArrayList<ReporteErrorObjeto> reporteError,JTable tabla) {
        //creamos una tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tabla.setModel(modeloTabla);//definimos tabla
        //añadimos columnas
        modeloTabla.addColumn("Cadena Error");
        modeloTabla.addColumn("Fila");
        modeloTabla.addColumn("Columna");
        //llenamos filas
        for (ReporteErrorObjeto error : reporteError) {
            modeloTabla.addRow(new Object[]{error.getCadenaError(),error.getFila(),error.getColumna()});
        }
    }
}
