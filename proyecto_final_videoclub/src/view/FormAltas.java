package view;

import control.ConexionBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class FormAltas extends JFrame {
    Color colorFondo=new Color(65,65,65);

    public JPanel panelPrincipal = new JPanel();


    public FormAltas() throws HeadlessException{
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);
        JComboBox cmbEligeAlta = new JComboBox<>();
        JLabel lTitulo = new JLabel("Título");
        Color letrTitulo = new Color(255, 255, 255);
        lTitulo.setForeground(letrTitulo);
        JTextField txtTitulo = new JTextField();
        JLabel lAutor = new JLabel("Autor");
        Color letrAutor = new Color(255, 255, 255);
        lAutor.setForeground(letrAutor);
        JTextField txtAutor = new JTextField();
        JLabel lFormato = new JLabel("Formato");
        Color letraFormato= new Color(255, 255, 255);
        lFormato.setForeground(letraFormato);
        JTextField txtFormato = new JTextField();
        JLabel lAnyo = new JLabel("Año");
        Color letrAño = new Color(255, 255, 255);
        lAnyo.setForeground(letrAño);
        JTextField txtAnyo = new JTextField();
        JLabel lPlataforma = new JLabel("Plataforma");
        Color letrPlataforma = new Color(255, 255, 255);
        lPlataforma.setForeground(letrPlataforma);
        JTextField txtPlataforma = new JTextField();
        JLabel lDuracion = new JLabel("Duracion");
        Color letrDuracion = new Color(255, 255, 255);
        lDuracion.setForeground(letrDuracion);
        JTextField txtDuracion = new JTextField();
        JLabel lActorPrincipal = new JLabel("Actor principal");
        Color letrActor = new Color(255, 255, 255);
        lActorPrincipal.setForeground(letrActor);
        JTextField txtActorPrincipal = new JTextField();
        JLabel lActrizPrincipal = new JLabel("Actriz principal");
        Color letrActriz = new Color(255, 255, 255);
        lActrizPrincipal.setForeground(letrActriz);
        JTextField txtActrizPrincipal = new JTextField();
        JLabel lNif = new JLabel("NIF");
        Color letraNIF = new Color(255, 255, 255);
        lNif.setForeground(letraNIF);
        JTextField txtNif = new JTextField();
        JLabel lNombre = new JLabel("Nombre");
        Color letrNOMBRE= new Color(255, 255, 255);
        lNombre.setForeground(letrNOMBRE);
        JTextField txtNombre = new JTextField();
        JLabel lAnyoNacimiento = new JLabel("Año de Nacimiento");
        Color letraNACIMIENTO = new Color(255, 255, 255);
        lAnyoNacimiento.setForeground(letraNACIMIENTO);
        JTextField txtAnyoNacimiento = new JTextField();
        JLabel lPoblacion = new JLabel("Poblacion");
        Color letrPoblacion = new Color(255, 255, 255);
        lPoblacion.setForeground(letrPoblacion);
        JTextField txtPoblacion = new JTextField();
        JLabel lNombreCancion = new JLabel("Nombre de cancion");
        Color letrCancion = new Color(255, 255, 255);
        lNombreCancion.setForeground(letrCancion);
        JTextField txtNombreCancion = new JTextField();
        JLabel lDuracionSegundos = new JLabel("Duracion en segundos");
        Color letraDuracion= new Color(255, 255, 255);
        lDuracionSegundos.setForeground(letraDuracion);
        JTextField txtDuracionSegundos = new JTextField();
        JLabel lDuracionDisco = new JLabel("Duracion del disco");
        Color letrDISCO= new Color(255, 255, 255);
        lDuracionDisco.setForeground(letrDISCO);
        JTextField txtDuracionDisco = new JTextField();

        JLabel lColeccionCanciones = new JLabel("Nombres de canciones");
        Color letrColeccion = new Color(255, 255, 255);
        lColeccionCanciones.setForeground(letrColeccion);
        DefaultListModel<Cancion> modelo = new DefaultListModel<>();

        for (int i = 0; i<ConexionBaseDatos.db.get(3).size(); i++){
            modelo.addElement((Cancion) ConexionBaseDatos.db.get(3).get(i));
        }


        JList<Cancion> jListCanciones = new JList<>(modelo);
        JScrollPane scroll = new JScrollPane(jListCanciones);
        scroll.setBounds(100, 300, 350, 100);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelPrincipal.add(scroll);
        jListCanciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JButton btnAltaSocio = new JButton("Alta de socio");
        Color colorLetraBoton=new Color(255,255,255);
        Color colorButtons= new Color(82,82,82);
        btnAltaSocio.setBackground(colorButtons);
        btnAltaSocio.setForeground(colorLetraBoton);
        JButton btnAltaPelicula = new JButton("Alta de película");
        btnAltaPelicula.setBackground(colorButtons);
        btnAltaPelicula.setForeground(colorLetraBoton);
        JButton btnAltaVideojuego = new JButton("Alta de videojuego");
        btnAltaVideojuego.setBackground(colorButtons);
        btnAltaVideojuego.setForeground(colorLetraBoton);
        JButton btnAltaCancion = new JButton("Alta de cancion");
        btnAltaCancion.setBackground(colorButtons);
        btnAltaCancion.setForeground(colorLetraBoton);
        JButton btnAltaDisco = new JButton("Alta de disco");
        btnAltaDisco.setBackground(colorButtons);
        btnAltaDisco.setForeground(colorLetraBoton);

        try{
            cmbEligeAlta.addItem("Elige uno");
            cmbEligeAlta.addItem("Alta de socio");
            cmbEligeAlta.addItem("Alta de pelicula");
            cmbEligeAlta.addItem("Alta de videojuego");
            cmbEligeAlta.addItem("Alta de cancion");
            cmbEligeAlta.addItem("Alta de disco");
        }catch (Exception e){
            e.printStackTrace();
        }

        // ComboBox con opciones
        cmbEligeAlta.setBounds(100,100,150,50);
        panelPrincipal.add(cmbEligeAlta);

        // Controles comunes en mas de una opcion
        lTitulo.setBounds(100,200,50,20);
        lTitulo.setVisible(false);
        panelPrincipal.add(lTitulo);
        txtTitulo.setBounds(150,200,100,20);
        txtTitulo.setVisible(false);
        panelPrincipal.add(txtTitulo);
        lAutor.setBounds(100,250,50,20);
        lAutor.setVisible(false);
        panelPrincipal.add(lAutor);
        txtAutor.setBounds(150,250,100,20);
        txtAutor.setVisible(false);
        panelPrincipal.add(txtAutor);
        lFormato.setBounds(100,300,50,20);
        lFormato.setVisible(false);
        panelPrincipal.add(lFormato);
        txtFormato.setBounds(150,300,100,20);
        txtFormato.setVisible(false);
        panelPrincipal.add(txtFormato);
        lAnyo.setBounds(100,350,50,20);
        lAnyo.setVisible(false);
        panelPrincipal.add(lAnyo);
        txtAnyo.setBounds(150,350,100,20);
        txtAnyo.setVisible(false);
        panelPrincipal.add(txtAnyo);

        // Controles videojuego
        lPlataforma.setBounds(80,400,70,20);
        lPlataforma.setVisible(false);
        panelPrincipal.add(lPlataforma);
        txtPlataforma.setBounds(150,400,100,20);
        txtPlataforma.setVisible(false);
        panelPrincipal.add(txtPlataforma);

        // Controles pelicula
        lDuracion.setBounds(80,400,70,20);
        lDuracion.setVisible(false);
        panelPrincipal.add(lDuracion);
        txtDuracion.setBounds(150,400,100,20);
        txtDuracion.setVisible(false);
        panelPrincipal.add(txtDuracion);
        lActorPrincipal.setBounds(50,450,100,20);
        lActorPrincipal.setVisible(false);
        panelPrincipal.add(lActorPrincipal);
        txtActorPrincipal.setBounds(150,450,100,20);
        txtActorPrincipal.setVisible(false);
        panelPrincipal.add(txtActorPrincipal);
        lActrizPrincipal.setBounds(50,500,100,20);
        lActrizPrincipal.setVisible(false);
        panelPrincipal.add(lActrizPrincipal);
        txtActrizPrincipal.setBounds(150,500,100,20);
        txtActrizPrincipal.setVisible(false);
        panelPrincipal.add(txtActrizPrincipal);

        // Controles socio
        lNif.setBounds(100,200,50,20);
        lNif.setVisible(false);
        panelPrincipal.add(lNif);
        txtNif.setBounds(150,200,100,20);
        txtNif.setVisible(false);
        panelPrincipal.add(txtNif);
        lNombre.setBounds(100,250,50,20);
        lNombre.setVisible(false);
        panelPrincipal.add(lNombre);
        txtNombre.setBounds(150,250,100,20);
        txtNombre.setVisible(false);
        panelPrincipal.add(txtNombre);
        lAnyoNacimiento.setBounds(30,300,130,20);
        lAnyoNacimiento.setVisible(false);
        panelPrincipal.add(lAnyoNacimiento);
        txtAnyoNacimiento.setBounds(150,300,100,20);
        txtAnyoNacimiento.setVisible(false);
        panelPrincipal.add(txtAnyoNacimiento);
        lPoblacion.setBounds(80,350,60,20);
        lPoblacion.setVisible(false);
        panelPrincipal.add(lPoblacion);
        txtPoblacion.setBounds(150,350,100,20);
        txtPoblacion.setVisible(false);
        panelPrincipal.add(txtPoblacion);

        // Controles cancion
        lNombreCancion.setBounds(30,200,130,20);
        lNombreCancion.setVisible(false);
        panelPrincipal.add(lNombreCancion);
        txtNombreCancion.setBounds(150,200,100,20);
        txtNombreCancion.setVisible(false);
        panelPrincipal.add(txtNombreCancion);
        lDuracionSegundos.setBounds(20,250,130,20);
        lDuracionSegundos.setVisible(false);
        panelPrincipal.add(lDuracionSegundos);
        txtDuracionSegundos.setBounds(150,250,100,20);
        txtDuracionSegundos.setVisible(false);
        panelPrincipal.add(txtDuracionSegundos);

        //Controles disco
        lDuracionDisco.setBounds(30,400,115,20);
        lDuracionDisco.setVisible(false);
        panelPrincipal.add(lDuracionDisco);
        txtDuracionDisco.setBounds(150,400,100,20);
        txtDuracionDisco.setVisible(false);
        panelPrincipal.add(txtDuracionDisco);
        lColeccionCanciones.setBounds(10,450,135,20);
        lColeccionCanciones.setVisible(false);
        panelPrincipal.add(lColeccionCanciones);
        jListCanciones.setBounds(150,450,300,70);
        jListCanciones.setVisible(false);
        panelPrincipal.add(jListCanciones);

        // Botones para crear objeto segun opciones
        btnAltaSocio.setBounds(600,300,150,50);
        btnAltaSocio.setVisible(false);
        panelPrincipal.add(btnAltaSocio);
        btnAltaPelicula.setBounds(600,300,150,50);
        btnAltaPelicula.setVisible(false);
        panelPrincipal.add(btnAltaPelicula);
        btnAltaVideojuego.setBounds(600,300,150,50);
        btnAltaVideojuego.setVisible(false);
        panelPrincipal.add(btnAltaVideojuego);
        btnAltaCancion.setBounds(600,300,150,50);
        btnAltaCancion.setVisible(false);
        panelPrincipal.add(btnAltaCancion);
        btnAltaDisco.setBounds(600,300,150,50);
        btnAltaDisco.setVisible(false);
        panelPrincipal.add(btnAltaDisco);
        cmbEligeAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbEligeAlta.getSelectedItem().toString().equals("Elige uno")){
                    lDuracion.setVisible(false);
                    txtDuracion.setVisible(false);
                    lActorPrincipal.setVisible(false);
                    txtActorPrincipal.setVisible(false);
                    lActrizPrincipal.setVisible(false);
                    txtActrizPrincipal.setVisible(false);
                    btnAltaPelicula.setVisible(false);
                    lPlataforma.setVisible(false);
                    txtPlataforma.setVisible(false);
                    btnAltaVideojuego.setVisible(false);
                    lTitulo.setVisible(false);
                    txtTitulo.setVisible(false);
                    lAutor.setVisible(false);
                    txtAutor.setVisible(false);
                    lFormato.setVisible(false);
                    txtFormato.setVisible(false);
                    lAnyo.setVisible(false);
                    txtAnyo.setVisible(false);
                    lNif.setVisible(false);
                    txtNif.setVisible(false);
                    lNombre.setVisible(false);
                    txtNombre.setVisible(false);
                    lAnyoNacimiento.setVisible(false);
                    txtAnyoNacimiento.setVisible(false);
                    lPoblacion.setVisible(false);
                    txtPoblacion.setVisible(false);
                    btnAltaSocio.setVisible(false);
                    lNombreCancion.setVisible(false);
                    txtNombreCancion.setVisible(false);
                    lDuracionSegundos.setVisible(false);
                    txtDuracionSegundos.setVisible(false);
                    btnAltaCancion.setVisible(false);
                    lDuracionDisco.setVisible(false);
                    txtDuracionDisco.setVisible(false);
                    lColeccionCanciones.setVisible(false);
                    jListCanciones.setVisible(false);
                    btnAltaDisco.setVisible(false);
                }
                else if (cmbEligeAlta.getSelectedItem().toString().equals("Alta de socio")){
                    lDuracion.setVisible(false);
                    txtDuracion.setVisible(false);
                    lActorPrincipal.setVisible(false);
                    txtActorPrincipal.setVisible(false);
                    lActrizPrincipal.setVisible(false);
                    txtActrizPrincipal.setVisible(false);
                    btnAltaPelicula.setVisible(false);
                    lPlataforma.setVisible(false);
                    txtPlataforma.setVisible(false);
                    btnAltaVideojuego.setVisible(false);
                    lTitulo.setVisible(false);
                    txtTitulo.setVisible(false);
                    lAutor.setVisible(false);
                    txtAutor.setVisible(false);
                    lFormato.setVisible(false);
                    txtFormato.setVisible(false);
                    lAnyo.setVisible(false);
                    txtAnyo.setVisible(false);
                    lNombreCancion.setVisible(false);
                    txtNombreCancion.setVisible(false);
                    lDuracionSegundos.setVisible(false);
                    txtDuracionSegundos.setVisible(false);
                    btnAltaCancion.setVisible(false);
                    lDuracionDisco.setVisible(false);
                    txtDuracionDisco.setVisible(false);
                    lColeccionCanciones.setVisible(false);
                    jListCanciones.setVisible(false);
                    btnAltaDisco.setVisible(false);

                    lNif.setVisible(true);
                    txtNif.setVisible(true);
                    lNombre.setVisible(true);
                    txtNombre.setVisible(true);
                    lAnyoNacimiento.setVisible(true);
                    txtAnyoNacimiento.setVisible(true);
                    lPoblacion.setVisible(true);
                    txtPoblacion.setVisible(true);
                    btnAltaSocio.setVisible(true);
                }
                else if (cmbEligeAlta.getSelectedItem().toString().equals("Alta de videojuego")){
                    lDuracion.setVisible(false);
                    txtDuracion.setVisible(false);
                    lActorPrincipal.setVisible(false);
                    txtActorPrincipal.setVisible(false);
                    lActrizPrincipal.setVisible(false);
                    txtActrizPrincipal.setVisible(false);
                    btnAltaPelicula.setVisible(false);
                    lNif.setVisible(false);
                    txtNif.setVisible(false);
                    lNombre.setVisible(false);
                    txtNombre.setVisible(false);
                    lAnyoNacimiento.setVisible(false);
                    txtAnyoNacimiento.setVisible(false);
                    lPoblacion.setVisible(false);
                    txtPoblacion.setVisible(false);
                    btnAltaSocio.setVisible(false);
                    lNombreCancion.setVisible(false);
                    txtNombreCancion.setVisible(false);
                    lDuracionSegundos.setVisible(false);
                    txtDuracionSegundos.setVisible(false);
                    btnAltaCancion.setVisible(false);
                    lDuracionDisco.setVisible(false);
                    txtDuracionDisco.setVisible(false);
                    lColeccionCanciones.setVisible(false);
                    jListCanciones.setVisible(false);
                    btnAltaDisco.setVisible(false);

                    lTitulo.setVisible(true);
                    txtTitulo.setVisible(true);
                    lAutor.setVisible(true);
                    txtAutor.setVisible(true);
                    lFormato.setVisible(true);
                    txtFormato.setVisible(true);
                    lAnyo.setVisible(true);
                    txtAnyo.setVisible(true);
                    lPlataforma.setVisible(true);
                    txtPlataforma.setVisible(true);
                    btnAltaVideojuego.setVisible(true);
                }
                else if (cmbEligeAlta.getSelectedItem().toString().equals("Alta de pelicula")){
                    lPlataforma.setVisible(false);
                    txtPlataforma.setVisible(false);
                    btnAltaVideojuego.setVisible(false);
                    lNif.setVisible(false);
                    txtNif.setVisible(false);
                    lNombre.setVisible(false);
                    txtNombre.setVisible(false);
                    lAnyoNacimiento.setVisible(false);
                    txtAnyoNacimiento.setVisible(false);
                    lPoblacion.setVisible(false);
                    txtPoblacion.setVisible(false);
                    btnAltaSocio.setVisible(false);
                    lNombreCancion.setVisible(false);
                    txtNombreCancion.setVisible(false);
                    lDuracionSegundos.setVisible(false);
                    txtDuracionSegundos.setVisible(false);
                    btnAltaCancion.setVisible(false);
                    lDuracionDisco.setVisible(false);
                    txtDuracionDisco.setVisible(false);
                    lColeccionCanciones.setVisible(false);
                    jListCanciones.setVisible(false);
                    btnAltaDisco.setVisible(false);

                    lTitulo.setVisible(true);
                    txtTitulo.setVisible(true);
                    lAutor.setVisible(true);
                    txtAutor.setVisible(true);
                    lFormato.setVisible(true);
                    txtFormato.setVisible(true);
                    lAnyo.setVisible(true);
                    txtAnyo.setVisible(true);
                    lDuracion.setVisible(true);
                    txtDuracion.setVisible(true);
                    lActorPrincipal.setVisible(true);
                    txtActorPrincipal.setVisible(true);
                    lActrizPrincipal.setVisible(true);
                    txtActrizPrincipal.setVisible(true);
                    btnAltaPelicula.setVisible(true);
                }
                else if(cmbEligeAlta.getSelectedItem().toString().equals("Alta de cancion")){
                    lDuracion.setVisible(false);
                    txtDuracion.setVisible(false);
                    lActorPrincipal.setVisible(false);
                    txtActorPrincipal.setVisible(false);
                    lActrizPrincipal.setVisible(false);
                    txtActrizPrincipal.setVisible(false);
                    btnAltaPelicula.setVisible(false);
                    lPlataforma.setVisible(false);
                    txtPlataforma.setVisible(false);
                    btnAltaVideojuego.setVisible(false);
                    lTitulo.setVisible(false);
                    txtTitulo.setVisible(false);
                    lAutor.setVisible(false);
                    txtAutor.setVisible(false);
                    lFormato.setVisible(false);
                    txtFormato.setVisible(false);
                    lAnyo.setVisible(false);
                    txtAnyo.setVisible(false);
                    lNif.setVisible(false);
                    txtNif.setVisible(false);
                    lNombre.setVisible(false);
                    txtNombre.setVisible(false);
                    lAnyoNacimiento.setVisible(false);
                    txtAnyoNacimiento.setVisible(false);
                    lPoblacion.setVisible(false);
                    txtPoblacion.setVisible(false);
                    btnAltaSocio.setVisible(false);
                    lDuracionDisco.setVisible(false);
                    txtDuracionDisco.setVisible(false);
                    lColeccionCanciones.setVisible(false);
                    jListCanciones.setVisible(false);
                    btnAltaDisco.setVisible(false);

                    lNombreCancion.setVisible(true);
                    txtNombreCancion.setVisible(true);
                    lDuracionSegundos.setVisible(true);
                    txtDuracionSegundos.setVisible(true);
                    btnAltaCancion.setVisible(true);
                }
                else if (cmbEligeAlta.getSelectedItem().toString().equals("Alta de disco")){
                    lDuracion.setVisible(false);
                    txtDuracion.setVisible(false);
                    lActorPrincipal.setVisible(false);
                    txtActorPrincipal.setVisible(false);
                    lActrizPrincipal.setVisible(false);
                    txtActrizPrincipal.setVisible(false);
                    btnAltaPelicula.setVisible(false);
                    lPlataforma.setVisible(false);
                    txtPlataforma.setVisible(false);
                    btnAltaVideojuego.setVisible(false);
                    lNif.setVisible(false);
                    txtNif.setVisible(false);
                    lNombre.setVisible(false);
                    txtNombre.setVisible(false);
                    lAnyoNacimiento.setVisible(false);
                    txtAnyoNacimiento.setVisible(false);
                    lPoblacion.setVisible(false);
                    txtPoblacion.setVisible(false);
                    btnAltaSocio.setVisible(false);
                    lNombreCancion.setVisible(false);
                    txtNombreCancion.setVisible(false);
                    lDuracionSegundos.setVisible(false);
                    txtDuracionSegundos.setVisible(false);
                    btnAltaCancion.setVisible(false);

                    lTitulo.setVisible(true);
                    txtTitulo.setVisible(true);
                    lAutor.setVisible(true);
                    txtAutor.setVisible(true);
                    lFormato.setVisible(true);
                    txtFormato.setVisible(true);
                    lAnyo.setVisible(true);
                    txtAnyo.setVisible(true);
                    lDuracionDisco.setVisible(true);
                    txtDuracionDisco.setVisible(true);
                    lColeccionCanciones.setVisible(true);
                    jListCanciones.setVisible(true);
                    btnAltaDisco.setVisible(true);
                }
            }
        });

        btnAltaSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nif = txtNif.getText();
                String nombre = txtNombre.getText();
                int anyoNacimiento = Integer.parseInt(txtAnyoNacimiento.getText());
                String poblacion = txtPoblacion.getText();
                ArrayList<Multimedia> multimedias= new ArrayList<Multimedia>();
                Socio s = new Socio(nif, nombre, anyoNacimiento, poblacion, false, multimedias);
                ConexionBaseDatos.db.get(0).add(s);

            }
        });

        btnAltaPelicula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtAnyo.getText());
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String formato = txtFormato.getText();
                int anyo = Integer.parseInt(txtAnyo.getText());
                int duracion = Integer.parseInt(txtDuracion.getText());
                String actorPrincipal = txtActorPrincipal.getText();
                String actrizPrincipal = txtActrizPrincipal.getText();
                Date diaAlquilado = null;

                Pelicula p = new Pelicula(titulo, autor, formato, anyo, diaAlquilado, duracion, actorPrincipal, actrizPrincipal);
                ConexionBaseDatos.db.get(2).add(p);
            }
        });

        btnAltaVideojuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtAnyo.getText());
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String formato = txtFormato.getText();
                int anyo = Integer.parseInt(txtAnyo.getText());
                String plataforma = txtPlataforma.getText();
                Date diaAlquilado = null;

                Videojuego v = new Videojuego(titulo, autor, formato, anyo, diaAlquilado, plataforma);
                ConexionBaseDatos.db.get(1).add(v);
            }
        });

        btnAltaCancion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombreCancion.getText();
                int duracionSegundos = Integer.parseInt(txtDuracionSegundos.getText());

                Cancion c = new Cancion(nombre, duracionSegundos);
                ConexionBaseDatos.db.get(3).add(c);
            }
        });

        btnAltaDisco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String formato = txtFormato.getText();
                int anyo = Integer.parseInt(txtAnyo.getText());
                int duracionDisco = Integer.parseInt(txtDuracionDisco.getText());
                Date diaAlquilado = null;
                int[] indicesSeleccionados = jListCanciones.getSelectedIndices();

                ArrayList<Cancion> canciones = new ArrayList<Cancion>();
                for (int indice : indicesSeleccionados) {
                    Cancion cancionSeleccionada = modelo.getElementAt(indice);
                    canciones.add(cancionSeleccionada);
                }
                int duracion=0;
                for (Cancion cancion : canciones) {
                    duracion+=cancion.getDuracionSegundos();
                }
                Disco d = new Disco(titulo,autor,formato,anyo,diaAlquilado,duracionDisco,canciones);
                ConexionBaseDatos.db.get(4).add(d);
            }


        });
    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
