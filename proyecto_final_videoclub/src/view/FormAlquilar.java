package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class FormAlquilar extends JFrame {
    Color colorFondo=new Color(147,249,249);
    Color colorLetraBoton=new Color(37,52,124);
    Color colorheisen=new Color(37,52,124);
    Color colorButtons= new Color(255,255,255);
    JComboBox cmbEligeMultimedia = new JComboBox<>();
    JList lstPeliculas = new JList<>();
    JList lstDiscos = new JList<>();
    JList lstVideojuegos= new JList<>();
    public JPanel panelPrincipal = new JPanel();
    public FormAlquilar() throws HeadlessException{
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);

        try{
            cmbEligeMultimedia.addItem("Elige uno");
            cmbEligeMultimedia.addItem("Películas");
            cmbEligeMultimedia.addItem("Discos");
            cmbEligeMultimedia.addItem("Videojuegos");

        }catch (Exception e){
            e.printStackTrace();
        }
        cmbEligeMultimedia.setBounds(100,100,350,50);
        panelPrincipal.add(cmbEligeMultimedia);
        if(cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")){
            lstPeliculas.setBounds(100,200,350,50);
            panelPrincipal.add(lstPeliculas);
        }
    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }

}
