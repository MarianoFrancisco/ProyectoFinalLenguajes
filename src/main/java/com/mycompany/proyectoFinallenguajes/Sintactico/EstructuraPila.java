/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.Sintactico;

import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class EstructuraPila {
    private ArrayList<Object> general = new ArrayList();
    public void push(Object objetoAgregado){//Agregar a la pila
        general.add(objetoAgregado);//agregamos valor de objeto a pila
    }
    public Object pop(){//mostrar último valor y eliminarlo
        if(!(general.isEmpty())){
            Object objetoAgregado = general.get(general.size()-1);
            general.remove(general.size()-1);//eliminamos
            return objetoAgregado;
        }else{
            return null;
        }
    }
    public Object peek(){//mostrar último valor
        if(!(general.isEmpty())){
            return general.get(general.size()-1);
        }else{
            return null;
        }
    }
    public Boolean empty(){//Si la pila está vacía o llena
        return general.isEmpty();
    }
}
