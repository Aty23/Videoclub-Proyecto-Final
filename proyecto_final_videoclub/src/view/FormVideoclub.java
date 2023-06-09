package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormVideoclub extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormVideoclub()throws HeadlessException {
        Color colorFondo=new Color(65,65,65);
        Color colorLetraBoton=new Color(255,255,255);
        Color colorheisen=new Color(255,255,255);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);
        Color colorButtons= new Color(82,82,82);
        Color colorLabel=new Color(255,255,255);

        JLabel videoclub = new JLabel(" Heisenberg's Club");
        videoclub.setForeground(colorheisen);
        JButton altas = new JButton("Altas");
        JButton alquilar = new JButton("Alquilar");
        JButton devolver = new JButton("Devolver");
        JButton listar = new JButton("Listar");

        videoclub.setBounds(340,100,250,50);
        videoclub.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(videoclub);
        altas.setBounds(300,200,250,35);
        altas.setBackground(colorButtons);
        altas.setForeground(colorLetraBoton);
        panelPrincipal.add(altas);
        alquilar.setBounds(300,300,250,35);
        alquilar.setBackground(colorButtons);
        alquilar.setForeground(colorLetraBoton);
        panelPrincipal.add(alquilar);
        devolver.setBounds(300,400,250,35);
        devolver.setBackground(colorButtons);
        devolver.setForeground(colorLetraBoton);
        panelPrincipal.add(devolver);
        listar.setBounds(300,500,250,34);
        listar.setBackground(colorButtons);
        listar.setForeground(colorLetraBoton);
        panelPrincipal.add(listar);



        altas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormAltas fA = new FormAltas();
                fA.setSize(800, 700);
                fA.setContentPane(fA.getPanelPrincipal());
                fA.setVisible(true);
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormListados fL = new FormListados();
                fL.setSize(800, 700);
                fL.setContentPane(fL.getPanelPrincipal());
                fL.setVisible(true);
            }
        });

        alquilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormAlquilar fAl = new FormAlquilar();
                fAl.setSize(800, 700);
                fAl.setContentPane(fAl.getPanelPrincipal());
                fAl.setVisible(true);
            }
        });
        devolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormDevolver fD = new FormDevolver();
                fD.setSize(800, 700);
                fD.setContentPane(fD.getPanelPrincipal());
                fD.setVisible(true);
            }
        });
    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}

