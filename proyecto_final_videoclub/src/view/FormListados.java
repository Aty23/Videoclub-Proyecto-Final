package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import control.ConexionBaseDatos;

public class FormListados extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormListados() throws HeadlessException {
        panelPrincipal.setLayout(null);
        JComboBox cmbEligeLista = new JComboBox<>();
        JTextArea textoListas = new JTextArea();

        ConexionBaseDatos con = new ConexionBaseDatos();
        ArrayList<ArrayList<Object>> info = con.conexionBase();

        ArrayList<Object> infoSocio = info.get(0);
        ArrayList<Object> infoVideojuego = info.get(1);
        ArrayList<Object> infoPelicula = info.get(2);
        ArrayList<Object> infoCancion = info.get(3);
        ArrayList<Object> infoDisco = info.get(4);

        try{
            cmbEligeLista.addItem("Elige uno");
            cmbEligeLista.addItem("Listado de todos los objetos multimedia");
            cmbEligeLista.addItem("Listado de todas las peliculas ordenadas por titulo");
            cmbEligeLista.addItem("Listado de todas las canciones de un disco por duracion");
            cmbEligeLista.addItem("Listado de todos los videojuegos ordenados por año");
            cmbEligeLista.addItem("Listado de los alquileres actuales de un socio");
            cmbEligeLista.addItem("Listado de los socios con recargos pendientes");
        }catch (Exception e){
            e.printStackTrace();
        }

        cmbEligeLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbEligeLista.getSelectedItem().toString().equals("Elige uno")){
                    textoListas.setText("");
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todos los objetos multimedia")){
                    for (ArrayList<Object> lista : info) {
                        for (Object obj : lista) {
                            if (obj instanceof Socio) {
                                Socio socio = (Socio) obj;
                                textoListas.append("Nombre del socio: " + socio.getNombre() + "\n");
                            } else if (obj instanceof Videojuego) {
                                Videojuego videojuego = (Videojuego) obj;
                                textoListas.append("Título del videojuego: " + videojuego.getTitulo() + "\n");
                            }
                            else if (obj instanceof Pelicula) {
                                Pelicula pelicula = (Pelicula) obj;
                                textoListas.append("Título de la pelicula: " + pelicula.getTitulo() + "\n");
                            }
                            else if (obj instanceof Cancion) {
                                Cancion cancion = (Cancion) obj;
                                textoListas.append("Nombre de la cancion: " + cancion.getNombre() + "\n");
                            }
                            else if (obj instanceof Disco) {
                                Disco disco = (Disco) obj;
                                textoListas.append("Título del disco: " + disco.getTitulo() + "\n");
                            }
                        }
                    }
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todas las peliculas ordenadas por titulo")){
                    textoListas.setText("");
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todas las canciones de un disco por duracion")){
                    textoListas.setText("");
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todos los videojuegos ordenados por año")){
                    textoListas.setText("");
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de los alquileres actuales de un socio")){
                    textoListas.setText("");
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de los socios con recargos pendientes")){
                    textoListas.setText("");
                }
            }
        });

        cmbEligeLista.setBounds(100,100,350,50);
        panelPrincipal.add(cmbEligeLista);
        textoListas.setBounds(100,200,600,300);
        panelPrincipal.add(textoListas);

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
