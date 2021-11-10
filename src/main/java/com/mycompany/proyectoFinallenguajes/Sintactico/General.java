/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.Sintactico;

import static com.mycompany.proyectoFinallenguajes.Controladores.SegundoMovilizadorDatos.movilizarSegundo;
import static com.mycompany.proyectoFinallenguajes.frames.Inicio.Prcesado;
import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class General {
    public static void generadorPila(){
        EstructuraPila pila = new EstructuraPila();
        if(movilizarSegundo.getfEscritura()==1){
            if(movilizarSegundo.getIdentificador().length()>0){
                pila.push(movilizarSegundo.getIdentificador());
            }else if(movilizarSegundo.getNumero().length()>0){
                pila.push(movilizarSegundo.getNumero());
            }else if(movilizarSegundo.getLiteral().length()>0){
                pila.push(movilizarSegundo.getLiteral());
            }else{
                System.out.println("Error");
            }
            Prcesado.setText(Prcesado.getText()+pila.pop());
        }else if(movilizarSegundo.getfRepetir()==1){
            if(movilizarSegundo.getIdentificador().length()>0){
                pila.push(movilizarSegundo.getIdentificador());
            }else if(movilizarSegundo.getNumero().length()>0){
                pila.push(movilizarSegundo.getNumero());
            }else if(movilizarSegundo.getLiteral().length()>0){
                pila.push(movilizarSegundo.getLiteral());
            }else{
                System.out.println("Error");
            }
            Prcesado.setText(Prcesado.getText()+pila.pop());
        }else if(movilizarSegundo.getfExpresion()==1){
            
        }else if(movilizarSegundo.getfCondicional()==1){
            
        }else if(movilizarSegundo.getfAsignacion()==1){
            
        }else{
            System.out.println("error");
        }
    }
}
