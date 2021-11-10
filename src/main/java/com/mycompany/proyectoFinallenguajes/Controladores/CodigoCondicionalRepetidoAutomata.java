/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.Controladores;

import static com.mycompany.proyectoFinallenguajes.Controladores.DatosInstanciadores.instanciadores;
import static com.mycompany.proyectoFinallenguajes.Controladores.MovilizadorDatos.movilizar;
import static com.mycompany.proyectoFinallenguajes.frames.Inicio.cargarError;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariano
 */
public class CodigoCondicionalRepetidoAutomata {
    public static void codigoAutomataRepitencia(String linea, char verificadorLinea,String reduccionLinea,int caracteresUsados){
        //creamos metodo para reutilizacion de codigo para identificador automatas, reduccion linea es para acortar nuestro dato
        verificadorLinea=reduccionLinea.charAt(0);
        //si contiene espacio avanzamos un caracter
        if (Character.isSpaceChar(verificadorLinea)) {
            if (movilizar.getHayEspacio()==1) {  //si anteriormente era espacio no tienen que haber dos espacios
                verificadorLinea=reduccionLinea.charAt(0);
            }else{
                verificadorLinea=reduccionLinea.charAt(1);
            }       
        }
        //establecemos que modificamos el char a string para validar datos
        String comprobarPunto=Character.toString(verificadorLinea);
        //si es letra ingresa a automata identificador
        if(Character.isLetter(verificadorLinea)){
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }//Si es digito ingresamos a posibilidad de numero o digito
        else if(Character.isDigit(verificadorLinea)){
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }//Si es +-*/ entre signos parecidos significa que entra a operacion
        else{
            try {
                //estructuramos que si haya error y modificamos datos
                movilizar.setCadenaUsada(Character.toString(verificadorLinea));
                movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+1);
                cargarError.cargarReporte();
                movilizar.setCondiconalError(1);
                //señalizaos error
                
                reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
            } catch (IOException ex) {
                Logger.getLogger(CodigoCondicionalRepetidoAutomata.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CodigoCondicionalRepetidoAutomata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //modificamos valores iniciales al recargar este método
        instanciadores.setLinea(linea);
        instanciadores.setReduccionLinea(reduccionLinea);
        instanciadores.setVerificadorLinea(verificadorLinea);
    }
}
