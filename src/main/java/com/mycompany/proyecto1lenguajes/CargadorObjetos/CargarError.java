/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes.CargadorObjetos;

import com.mycompany.proyecto1lenguajes.AlmacenadorReportes.*;
import static com.mycompany.proyecto1lenguajes.Controladores.MovilizadorDatos.movilizar;
import static com.mycompany.proyecto1lenguajes.frames.Inicio.errorEstablecido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class CargarError {
    public ArrayList<ReporteErrorObjeto> cargarReporte() throws FileNotFoundException,IOException,ClassNotFoundException{
        //definimos los espacios que ocupara en nuestro error al ser creado y estrucamos array list para reporte error
        String fila=movilizar.getFila()+"";
        String columna=movilizar.getCaracteresUsados()+"";
        String espacio[]={movilizar.getCadenaUsada(),fila,columna};
        ReporteErrorObjeto error = CrearError.crearError(espacio);//ingresamos espacios al reporte error
        errorEstablecido.add(error);//agreagamos un nuevo error
        return errorEstablecido;
    }
}
