/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes.CargadorObjetos;

import com.mycompany.proyecto1lenguajes.AlmacenadorReportes.*;
import static com.mycompany.proyecto1lenguajes.Controladores.MovilizadorDatos.movilizar;
import static com.mycompany.proyecto1lenguajes.frames.Inicio.tokenEstablecido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class CargarToken {
    public ArrayList<ReporteTokensObjeto> cargarToken() throws FileNotFoundException,IOException,ClassNotFoundException{
        //definimos los espacios que ocupara en nuestro error al ser creado ycreamos array para reporte token
        int procesoReduccionColumna=movilizar.getCaracteresUsados()-movilizar.getCadenaUsada().length();//indicamos operacion para establecer posicion de columna
        //convertimos valores a strings
        String nombreToken=movilizar.getTokenProviniente();
        String lexema=movilizar.getCadenaUsada();
        String fila=movilizar.getFila()+"";
        String columna=procesoReduccionColumna+"";
        //si la columna fuera 0 significa que es columna 1
        if (columna.equals("0")) {
            columna="1";
        }
        String espacio[]={nombreToken,lexema,fila,columna};
        ReporteTokensObjeto tokens = CrearToken.crearToken(espacio);//lenamos espacios en reporte token
        tokenEstablecido.add(tokens);//agreagamos un nuevo token
        return tokenEstablecido;
    }
}
