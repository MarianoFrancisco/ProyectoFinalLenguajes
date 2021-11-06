/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes;

import com.mycompany.proyecto1lenguajes.Controladores.DatosInstanciadores;
import com.mycompany.proyecto1lenguajes.Controladores.MovilizadorDatos;
import com.mycompany.proyecto1lenguajes.frames.BusquedaCadena;
import com.mycompany.proyecto1lenguajes.frames.Inicio;
import com.mycompany.proyecto1lenguajes.frames.RecuperacionErrores;



/**
 *
 * @author Mariano
 */
public class PracticaLenguajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Clase principal y llamamos el frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //inicializamos estructuradores de datos
                MovilizadorDatos.crearMovilizador();//llamamos a movilizar datos
                DatosInstanciadores.crearDatosInstanciadores();//llamamos instanciadores
                BusquedaCadena.iniciarBusqueda();  //creamos frame de busqueda
                RecuperacionErrores.iniciarRecuperacion(); //creamos frame de recuperacion errores
                //iniciamos frame inicio
                new Inicio().setVisible(true);      
            }
        });
    }
    
}
