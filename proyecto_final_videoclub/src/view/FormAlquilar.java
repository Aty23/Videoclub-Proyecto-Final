package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAlquilar extends JFrame {
    Color colorFondo=new Color(147,249,249);
    Color colorLetraBoton=new Color(37,52,124);
    Color colorheisen=new Color(37,52,124);
    Color colorButtons= new Color(255,255,255);
    JComboBox cmbEligeMultimedia = new JComboBox<>();

    JList lstDiscos = new JList<>();
    JList lstVideojuegos= new JList<>();

    public JPanel panelPrincipal = new JPanel();
    public FormAlquilar() throws HeadlessException{
        JLabel a=new JLabel("a");
        a.setBounds(500,500,200,200);
        panelPrincipal.add(a);
        a.setVisible(false);
        JLabel b=new JLabel("b");
        b.setBounds(500,500,200,200);
        panelPrincipal.add(b);
        b.setVisible(false);
        JLabel c=new JLabel("c");
        c.setBounds(500,500,200,200);
        panelPrincipal.add(c);
        c.setVisible(false);

        cmbEligeMultimedia.setBounds(100,100,350,50);
        panelPrincipal.add(cmbEligeMultimedia);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);

        JList lstPeliculas = new JList<>();
        lstPeliculas.setBounds(100,200,350,50);
        panelPrincipal.add(lstPeliculas);
        lstPeliculas.setVisible(false);
        lstPeliculas.setVisibleRowCount(10);
        lstPeliculas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollerPeliculas = new JScrollPane(lstPeliculas);
        scrollerPeliculas.setBounds(100,200,350,50);
        scrollerPeliculas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerPeliculas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollerPeliculas.setVisible(false);
        panelPrincipal.add(scrollerPeliculas);

        JList lstDiscos = new JList<>();
        lstDiscos.setBounds(100,200,350,50);
        panelPrincipal.add(lstDiscos);
        lstDiscos.setVisible(false);
        lstDiscos.setVisibleRowCount(10);
        lstDiscos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollerDiscos = new JScrollPane(lstPeliculas);
        scrollerDiscos.setBounds(100,200,350,50);
        scrollerDiscos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerDiscos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollerDiscos.setVisible(false);
        panelPrincipal.add(scrollerDiscos);

        JList lstVideojuegos= new JList<>();
        lstVideojuegos.setBounds(100,200,350,50);
        panelPrincipal.add(lstVideojuegos);
        lstVideojuegos.setVisible(false);
        lstVideojuegos.setVisibleRowCount(10);
        lstVideojuegos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollerVideojuegos = new JScrollPane(lstPeliculas);
        scrollerVideojuegos.setBounds(100,200,350,50);
        scrollerVideojuegos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerVideojuegos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollerVideojuegos.setVisible(false);
        panelPrincipal.add(scrollerVideojuegos);


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

                a.setVisible(true);
                b.setVisible(false);
                c.setVisible(false);

                lstPeliculas.setVisible(true);
                scrollerPeliculas.setVisible(true);
                lstDiscos.setVisible(false);
                scrollerDiscos.setVisible(false);
                lstVideojuegos.setVisible(false);
                scrollerVideojuegos.setVisible(false);

            }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")){

                a.setVisible(false);
                b.setVisible(true);
                c.setVisible(false);

                lstDiscos.setVisible(true);
                scrollerDiscos.setVisible(true);
                lstPeliculas.setVisible(false);
                scrollerPeliculas.setVisible(false);
                lstVideojuegos.setVisible(false);
                scrollerVideojuegos.setVisible(false);

            }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")){

                a.setVisible(false);
                b.setVisible(false);
                c.setVisible(true);

                lstVideojuegos.setVisible(true);
                scrollerVideojuegos.setVisible(true);
                lstPeliculas.setVisible(false);
                scrollerPeliculas.setVisible(false);
                lstDiscos.setVisible(false);
                scrollerDiscos.setVisible(false);

            }
        }
        });

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }

}
