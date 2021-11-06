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
public class CrearToken {
    public static ReporteTokensObjeto crearToken(String[] espacio){
        //Creamos un retorno de tipo reporte token con parametros tipo arreglo
        ReporteTokensObjeto token=null;
        //creamos reporte token con datos y convertimos string a int        
        token= new ReporteTokensObjeto(espacio[0],espacio[1],Integer.parseInt(espacio[2]),Integer.parseInt(espacio[3]));
        return token;
    }
}
