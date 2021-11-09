/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoFinallenguajes.frames;

import com.mycompany.proyectoFinallenguajes.AlmacenadorReportes.ReporteErrorObjeto;
import com.mycompany.proyectoFinallenguajes.AlmacenadorReportes.ReporteTokensObjeto;
import com.mycompany.proyectoFinallenguajes.CargadorObjetos.CargarError;
import com.mycompany.proyectoFinallenguajes.CargadorObjetos.CargarToken;
import com.mycompany.proyectoFinallenguajes.RegistroTablas.ReporteTokens;
import com.mycompany.proyectoFinallenguajes.Automatas.Identificador;
import static com.mycompany.proyectoFinallenguajes.Controladores.MovilizadorDatos.movilizar;
import com.mycompany.proyectoFinallenguajes.Archivos.CargaArchivo;
import com.mycompany.proyectoFinallenguajes.Archivos.ExportarArchivo;
import com.mycompany.proyectoFinallenguajes.Archivos.ReescribirArchivo;
import com.mycompany.proyectoFinallenguajes.Automatas.Literal;
import com.mycompany.proyectoFinallenguajes.Automatas.Numero;
import com.mycompany.proyectoFinallenguajes.Controladores.CodigoCondicionalRepetidoAutomata;
import static com.mycompany.proyectoFinallenguajes.Controladores.DatosInstanciadores.instanciadores;
import com.mycompany.proyectoFinallenguajes.RegistroTablas.ReporteErrores;
import static com.mycompany.proyectoFinallenguajes.frames.BusquedaCadena.resultadoBusqueda;
import static com.mycompany.proyectoFinallenguajes.frames.RecuperacionErrores.recuperacionErrores;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Mariano
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public static CargarError cargarError;//creamos carga error
    public static CargarToken cargarToken;//creamos carga token
    public static ArrayList<ReporteErrorObjeto> errorEstablecido;//indicamos un array list de error para leer los archivos
    public static ArrayList<ReporteTokensObjeto> tokenEstablecido;//indicamos un array list de token para leer los archivos
    protected UndoManager manager = new UndoManager();
    public Inicio() {
        initComponents();//iniciar componentes
        crearReportes();//llamado metodo crear reportes
        CargaArchivo.getDocument().addUndoableEditListener(manager);
        this.setLocationRelativeTo(null);//Centramos nuestro frame
    }
    //Creamos metodo para crear cargas
    public void crearReportes(){
        this.cargarError = new CargarError();  
        this.cargarToken = new CargarToken();
        
    }
    public void abrirArchivo(){
        //filechooser para abrir o guardar archivos
        JFileChooser archivoEleccion = new JFileChooser();
        int eleccion = archivoEleccion.showOpenDialog(this);//variable para seleccionar
        //aprove option es si el usuario le da en aceptar
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = archivoEleccion.getSelectedFile();//seleccionamos file para fileReader, agarramos el seleccionado
            movilizar.setDirectorio(archivo.getPath());
            try {
                //llamos la clase carga archivo e ingresamos parametros
                CargaArchivo.setText("");
                CargaArchivo carga = new CargaArchivo();
                carga.leer(archivo, CargaArchivo);
                CargaArchivo.setText(CargaArchivo.getText().substring(0,CargaArchivo.getText().length()-1));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer carga de archivo");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        analizarTexto = new javax.swing.JButton();
        buscarText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        MovimientoEstado = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReportToken = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        ReporteError = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buscarCadena1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CargaArchivo = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrirArchivo = new javax.swing.JMenuItem();
        nuevoArchivo = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        guardar = new javax.swing.JMenuItem();
        guardarComo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        copiar = new javax.swing.JMenuItem();
        pegar = new javax.swing.JMenuItem();
        deshacer = new javax.swing.JMenuItem();
        rehacer = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        acercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador USAC");

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Reportes de tokens");

        analizarTexto.setBackground(new java.awt.Color(0, 102, 255));
        analizarTexto.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        analizarTexto.setForeground(new java.awt.Color(0, 0, 0));
        analizarTexto.setText("ANALIZAR TEXTO");
        analizarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarTextoActionPerformed(evt);
            }
        });

        MovimientoEstado.setColumns(20);
        MovimientoEstado.setRows(5);
        jScrollPane2.setViewportView(MovimientoEstado);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mariano");

        ReportToken.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre Token", "Lexema", "Fila", "Columna"
            }
        ));
        jScrollPane3.setViewportView(ReportToken);

        ReporteError.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cadena error", "Fila", "Columna"
            }
        ));
        jScrollPane6.setViewportView(ReporteError);

        jLabel5.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Texto Cargado");

        jLabel6.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Movimiento de estado");

        jLabel7.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Reporte de errores");

        jLabel8.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Busqueda");

        buscarCadena1.setBackground(new java.awt.Color(0, 102, 255));
        buscarCadena1.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        buscarCadena1.setForeground(new java.awt.Color(0, 0, 0));
        buscarCadena1.setText("ver rrecuperación de errores");
        buscarCadena1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCadena1ActionPerformed(evt);
            }
        });

        CargaArchivo.setColumns(20);
        CargaArchivo.setRows(5);
        jScrollPane1.setViewportView(CargaArchivo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(analizarTexto)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel8)
                                .addGap(31, 31, 31)
                                .addComponent(buscarText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel7)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(buscarCadena1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscarText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(analizarTexto)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarCadena1)
                            .addComponent(jLabel3)))))
        );

        jMenu1.setText("Abrir");

        abrirArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        abrirArchivo.setText("Abrir Archivo");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(abrirArchivo);

        nuevoArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        nuevoArchivo.setText("Nuevo Archivo");
        nuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoArchivo);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Guardar");

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu3.add(guardar);

        guardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        guardarComo.setText("Guardar Como");
        guardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoActionPerformed(evt);
            }
        });
        jMenu3.add(guardarComo);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Herramientas");

        copiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copiar.setText("Copiar");
        copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarActionPerformed(evt);
            }
        });
        jMenu2.add(copiar);

        pegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pegar.setText("Pegar");
        pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarActionPerformed(evt);
            }
        });
        jMenu2.add(pegar);

        deshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        deshacer.setText("Deshacer");
        deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerActionPerformed(evt);
            }
        });
        jMenu2.add(deshacer);

        rehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        rehacer.setText("Rehacer");
        rehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rehacerActionPerformed(evt);
            }
        });
        jMenu2.add(rehacer);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Buscar Cadena");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Información");

        acercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        acercaDe.setText("Acerca de Analizador USAC");
        acercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeActionPerformed(evt);
            }
        });
        jMenu5.add(acercaDe);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarTextoActionPerformed
        inicializadorValores();//método inicializador de valores
        //creamos variables
        String linea,reduccionLinea;
        String texto=CargaArchivo.getText();
        char valorCero='0';
        int contador=0;
        int verificadorEspacio=0,eliminadorWhile=1;
        char verificadorLinea;
        String comprobarVerificador;
        char guionMedio = '-';
        //convertimos el texto para lectura
        Reader leer = new StringReader(texto);
        BufferedReader leerTA = new BufferedReader(leer);
        try {
            //mientras existe linea leerá
            while ((linea = leerTA.readLine()) != null) {
                //reseteamos componentes de datos
                contador++;
                verificadorEspacio=0;
                eliminadorWhile=1;
                movilizar.setFila(contador);
                movilizar.setColumna(0);
                movilizar.setCaracteresUsados(0);
                movilizar.setCadenaUsada("");
                verificadorLinea=linea.charAt(0);//obtenemos valor valor posicion 0 de linea
                String comprobarPunto=Character.toString(verificadorLinea);//pasamos char a string 
                //si es letra ingresa a automata identificador 
                comprobarVerificador=Character.toString(verificadorLinea);
                if(Character.isLetter(verificadorLinea)|comprobarVerificador.equals("_")){
                        Identificador.identificadorInicio(linea,MovimientoEstado);
                        reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
                        pasadorDatos(linea,reduccionLinea,verificadorLinea);//sirve para enviar datos a instanciador de repitencia
                        while(movilizar.getCaracteresUsados()<linea.length()){//repetimos instancia de automatas
                            CodigoCondicionalRepetidoAutomata.codigoAutomataRepitencia(instanciadores.getLinea(), instanciadores.getVerificadorLinea(), instanciadores.getReduccionLinea(), movilizar.getCaracteresUsados(), MovimientoEstado);
                        }
                }//Si es digito ingresamos a posibilidad de numero positivo o negativo
                else if((Character.isDigit(verificadorLinea)|(guionMedio==verificadorLinea&&linea.length()>1))){
                            Numero.numeroDecimalInicio(linea,MovimientoEstado);
                            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
                            pasadorDatos(linea,reduccionLinea,verificadorLinea);//sirve para enviar datos a instanciador de repitencia
                            while(movilizar.getCaracteresUsados()<linea.length()){//repetimos instancia de automatas
                                CodigoCondicionalRepetidoAutomata.codigoAutomataRepitencia(instanciadores.getLinea(), instanciadores.getVerificadorLinea(), instanciadores.getReduccionLinea(), movilizar.getCaracteresUsados(), MovimientoEstado);
                            }
                    
                }else if(comprobarVerificador.equals("/")){
                    if(linea.length()>1){
                        verificadorLinea=linea.charAt(1);//obtenemos valor valor posicion 1 de linea
                        comprobarVerificador=Character.toString(verificadorLinea);
                        if(comprobarVerificador.equals("/")){
                            movilizar.setTokenProviniente("Comentario");
                            try {
                                movilizar.setCaracteresUsados(linea.length());
                                movilizar.setColumna(1);
                                movilizar.setCadenaUsada(linea);
                                cargarToken.cargarToken();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                }else if(comprobarVerificador.equals("\""  )){
                    Literal.literalInicio(linea,MovimientoEstado);
                    reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
                    pasadorDatos(linea,reduccionLinea,verificadorLinea);//sirve para enviar datos a instanciador de repitencia
                    while(movilizar.getCaracteresUsados()<linea.length()){//repetimos instancia de automatas
                        CodigoCondicionalRepetidoAutomata.codigoAutomataRepitencia(instanciadores.getLinea(), instanciadores.getVerificadorLinea(), instanciadores.getReduccionLinea(), movilizar.getCaracteresUsados(), MovimientoEstado);
                    }
                }
                //Si es +-*/ entre signos parecidos significa que entra a operacion
                else{
                    try {
                        //cargamos reporte de error
                        movilizar.setCadenaUsada(Character.toString(verificadorLinea));
                        movilizar.setCaracteresUsados(1);
                        cargarError.cargarReporte();
                        movilizar.setCondiconalError(1);
                        reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
                        pasadorDatos(linea,reduccionLinea,verificadorLinea);//sirve para enviar datos a instanciador de repitencia
                        //señalizaos error
                        MovimientoEstado.setText(MovimientoEstado.getText()+"------------Error------------ al usar "+movilizar.getCadenaUsada()+"\n");
                        while(movilizar.getCaracteresUsados()<linea.length()){//repetimos instancia de automatas
                            CodigoCondicionalRepetidoAutomata.codigoAutomataRepitencia(instanciadores.getLinea(), instanciadores.getVerificadorLinea(), instanciadores.getReduccionLinea(), movilizar.getCaracteresUsados(), MovimientoEstado);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }             
            }
            if(movilizar.getCondiconalError()==1){
                //si hay error solo carga esta tabla
                ReporteErrores.completarTabla(errorEstablecido, ReporteError);
            }else if(movilizar.getCondiconalError()==0){
                //si no hay errores cargamos las tablas correctas
                ReporteTokens.completarTabla(tokenEstablecido, ReportToken);
            }
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_analizarTextoActionPerformed
    private void inicializadorValores(){
        //creamos array list para reportes
        errorEstablecido = new ArrayList<>();     
        tokenEstablecido = new ArrayList<>(); 
        //llamamos a que se complete la tabla 
        ReporteErrores.completarTabla(errorEstablecido, ReporteError);
        ReporteTokens.completarTabla(tokenEstablecido, ReportToken);
        //reiniciamos valores
        movilizar.setCondiconalError(0);
        MovimientoEstado.setText("");
        movilizar.setCaracteresUsados(0);
        movilizar.setCadenaUsada("");
        movilizar.setFila(0);
        movilizar.setColumna(0);
        recuperacionErrores.setText("");
        movilizar.setCadenaError("");
    }
    public void pasadorDatos(String linea, String reduccionLinea, char verificadorLinea){
        //llamamos a instanciadores para que se modifiquen según sea el caso solo pasando parametros
        instanciadores.setLinea(linea);
        instanciadores.setReduccionLinea(reduccionLinea);
        instanciadores.setVerificadorLinea(verificadorLinea);
    }
    private void buscarCadena1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCadena1ActionPerformed
        if (movilizar.getCondiconalError()==1) {
            RecuperacionErrores.visible(); //hacemos visible frame recuperacion errores
        }else{
            JOptionPane.showMessageDialog(null, "No hay errores en el último análisis");//identificamos que no surgieron errores
        }
    }//GEN-LAST:event_buscarCadena1ActionPerformed

    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        if(movilizar.getDirectorio().length()==0&&CargaArchivo.getText().length()>0){
            JOptionPane.showMessageDialog(null, "Tienes un archivo sin guardar, si cargas uno se perderá");
            abrirArchivo();
        }else if(movilizar.getDirectorio().length()>0){
            FileReader leerA = null;
            try {
                leerA = new FileReader(movilizar.getDirectorio()); //ingresamos archivo
                BufferedReader leerTA = new BufferedReader(leerA);//lector del archivo}
                String archivoLeido= leerTA.lines().collect(Collectors.joining());//leer string
                if(archivoLeido.equals(CargaArchivo.getText())){
                    abrirArchivo();
                }else{
                    JOptionPane.showMessageDialog(null, "Tienes un archivo sin guardar, si cargas uno se perderá");
                    abrirArchivo();
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    leerA.close();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            abrirArchivo();
        }
        
    }//GEN-LAST:event_abrirArchivoActionPerformed

    private void nuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArchivoActionPerformed
        if(movilizar.getDirectorio().length()==0&&CargaArchivo.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ya está en un nuevo archivo");
        }else if(movilizar.getDirectorio().length()==0&&CargaArchivo.getText().length()>0){
            java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new VerificarCambios().setVisible(true);
                        }
                    });
        }
            else{
            FileReader leerA = null;
            try {
                leerA = new FileReader(movilizar.getDirectorio()); //ingresamos archivo
                BufferedReader leerTA = new BufferedReader(leerA);//lector del archivo}
                String archivoLeido= leerTA.lines().collect(Collectors.joining());//leer string
                if(archivoLeido.equals(CargaArchivo.getText())){
                    
                    CargaArchivo.setText("");
                    movilizar.setDirectorio("");
                }else{
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new VerificarCambios().setVisible(true);
                        }
                    });
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    leerA.close();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_nuevoArchivoActionPerformed

    private void copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarActionPerformed
        CargaArchivo.copy();
    }//GEN-LAST:event_copiarActionPerformed

    private void deshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerActionPerformed
        try {
          manager.undo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
      
    }//GEN-LAST:event_deshacerActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        ReescribirArchivo.reescribir(CargaArchivo);
    }//GEN-LAST:event_guardarActionPerformed

    private void rehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rehacerActionPerformed
         try {
          manager.redo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
    }//GEN-LAST:event_rehacerActionPerformed

    private void guardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoActionPerformed
        ExportarArchivo.exportarArchivo(CargaArchivo);//enviamos parametro para guardar archivo texto
    }//GEN-LAST:event_guardarComoActionPerformed

    private void pegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarActionPerformed
        CargaArchivo.paste();
    }//GEN-LAST:event_pegarActionPerformed

    private void acercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreadorInformacion().setVisible(true);
            }
        });
    }//GEN-LAST:event_acercaDeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String valorBusqueda,textoArea,almacenadorPalabra;//creamos variables      
        valorBusqueda= buscarText.getText();//llamamos texto de entrada
        int localizador=0,interruptor=0;
        if (valorBusqueda.length() >= 1) {
            //pintamos dando luz a la letra
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
            //indicamos a que es lo que daríamos luz
            textoArea=CargaArchivo.getText();//pasamos a string el texto
            resultadoBusqueda.setText(textoArea);
            Highlighter h = resultadoBusqueda.getHighlighter();
            h.removeAllHighlights();//removemos todas las luces que tiene
            
            for (int i = 0; i < textoArea.length(); i++) {//indicamos que si lea todas las letras del text area
                if(textoArea.charAt(i)==valorBusqueda.charAt(0)){//si contiene el primer caracter continua
                    //reiniciamos valores
                    almacenadorPalabra="";
                    localizador=i;
                    interruptor=textoArea.length()-i;//interruptor para que no siga repitiendo la secuencia si no cuenta con suficientes caracteres al final
                    for (int j = 0; j < valorBusqueda.length(); j++) {
                        
                        if(textoArea.charAt(i)==valorBusqueda.charAt(j)&&interruptor>=valorBusqueda.length()){ //verificamos que todos los siguientes caracteres coincidan
                            almacenadorPalabra=almacenadorPalabra+Character.toString(valorBusqueda.charAt(j));
                            if (valorBusqueda.equals(almacenadorPalabra)) {
                                //si cumple con que todos los caracteres sean iguales pintamos todo el texto buscado de lo contrario no
                                try {
                                    h.addHighlight(localizador, localizador+valorBusqueda.length(), highlightPainter);
                                } catch (BadLocationException ex) {
                                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            i++;
                        }else{
                            j=valorBusqueda.length();
                        }
                    }
                }
            }
            BusquedaCadena.visible();//hacemos visible la busqueda de cadena
        } else {
            //indicamos mensaje de error
            JOptionPane.showMessageDialog(null, "Primero ingresa una cadena para ser leída");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea CargaArchivo;
    public static javax.swing.JTextArea MovimientoEstado;
    public static javax.swing.JTable ReportToken;
    public static javax.swing.JTable ReporteError;
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JMenuItem acercaDe;
    private javax.swing.JButton analizarTexto;
    private javax.swing.JButton buscarCadena1;
    private javax.swing.JTextField buscarText;
    private javax.swing.JMenuItem copiar;
    private javax.swing.JMenuItem deshacer;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenuItem guardarComo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JMenuItem nuevoArchivo;
    private javax.swing.JMenuItem pegar;
    private javax.swing.JMenuItem rehacer;
    // End of variables declaration//GEN-END:variables
}
