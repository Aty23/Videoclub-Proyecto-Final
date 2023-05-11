package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAltas extends JFrame {

    public JPanel panelPrincipal = new JPanel();

    public FormAltas() throws HeadlessException{
        panelPrincipal.setLayout(null);
        JComboBox cmbEligeAlta = new JComboBox<>();
        JButton btnMostrarDatos= new JButton("Mostrar datos a rellenar");
        JLabel lTitulo = new JLabel("Título");
        JTextField txtTitulo = new JTextField();
        JLabel lAutor = new JLabel("Autor");
        JTextField txtAutor = new JTextField();
        JLabel lFormato = new JLabel("Formato");
        JTextField txtFormato = new JTextField();
        JLabel lAnyo = new JLabel("Año");
        JTextField txtAnyo = new JTextField();
        JLabel lPlataforma = new JLabel("Plataforma");
        JTextField txtPlataforma = new JTextField();
        JLabel lDuracion = new JLabel("Duracion");
        JTextField txtDuracion = new JTextField();
        JLabel lActorPrincipal = new JLabel("Actor principal");
        JTextField txtActorPrincipal = new JTextField();
        JLabel lActrizPrincipal = new JLabel("Actriz principal");
        JTextField txtActrizPrincipal = new JTextField();
        JButton btnAltaSocio = new JButton("Alta de socio");
        JButton btnAltaPelicula = new JButton("Alta de película");
        JButton btnAltaVideojuego = new JButton("Alta de videojuego");

        try{
            cmbEligeAlta.addItem("Alta de socio");
            cmbEligeAlta.addItem("Alta de pelicula");
            cmbEligeAlta.addItem("Alta de videojuego");
        }catch (Exception e){
            e.printStackTrace();
        }
        cmbEligeAlta.setBounds(100,100,150,50);
        panelPrincipal.add(cmbEligeAlta);
        btnMostrarDatos.setBounds(250,100,200,50);
        panelPrincipal.add(btnMostrarDatos);
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
        lPlataforma.setBounds(80,400,70,20);
        lPlataforma.setVisible(false);
        panelPrincipal.add(lPlataforma);
        txtPlataforma.setBounds(150,400,100,20);
        txtPlataforma.setVisible(false);
        panelPrincipal.add(txtPlataforma);
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

        btnAltaSocio.setBounds(600,300,150,50);
        btnAltaSocio.setVisible(false);
        panelPrincipal.add(btnAltaSocio);
        btnAltaPelicula.setBounds(600,300,150,50);
        btnAltaPelicula.setVisible(false);
        panelPrincipal.add(btnAltaPelicula);
        btnAltaVideojuego.setBounds(600,300,150,50);
        btnAltaVideojuego.setVisible(false);
        panelPrincipal.add(btnAltaVideojuego);

        btnMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbEligeAlta.getSelectedItem().toString().equals("Alta de videojuego")){
                    lDuracion.setVisible(false);
                    txtDuracion.setVisible(false);
                    lActorPrincipal.setVisible(false);
                    txtActorPrincipal.setVisible(false);
                    lActrizPrincipal.setVisible(false);
                    txtActrizPrincipal.setVisible(false);
                    btnAltaPelicula.setVisible(false);

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
            }
        });
    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
