/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes.AlmacenadorReportes;

/**
 *
 * @author Mariano
 */
public class ReporteErrorObjeto {
    //Creamos variables
    private String cadenaError;
    private int fila,columna;
    //Realizamos constructor para reporte error
    public ReporteErrorObjeto(String cadenaError, int fila, int columna) {
        this.cadenaError = cadenaError;
        this.fila = fila;
        this.columna = columna;
    }
    //Creamos set y get para modificar y llamar datos
    public String getCadenaError() {
        return cadenaError;
    }

    public void setCadenaError(String cadenaError) {
        this.cadenaError = cadenaError;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
