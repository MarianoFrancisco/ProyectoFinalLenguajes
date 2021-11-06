/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes.Controladores;

/**
 *
 * @author Mariano
 */
public class DatosInstanciadores {
    //inicializamos variables
    String linea,reduccionLinea;
    char verificadorLinea;
    int caracteresUsados;
    public static DatosInstanciadores instanciadores;
    //creamos constructor para los datos que instanciarán a método de repitencia automata
    public DatosInstanciadores(String linea, String reduccionLinea, char verificadorLinea, int caracteresUsados) {
        this.linea = linea;
        this.reduccionLinea = reduccionLinea;
        this.verificadorLinea = verificadorLinea;
        this.caracteresUsados = caracteresUsados;
    }
    
    //creamos gets y sets para modificar y llamar datos
    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public char getVerificadorLinea() {
        return verificadorLinea;
    }

    public void setVerificadorLinea(char verificadorLinea) {
        this.verificadorLinea = verificadorLinea;
    }

    
    public String getReduccionLinea() {
        return reduccionLinea;
    }

    public void setReduccionLinea(String reduccionLinea) {
        this.reduccionLinea = reduccionLinea;
    }

    public int getCaracteresUsados() {
        return caracteresUsados;
    }

    public void setCaracteresUsados(int caracteresUsados) {
        this.caracteresUsados = caracteresUsados;
    }
    //estructuramos creador de un valor DaotosInstanciadores inicializandolo
    public static void crearDatosInstanciadores(){
         instanciadores= new DatosInstanciadores("","",' ',0);
    }
}
