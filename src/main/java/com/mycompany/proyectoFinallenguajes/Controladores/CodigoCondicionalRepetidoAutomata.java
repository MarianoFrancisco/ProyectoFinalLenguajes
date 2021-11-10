/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.Controladores;

import com.mycompany.proyectoFinallenguajes.Automatas.*;
import static com.mycompany.proyectoFinallenguajes.Controladores.DatosInstanciadores.instanciadores;
import static com.mycompany.proyectoFinallenguajes.Controladores.MovilizadorDatos.movilizar;
import com.mycompany.proyectoFinallenguajes.frames.Inicio;
import static com.mycompany.proyectoFinallenguajes.frames.Inicio.cargarError;
import static com.mycompany.proyectoFinallenguajes.frames.Inicio.cargarToken;
import java.io.FileNotFoundException;
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
        int it=0;
        verificadorLinea=reduccionLinea.charAt(0);
        //si contiene espacio avanzamos un caracter
        if (Character.isSpaceChar(verificadorLinea)) {
                verificadorLinea=reduccionLinea.charAt(1);   
                while(Character.isSpaceChar(verificadorLinea)){
                    it++;
                    verificadorLinea=reduccionLinea.charAt(it);
                }
        }
        //establecemos que modificamos el char a string para validar datos
        String comprobarPunto=Character.toString(verificadorLinea);
        //si es letra ingresa a automata identificador
        if(Character.isLetter(verificadorLinea)|comprobarPunto.equals("_")){
            Identificador.identificadorInicio(reduccionLinea);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }//Si es digito ingresamos a posibilidad de numero o digito
        else if((Character.isDigit(verificadorLinea)|(comprobarPunto.equals("-")&&linea.length()>1))){
            Numero.numeroInicio(reduccionLinea);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }else if(comprobarPunto.equals("/")){
            if( reduccionLinea.length()>1){
                verificadorLinea=linea.charAt(1);//obtenemos valor valor posicion 1 de linea
                        comprobarPunto=Character.toString(verificadorLinea);
                        if(comprobarPunto.equals("/")){
                            movilizar.setTokenProviniente("Comentario");
                            try {
                                movilizar.setCaracteresUsados(linea.length());
                                movilizar.setColumna(1);
                                movilizar.setCadenaUsada(linea);
                                try {
                                    cargarToken.cargarToken();
                                } catch (IOException ex) {
                                    Logger.getLogger(CodigoCondicionalRepetidoAutomata.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                            }
            }}else{
                movilizar.setCaracteresUsados(movilizar.getCaracteresUsados());
                movilizar.setColumna(1);
                movilizar.setCadenaUsada("/");
                movilizar.setCondiconalError(1);
                reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
            }
                          
                            
        }else if(comprobarPunto.equals("\"" )){
            Literal.literalInicio(reduccionLinea);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }
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
