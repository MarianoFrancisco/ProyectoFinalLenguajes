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
public class CrearLexema {
    public static RecuentoLexemaObjeto crearLexema(String[] espacio){
        //Creamos un retorno de tipo recuento lexema con parametros tipo arreglo
        RecuentoLexemaObjeto lexema=null;
        //creamos reporte lexema con datos y convertimos string a int        
        lexema= new RecuentoLexemaObjeto(espacio[0],espacio[1],Integer.parseInt(espacio[2]));
        return lexema;
    }
}
