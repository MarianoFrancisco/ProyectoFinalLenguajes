/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes;

import com.mycompany.proyectoFinallenguajes.Controladores.DatosInstanciadores;
import com.mycompany.proyectoFinallenguajes.Controladores.MovilizadorDatos;
import com.mycompany.proyectoFinallenguajes.Controladores.SegundoMovilizadorDatos;
import com.mycompany.proyectoFinallenguajes.frames.BusquedaCadena;
import com.mycompany.proyectoFinallenguajes.frames.Inicio;
import com.mycompany.proyectoFinallenguajes.frames.RecuperacionErrores;



/**
 *
 * @author Mariano
 */
public class FinalLenguajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Clase principal y llamamos el frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //inicializamos estructuradores de datos
                MovilizadorDatos.crearMovilizador();//llamamos a movilizar datos
                SegundoMovilizadorDatos.crearSegundoMovilizador();
                DatosInstanciadores.crearDatosInstanciadores();//llamamos instanciadores
                BusquedaCadena.iniciarBusqueda();  //creamos frame de busqueda
                RecuperacionErrores.iniciarRecuperacion(); //creamos frame de recuperacion errores
                //iniciamos frame inicio
                new Inicio().setVisible(true);      
            }
        });
    }
    
}
