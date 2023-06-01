package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import control.ConexionBaseDatos;

public class FormListados extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormListados() throws HeadlessException {
        panelPrincipal.setLayout(null);
        JComboBox cmbEligeLista = new JComboBox<>();
        JTextArea textoListas = new JTextArea();
        //((Pelicula)ConexionBaseDatos.db.get(1).get(0)).getTitulo();
        //casteo------clase base datos.array.array.objeto.metodo


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
                    textoListas.setText("");
                    for (int i = 0; i<ConexionBaseDatos.db.get(1).size(); i++) {
                        textoListas.append("Titulo del videojuego: " + ((Videojuego)ConexionBaseDatos.db.get(1).get(i)).getTitulo() + "\n");
                    }
                    for (int i = 0; i<ConexionBaseDatos.db.get(2).size(); i++) {
                        textoListas.append("Titulo de la pelicula: " + ((Pelicula)ConexionBaseDatos.db.get(2).get(i)).getTitulo() + "\n");
                    }
                    for (int i = 0; i<ConexionBaseDatos.db.get(3).size(); i++) {
                        textoListas.append("Nombre de la cancion: " + ((Cancion)ConexionBaseDatos.db.get(3).get(i)).getNombre() + "\n");
                    }
                    for (int i = 0; i<ConexionBaseDatos.db.get(4).size(); i++) {
                        textoListas.append("Titulo del disco: " + ((Disco)ConexionBaseDatos.db.get(4).get(i)).getTitulo() + "\n");
                    }
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todas las peliculas ordenadas por titulo")){
                    textoListas.setText("");
                    ArrayList<String> peliculas = new ArrayList<>();
                    for (int i = 0; i<ConexionBaseDatos.db.get(2).size(); i++) {
                        peliculas.add(((Pelicula)ConexionBaseDatos.db.get(2).get(i)).getTitulo());
                    }

                    Collections.sort(peliculas);

                    for (String pelicula : peliculas) {
                        textoListas.append(pelicula + "\n");
                    }
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todas las canciones de un disco por duracion")) {
                    textoListas.setText("");
                    // No se como sacar el disco en cuestion del que quieres ordenar las canciones por duracion asi
                    // que de momento lo dejo en cero
                    ArrayList<Cancion> canciones = ((Disco) ConexionBaseDatos.db.get(4).get(0)).getCanciones();

                    for (int i = 0; i<canciones.size(); i++)
                    Collections.sort(canciones, new Comparator<Cancion>() {
                        @Override
                        public int compare(Cancion cancion1, Cancion cancion2) {
                            return Integer.compare(cancion1.getDuracionSegundos(), cancion2.getDuracionSegundos());
                        }
                    });
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todos los videojuegos ordenados por año")){
                    textoListas.setText("");
                    // Aqui habria que sacar de la base el titulo para mostrarlo en la lista y el año para ordenarlos
                    ArrayList<String> videojuegos = new ArrayList<>();
                    for (int i = 0; i<ConexionBaseDatos.db.get(2).size(); i++) {
                        videojuegos.add(String.valueOf(((Videojuego) ConexionBaseDatos.db.get(1).get(i)).getAnyo()));
                    }

                    Collections.sort(videojuegos);

                    for (String videojuego : videojuegos) {
                        textoListas.append(videojuego + "\n");
                    }
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
