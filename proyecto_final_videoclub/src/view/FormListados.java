package view;

import javax.swing.*;
import java.awt.*;

public class FormListados extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormListados() throws HeadlessException {
        panelPrincipal.setLayout(null);
        JComboBox cmbEligeLista = new JComboBox<>();
        JTextArea textoListas = new JTextArea();

        try{
            cmbEligeLista.addItem("Elige uno");
            cmbEligeLista.addItem("Listado de todos los objetos multimedia");
            cmbEligeLista.addItem("Listado de todas las peliculas ordenadas por titulo");
            cmbEligeLista.addItem("Listado de todas las canciones de un disco por duracion");
            cmbEligeLista.addItem("Listado de todos los videojuegos ordenador por año");
            cmbEligeLista.addItem("Listado de los alquileres actuales de un socio");
            cmbEligeLista.addItem("Listado de los socios con recargos pendientes");
        }catch (Exception e){
            e.printStackTrace();
        }

        cmbEligeLista.setBounds(100,100,350,50);
        panelPrincipal.add(cmbEligeLista);
        textoListas.setBounds(100,200,600,300);
        panelPrincipal.add(textoListas);

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
