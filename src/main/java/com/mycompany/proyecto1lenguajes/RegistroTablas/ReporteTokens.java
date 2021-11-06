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
public class ReporteTokens {
    //utilizamos un array list para tokens
    public static void completarTabla(ArrayList<ReporteTokensObjeto> reporteToken,JTable tabla) {
        //creamos una tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tabla.setModel(modeloTabla);//definimos tabla
        //añadimos columnas
        modeloTabla.addColumn("Nombre Token");
        modeloTabla.addColumn("Lexema");
        modeloTabla.addColumn("Fila");
        modeloTabla.addColumn("Columna");
        //llenamos filas
        for (ReporteTokensObjeto token : reporteToken) {
            modeloTabla.addRow(new Object[]{token.getNombreToken(),token.getLexema(),token.getFila(),token.getColumna()});
        }
    }
}
