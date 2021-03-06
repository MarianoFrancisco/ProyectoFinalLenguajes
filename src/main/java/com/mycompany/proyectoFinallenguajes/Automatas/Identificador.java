/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.Automatas;

import static com.mycompany.proyectoFinallenguajes.Controladores.MovilizadorDatos.movilizar;
import static com.mycompany.proyectoFinallenguajes.frames.Inicio.*;
import static com.mycompany.proyectoFinallenguajes.frames.RecuperacionErrores.recuperacionErrores;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Mariano
 */
public class Identificador {
    //creamos matriz, 0 es letra, 1 es digito, 2 es -, 3 es _
    //estado 0 es 0, estado 1 es 1, 2 es error
    static int matriz[][]=new int [2][4];
    String identificadorTotal="";
    {
        matriz[0][0]=1;
        matriz[0][1]=2;
        matriz[0][2]=2;
        matriz[0][3]=1;
        matriz[1][0]=1;
        matriz[1][1]=1;
        matriz[1][2]=1;
        matriz[1][3]=1;
    }
    //inicializamos variables
    boolean lectura=true;
    int caracter=0, iterador = 0,estadoPresente=0, estadoIr=0,resultado=0,enviarReporte=0;//enteros
    char [] caract;//caracter

    public static void identificadorInicio(String linea){
        //incializamos  y creamos valores
        Identificador id = new Identificador();
        id.inicializacion(linea);
        
    }
    public int conseguirSiguiente(int estadoPasable,int caracter){
        resultado=4;
        //verificamos caracter menor igual a 1
        if(caracter>=0&&caracter<=3){
            resultado = matriz[estadoPasable][caracter];
        }   
        return resultado;
    }
    public int comprobarExistencia(char caracter){
        resultado=4;
        String comprobar=Character.toString(caracter);
        if(Character.isLetter(caracter)){
                resultado=0;
            }else if(Character.isDigit(caracter)){
                resultado=1;
            }else if(comprobar.equals("-")){
                resultado=2;
            }else if(comprobar.equals("_")){
                resultado=3;
            }
        return resultado;
    }
    public void inicializacion(String linea){
        //reseteamos variables
        movilizar.setHayEspacio(0);
        enviarReporte=0;
        identificadorTotal="";
        iterador=0;
        caract=linea.toCharArray();//formato matriz
        estadoPresente=0;
        while((lectura)&&iterador<linea.length()&&resultado!=4){
            //puede acceder ??nicamente si cumple con tener letras y estar en el abecedario
            if(Character.isSpaceChar(caract[iterador])){
                //si tiene espacio finalizamos proceso
                if(iterador==0){
                }else{
                    lectura=false;
                    movilizar.setHayEspacio(1);
                }
            }else{
                //llamamos al estado donde se va y pasamos caracter en determinado valor y el estado donde nos encontramos
                estadoIr= conseguirSiguiente(estadoPresente,comprobarExistencia(caract[iterador]));
                //mensaje de movilidad
                
                estadoPresente=estadoIr;
        }
        if(resultado==4){
            enviarReporte=1;
        }  
        //estructuramos cadena usada
        identificadorTotal=identificadorTotal+Character.toString(caract[iterador]);
        
        iterador++;
        }
        
        //modificamos valores a enviar a tablas
        movilizar.setColumna(iterador);
        movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+iterador);
        movilizar.setCadenaUsada(identificadorTotal.replaceAll(" ", ""));
        if(enviarReporte==1){
            try {
                //cargamos reporte de error
                cargarError.cargarReporte();
                movilizar.setCondiconalError(1);
                //modificamos condicional error para detectar que cadenas agrupar y modificamos la cadena error
                movilizar.setCondicionalRecuperacion(1);
                movilizar.setCadenaError(movilizar.getCadenaError()+movilizar.getCadenaUsada());
            } catch (IOException ex) {
                Logger.getLogger(Identificador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Identificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            movilizar.setTokenProviniente("Identificador");
            try {
                //cargamos reporte tabla lexema y token
                cargarToken.cargarToken();
                //verificamos si tenemos anteriormente un error entonces modificamos texto en area recuperacion
                if (movilizar.getCondicionalRecuperacion()==1) {
                    movilizar.setCondicionalRecuperacion(0);//reiniciamos condicional recuperacion
                    String cadenaUsada=movilizar.getCadenaError()+movilizar.getCadenaUsada();
                    //modificamos texto
                    recuperacionErrores.setText(recuperacionErrores.getText()+cadenaUsada+" <--- Error en "+movilizar.getCadenaError()+" pero detecta token Identificador = "+movilizar.getCadenaUsada()+" \n");
                    movilizar.setCadenaError("");//reseteamos cadena error
                }else{
                    //no pasa nada 
                }
            } catch (IOException ex) {
                Logger.getLogger(Identificador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Identificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
