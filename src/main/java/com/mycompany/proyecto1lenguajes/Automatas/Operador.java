/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes.Automatas;

import static com.mycompany.proyecto1lenguajes.Controladores.MovilizadorDatos.movilizar;
import static com.mycompany.proyecto1lenguajes.frames.Inicio.cargarError;
import static com.mycompany.proyecto1lenguajes.frames.Inicio.cargarLexema;
import static com.mycompany.proyecto1lenguajes.frames.Inicio.cargarToken;
import static com.mycompany.proyecto1lenguajes.frames.RecuperacionErrores.recuperacionErrores;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Mariano
 */
public class Operador {
    //creamos matriz, 0 es +, 1 es -,2 es *, 3 es /, 4 es%
    //estado 0 es 0, estado 1 es 1, 5 es error
    static int matriz[][]=new int [2][5];
    String operadorTotal="";
    {
        matriz[0][0]=1;
        matriz[0][1]=1;
        matriz[0][2]=1;
        matriz[0][3]=1;
        matriz[0][4]=1;
        matriz[1][0]=1;
        matriz[1][1]=1;
        matriz[1][2]=1;
        matriz[1][3]=1;
        matriz[1][4]=1;
    }
    //inicializamos variables
    boolean lectura=true;
    int caracter=0, iterador = 0,estadoPresente=0, estadoIr=0,resultado=0,enviarReporte=0;//enteros
    char [] caract;//caracter

    public static void operadorInicio(String linea,JTextArea movimiento){
        //incializamos  y creamos valores
        Operador operador = new Operador();
        operador.inicializacion(linea,movimiento);
        
    }
    public int conseguirSiguiente(int estadoPasable,int caracter){
        resultado=5;
        //verificamos caracter menor igual a 4
        if(caracter>=0&&caracter<=4){
            resultado = matriz[estadoPasable][caracter];
        }   
        return resultado;
    }
    public int comprobarExistencia(char caracter){
        resultado=5;
        String comprobarPunto=Character.toString(caracter);
        //verificamos si existe en nuestro abecedario los datos y asignamos valor
        if(comprobarPunto.equals("+")){
                resultado=0;
        }else if(comprobarPunto.equals("-")){
                resultado=1;
        }else if(comprobarPunto.equals("*")){
                resultado=2;
        }else if(comprobarPunto.equals("/")){
                resultado=3;
        }else if(comprobarPunto.equals("%")){
                resultado=4;
        }
        return resultado;
    }
    public void inicializacion(String linea,JTextArea movimiento){
        //reseteamos variables
        movilizar.setHayEspacio(0);
        enviarReporte=0;
        operadorTotal="";
        iterador=0;
        caract=linea.toCharArray();//formato matriz
        estadoPresente=0;
        while((lectura)&&iterador<linea.length()&&resultado!=5){
            //puede acceder únicamente si cumple con tener letras y estar en el abecedario
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
                movimiento.setText(movimiento.getText()+"Me movi de estado --> "+estadoPresente+" hacia --> "+estadoIr+" con caracter: "+caract[iterador]+"\n");
                estadoPresente=estadoIr;
        }
        if(resultado==5){
            //si obtenemos error notificamos y modificamos que acceda a tabla error
            movimiento.setText(movimiento.getText()+"------------Error------------ \n");
            enviarReporte=1;
        }  
        //estructuramos cadena usada
        operadorTotal=operadorTotal+Character.toString(caract[iterador]);
        
        iterador++;
        }
        movimiento.setText(movimiento.getText()+"------------ Al usar "+operadorTotal+" ----------\n");
        //modificamos valores a enviar a tablas
        movilizar.setColumna(iterador);
        movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+iterador);
        movilizar.setCadenaUsada(operadorTotal.replaceAll(" ", ""));
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
            movilizar.setTokenProviniente("Operador");
            try {
                //cargamos reporte tabla lexema y token
                cargarLexema.cargarLexema();
                cargarToken.cargarToken();
                //verificamos si tenemos anteriormente un error entonces modificamos texto en area recuperacion
                if (movilizar.getCondicionalRecuperacion()==1) {
                    movilizar.setCondicionalRecuperacion(0);//reiniciamos condicional recuperacion
                    String cadenaUsada=movilizar.getCadenaError()+movilizar.getCadenaUsada();
                    //modificamos texto
                    recuperacionErrores.setText(recuperacionErrores.getText()+cadenaUsada+" <--- Error en "+movilizar.getCadenaError()+" pero detecta token Operador = "+movilizar.getCadenaUsada()+" \n");
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
