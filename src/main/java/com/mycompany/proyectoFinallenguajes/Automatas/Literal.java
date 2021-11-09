/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.Automatas;


import static com.mycompany.proyectoFinallenguajes.Controladores.MovilizadorDatos.movilizar;
import static com.mycompany.proyectoFinallenguajes.frames.Inicio.cargarError;
import static com.mycompany.proyectoFinallenguajes.frames.Inicio.cargarToken;
import static com.mycompany.proyectoFinallenguajes.frames.RecuperacionErrores.recuperacionErrores;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Mariano
 */
public class Literal {
    //creamos matriz, 0 ", 1 es letra,2 es digito, 3 =, 4 es (, 5 es ), 6 es +, 7 es *, 8 es /, 9 es <, 10 es >, 11 es ', 12 es :, 13 es,, 14 es ;, 15 es-, 16 es_, 17 es espacio
    //estado 0 es 0, estado 1 es 1, estado 2 es error
    static int matriz[][]=new int [2][18];
    String valorTotal="";
    {
        matriz[0][0]=1;
        matriz[0][1]=2;
        matriz[0][2]=2;
        matriz[0][3]=2;
        matriz[0][4]=2;
        matriz[0][5]=2;
        matriz[0][6]=2;
        matriz[0][7]=2;
        matriz[0][8]=2;
        matriz[0][9]=2;
        matriz[0][10]=2;
        matriz[0][11]=2;
        matriz[0][12]=2;
        matriz[0][13]=2;
        matriz[0][14]=2;
        matriz[0][15]=2;
        matriz[0][16]=2;
        matriz[0][17]=2;
        matriz[1][0]=1;
        matriz[1][1]=1;
        matriz[1][2]=1;
        matriz[1][3]=1;
        matriz[1][4]=1;
        matriz[1][5]=1;
        matriz[1][6]=1;
        matriz[1][7]=1;
        matriz[1][8]=1;
        matriz[1][9]=1;
        matriz[1][10]=1;
        matriz[1][11]=1;
        matriz[1][12]=1;
        matriz[1][13]=1;
        matriz[1][14]=1;
        matriz[1][15]=1;
        matriz[1][16]=1;
        matriz[1][17]=1;
    }
    //inicializamos variables
    boolean lectura=true;
    int caracter=0, iterador = 0,estadoPresente=0, estadoIr=0,resultado=0,enviarReporte=0;//enteros
    char [] caract;//caracter
    
    public static void literalInicio(String linea,JTextArea movimiento){
        //incializamos  y creamos valores
        Literal literal = new Literal();
        literal.inicializacion(linea,movimiento);
        
    }
    public int conseguirSiguiente(int estadoPasable,int caracter){
        resultado=18;
        //verificamos caracter menor igual a 1
        if(caracter>=0&&caracter<=17){
            resultado = matriz[estadoPasable][caracter];
        }   
        return resultado;
    }
    public int comprobarExistencia(char caracter,String linea){
        resultado=18;
        String comprobar=Character.toString(caracter);
        //verificamos si existe en nuestro abecedario los datos y asignamos valor
        if(comprobar.equals("\"")){
            if(iterador>0){
                //si tenemos "
                lectura=false;
                resultado=0;
            }else{
                //si tenemos "              
                if(linea.length()>1){
                    resultado=0;
                }else{
                    resultado=18;
                }
            }
        }
        else if(Character.isLetter(caracter)){
            resultado=1;
        }else if(Character.isDigit(caracter)){
            resultado=2;
        }else if(comprobar.equals("=")){
            resultado=3;
        }else if(comprobar.equals("(")){
            resultado=4;
        }else if(comprobar.equals(")")){
            resultado=5;
        }else if(comprobar.equals("+")){
            resultado=6;
        }else if(comprobar.equals("*")){
            resultado=7;
        }else if(comprobar.equals("/")){
            resultado=8;
        }else if(comprobar.equals("<")){
            resultado=9;
        }else if(comprobar.equals(">")){
            resultado=10;
        }else if(comprobar.equals("'")){
            resultado=11;
        }else if(comprobar.equals(":")){
            resultado=12;
        }else if(comprobar.equals(",")){
            resultado=13;
        }else if(comprobar.equals(";")){
            resultado=14;
        }else if(comprobar.equals("-")){
            resultado=15;
        }else if(comprobar.equals("_")){
            resultado=16;
        }else if(comprobar.equals(" ")){
            resultado=17;
        }
        
        return resultado;
    }
    public void inicializacion(String linea,JTextArea movimiento){
        //reseteamos variables
        movilizar.setHayEspacio(0);
        enviarReporte=0;
        valorTotal="";
        iterador=0;
        caract=linea.toCharArray();//formato matriz
        estadoPresente=0;
        while((lectura)&&iterador<linea.length()&&resultado!=18){
            //puede acceder únicamente si cumple con tener letras y estar en el abecedario
                //llamamos al estado donde se va y pasamos caracter en determinado valor y el estado donde nos encontramos
                estadoIr= conseguirSiguiente(estadoPresente,comprobarExistencia(caract[iterador],linea));
                //mensaje de movilidad
                movimiento.setText(movimiento.getText()+"Me movi de estado --> "+estadoPresente+" hacia --> "+estadoIr+" con caracter: "+caract[iterador]+"\n");
                estadoPresente=estadoIr;
        
        //estructuramos cadena usada
        valorTotal=valorTotal+Character.toString(caract[iterador]);

        if(resultado==18){
            //si obtenemos error notificamos y modificamos que acceda a tabla error
            movimiento.setText(movimiento.getText()+"------------Error------------ \n");
            enviarReporte=1;
        }
        iterador++;
        }
        resultado=18;
        if(valorTotal.substring(valorTotal.length()-1,valorTotal.length()).equals("\"")){
            resultado=0;
        }
        if(resultado==18){
            //si obtenemos error notificamos y modificamos que acceda a tabla error
            movimiento.setText(movimiento.getText()+"------------Error------------ \n");
            enviarReporte=1;
        }
        String comprobarPunto=Character.toString(caract[iterador-1]);
        if(comprobarPunto.equals(".")){
            enviarReporte=1;
        }
        movimiento.setText(movimiento.getText()+"------------ Al usar "+valorTotal+" ----------\n");
        //modificamos valores a enviar a tablas
        movilizar.setColumna(iterador);
        movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+iterador);
        movilizar.setCadenaUsada(valorTotal);
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
            //identificamos si es decimal o numero
            if (valorTotal.contains("-")) {
                    movilizar.setTokenProviniente("Numero Negativo");
            }else{
                    movilizar.setTokenProviniente("Numero");
            }  
            try {
                //cargamos reporte tabla lexema y token
                cargarToken.cargarToken();
                //verificamos si tenemos anteriormente un error entonces modificamos texto en area recuperacion
                if (movilizar.getCondicionalRecuperacion()==1) {
                    movilizar.setCondicionalRecuperacion(0);//reiniciamos condicional recuperacion
                    String cadenaUsada=movilizar.getCadenaError()+movilizar.getCadenaUsada();
                    //modificamos texto
                    if (valorTotal.contains("-")) {
                        recuperacionErrores.setText(recuperacionErrores.getText()+cadenaUsada+" <--- Error en "+movilizar.getCadenaError()+" pero detecta token Numero Negativo = "+movilizar.getCadenaUsada()+" \n");
                    }else{
                        recuperacionErrores.setText(recuperacionErrores.getText()+cadenaUsada+" <--- Error en "+movilizar.getCadenaError()+" pero detecta token Numero = "+movilizar.getCadenaUsada()+" \n");
                    }
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