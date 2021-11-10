/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.Controladores;

/**
 *
 * @author Mariano
 */
public class SegundoMovilizadorDatos {
    private int fEscritura,fRepetir,fCondicional,fExpresion,fAsignacion;
    private String literal, numero, identificador;
    public static SegundoMovilizadorDatos movilizarSegundo;
    public SegundoMovilizadorDatos(int fEscritura, int fRepetir, int fCondicional, int fExpresion, int fAsignacion, String literal, String numero, String identificador) {
        this.fEscritura = fEscritura;
        this.fRepetir = fRepetir;
        this.fCondicional = fCondicional;
        this.fExpresion = fExpresion;
        this.fAsignacion = fAsignacion;
        this.literal = literal;
        this.numero = numero;
        this.identificador = identificador;
    }

    public int getfEscritura() {
        return fEscritura;
    }

    public void setfEscritura(int fEscritura) {
        this.fEscritura = fEscritura;
    }

    public int getfRepetir() {
        return fRepetir;
    }

    public void setfRepetir(int fRepetir) {
        this.fRepetir = fRepetir;
    }

    public int getfCondicional() {
        return fCondicional;
    }

    public void setfCondicional(int fCondicional) {
        this.fCondicional = fCondicional;
    }

    public int getfExpresion() {
        return fExpresion;
    }

    public void setfExpresion(int fExpresion) {
        this.fExpresion = fExpresion;
    }

    public int getfAsignacion() {
        return fAsignacion;
    }

    public void setfAsignacion(int fAsignacion) {
        this.fAsignacion = fAsignacion;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public static void crearSegundoMovilizador(){
        movilizarSegundo=new SegundoMovilizadorDatos(0,0,0,0,0,"","","");
    }
}
