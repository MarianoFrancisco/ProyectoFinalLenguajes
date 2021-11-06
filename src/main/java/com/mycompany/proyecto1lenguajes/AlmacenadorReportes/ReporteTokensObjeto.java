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
public class ReporteTokensObjeto {
    //Creamos variables
    String nombreToken, lexema;
    int fila,columna;
    //Realizamos constructor para reporte token
    public ReporteTokensObjeto(String nombreToken, String lexema, int fila, int columna) {
        this.nombreToken = nombreToken;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }
    //Creamos set y get para modificar y llamar datos
    public String getNombreToken() {
        return nombreToken;
    }

    public void setNombreToken(String nombreToken) {
        this.nombreToken = nombreToken;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
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
