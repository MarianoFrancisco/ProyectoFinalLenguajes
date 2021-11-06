/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1lenguajes.Archivos;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Mariano
 */
public class ExportarArchivo {
    public static void exportarArchivo(JTextArea CargaArchivo) {
        try {
            // creamos metodo con text area de parametro
            JFileChooser archivo = new JFileChooser(System.getProperty("C:"));//escogemos el archivo a ller
            archivo.showSaveDialog(null);
            if (archivo.getSelectedFile() != null) {
                //si seleccionamos el archivo escribimos en el text area y notificamos exito
                try (FileWriter guardado = new FileWriter(archivo.getSelectedFile())) {
                guardado.write(CargaArchivo.getText());
                JOptionPane.showMessageDialog(null, "El archivo fue guardado con éxito en la ruta establecida");
                }
        }
        } catch (IOException ex) {
        System.out.println("ex"+ex);
        }
        
    }
}
