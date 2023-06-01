package view;

import control.ConexionBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormAlquilar extends JFrame {
    String[] listaTest ={"1","2","3","4","5","6","1","2","3","4","5","6"};
    String[] listaTest2 ={"a","b","c","d","e","f","a","b","c","d"};
    String[] listaTest3 ={"!","@","¢","!","@","¢",};
    Color colorFondo=new Color(147,249,249);

    public JPanel panelPrincipal = new JPanel();
    JComboBox cmbEligeMultimedia = new JComboBox<>();
    public FormAlquilar() throws HeadlessException{


        cmbEligeMultimedia.setBounds(100,100,350,50);
        panelPrincipal.add(cmbEligeMultimedia);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);

        JTextField txtfldMulti = new JTextField(20);
        txtfldMulti.setBounds(100,200,350,30);
        txtfldMulti.setVisible(true);
        panelPrincipal.add(txtfldMulti);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(500,200,100,30);
        btnBuscar.setVisible(true);
        panelPrincipal.add(btnBuscar);

        JButton btnAlquilar = new JButton("Alquilar");
        btnAlquilar.setBounds(500,500,100,30);
        btnAlquilar.setVisible(true);
        panelPrincipal.add(btnAlquilar);

        JLabel lblAlquiler = new JLabel("El precio es:");
        lblAlquiler.setBounds(100,500,100,30);
        lblAlquiler.setVisible(true);
        panelPrincipal.add(lblAlquiler);








        try{
            cmbEligeMultimedia.addItem("Elige uno");
            cmbEligeMultimedia.addItem("Películas");
            cmbEligeMultimedia.addItem("Discos");
            cmbEligeMultimedia.addItem("Videojuegos");

        }catch (Exception e){
            e.printStackTrace();
        }
        btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //((Pelicula)ConexionBaseDatos.db.get(1).get(0)).getTitulo();
                //casteo------clase base datos.array.array.objeto.metodo
                JList lstBuscar = new JList<>((ListModel) buscadorMultimedia(txtfldMulti.getText()));
                panelPrincipal.add(lstBuscar);
                lstBuscar.setVisibleRowCount(buscadorMultimedia(txtfldMulti.getText()).size());
                lstBuscar.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                JScrollPane scrollerPeliculas = new JScrollPane(lstBuscar);
                scrollerPeliculas.setBounds(100,300,350,100);
                scrollerPeliculas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollerPeliculas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                panelPrincipal.add(scrollerPeliculas);
                scrollerPeliculas.setVisible(true);
            }
        });
        

        /*cmbEligeMultimedia.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")){


            }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")){

            }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")){


            }
        }
        });*/

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
    public ArrayList<Multimedia> buscadorMultimedia(String nombreMultimedia){
        ArrayList<Multimedia> resultado = new ArrayList<>();
        if(cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")){
            for (int i=0;i<ConexionBaseDatos.db.size();i++) {
                if (((Pelicula)ConexionBaseDatos.db.get(2).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                    resultado.add(((Pelicula)ConexionBaseDatos.db.get(2).get(i)));
                }
            }

        }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")){
            for (int i=0;i<ConexionBaseDatos.db.size();i++) {
                if (((Disco)ConexionBaseDatos.db.get(4).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                    resultado.add(((Disco)ConexionBaseDatos.db.get(4).get(i)));
                }
            }
        }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")){
            for (int i=0;i<ConexionBaseDatos.db.size();i++) {
                if (((Videojuego)ConexionBaseDatos.db.get(1).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                    resultado.add(((Videojuego)ConexionBaseDatos.db.get(1).get(i)));
                }
            }

        }

        return resultado;
    }
}
