package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAlquilar extends JFrame {
    String[] listaTest ={"1","2","3","4","5","6","1","2","3","4","5","6"};
    String[] listaTest2 ={"a","b","c","d","e","f","a","b","c","d"};
    String[] listaTest3 ={"!","@","¢","!","@","¢",};
    Color colorFondo=new Color(147,249,249);

    public JPanel panelPrincipal = new JPanel();
    public FormAlquilar() throws HeadlessException{

        JComboBox cmbEligeMultimedia = new JComboBox<>();
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

        JList lstPeliculas = new JList<>(listaTest);
        panelPrincipal.add(lstPeliculas);
        lstPeliculas.setVisibleRowCount(listaTest.length);
        lstPeliculas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollerPeliculas = new JScrollPane(lstPeliculas);
        scrollerPeliculas.setBounds(100,300,350,100);
        scrollerPeliculas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerPeliculas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelPrincipal.add(scrollerPeliculas);
        scrollerPeliculas.setVisible(true);






        try{
            cmbEligeMultimedia.addItem("Elige uno");
            cmbEligeMultimedia.addItem("Películas");
            cmbEligeMultimedia.addItem("Discos");
            cmbEligeMultimedia.addItem("Videojuegos");

        }catch (Exception e){
            e.printStackTrace();
        }

        cmbEligeMultimedia.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")){


            }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")){

            }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")){


            }
        }
        });

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }

}
