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
public class RecuentoLexemas {
    //utilizamos un array list para lexemas
    public static void completarTabla(ArrayList<RecuentoLexemaObjeto> reporteLexema,JTable tabla) {
        //creamos una tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tabla.setModel(modeloTabla);//definimos tabla
        //añadimos columnas
        modeloTabla.addColumn("Lexema");
        modeloTabla.addColumn("Token");
        modeloTabla.addColumn("Cantidad");
        //llenamos filas
        for (RecuentoLexemaObjeto lexemas : reporteLexema) {
            modeloTabla.addRow(new Object[]{lexemas.getLexema(),lexemas.getToken(),lexemas.getCantidad()});
        }
    }
}
