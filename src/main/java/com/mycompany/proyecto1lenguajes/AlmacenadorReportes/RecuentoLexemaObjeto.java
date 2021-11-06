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
public class RecuentoLexemaObjeto {
    //Creamos variables
    String lexema,token;
    int cantidad;
    //Realizamos constructor para recuento lexema
    public RecuentoLexemaObjeto(String lexema, String token, int cantidad) {
        this.lexema = lexema;
        this.token = token;
        this.cantidad = cantidad;
    }
    //Creamos set y get para modificar y llamar datos
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
