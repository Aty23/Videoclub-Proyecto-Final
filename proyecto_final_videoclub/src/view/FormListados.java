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
import control.metodos;

public class FormListados extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormListados() throws HeadlessException {
        panelPrincipal.setLayout(null);
        Color colorFondo=new Color(65,65,65);
        panelPrincipal.setBackground(colorFondo);
        Color colorLetraBoton = new Color(255, 255, 255);
        Color colorButtons = new Color(82, 82, 82);


        JLabel dniLabel = new JLabel("Dni Cliente");
        Color letradni = new Color(255, 255, 255);
        dniLabel.setForeground(letradni);
        JTextField dniCliente = new JTextField();
        JButton dniBtn = new JButton("Enviar");
        dniLabel.setBounds(0,0,100,30);
        panelPrincipal.add(dniLabel);
        dniCliente.setBounds(0,30,100,25);
        panelPrincipal.add(dniCliente);
        dniBtn.setBounds(100,30,75,25);
        dniBtn.setBackground(colorButtons);
        dniBtn.setForeground(colorLetraBoton);
        panelPrincipal.add(dniBtn);

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
                    Collections.sort(canciones, new Comparator<Cancion>() {
                        @Override
                        public int compare(Cancion cancion1, Cancion cancion2) {
                            return Integer.compare(cancion1.getDuracionSegundos(), cancion2.getDuracionSegundos());
                        }
                    });

                    for (Cancion cancion : canciones) {
                        textoListas.append(cancion + "\n");
                    }
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de todos los videojuegos ordenados por año")){
                    textoListas.setText("");
                    ArrayList<Videojuego> videojuegos = new ArrayList<>();
                    for (int i = 0; i<ConexionBaseDatos.db.get(2).size(); i++){
                        videojuegos.add((Videojuego) ConexionBaseDatos.db.get(1).get(i));
                    }

                    Collections.sort(videojuegos, new Comparator<Videojuego>() {
                        @Override
                        public int compare(Videojuego juego1, Videojuego juego2) {
                            return juego1.getAnyo() - juego2.getAnyo();
                        }
                    });

                    for (Videojuego juego: videojuegos) {
                        textoListas.append(juego.getTitulo() + " " + juego.getAnyo() + "\n");
                    }
                }
                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de los alquileres actuales de un socio")){
                    textoListas.setText("");
                    ArrayList<String> multimediaSocio = new ArrayList<>();
                    for (int i = 0; i<ConexionBaseDatos.db.get(0).size(); i++){
                        if(((Socio) ConexionBaseDatos.db.get(0).get(i)).getNif() == metodos.buscarUsuario(dniCliente.getText()).getNif()){
                            multimediaSocio.add(((Socio) ConexionBaseDatos.db.get(0).get(i)).getTitulosMultimediaAlquilado());
                        }
                    }

                    for (String multimedia: multimediaSocio) {
                        textoListas.append(multimedia);
                    }

                if (cmbEligeLista.getSelectedItem().toString().equals("Listado de los socios con recargos pendientes")){
                    textoListas.setText("");
                    ArrayList<String> recargoSocio = new ArrayList<>();
                    for (int i = 0; i<ConexionBaseDatos.db.get(0).size(); i++){
                        if(((Socio) ConexionBaseDatos.db.get(0).get(i)).isRecargoPendiente()){
                            recargoSocio.add(((Socio) ConexionBaseDatos.db.get(0).get(i)).getNombre());
                        }
                    }

                    for (String nombre: recargoSocio) {
                        textoListas.append(nombre + "\n");
                    }
                }
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
