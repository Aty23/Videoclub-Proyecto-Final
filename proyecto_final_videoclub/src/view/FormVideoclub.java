package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

public class FormVideoclub extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormVideoclub()throws HeadlessException {
        Color colorFondo=new Color(147,249,249);
        Color colorLetraBoton=new Color(37,52,124);
        Color colorheisen=new Color(37,52,124);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);
        Color colorButtons= new Color(255,255,255);
        JMenuBar barra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem cargarCategorias = new JMenuItem("Cargar categorias");
        JMenuItem salir = new JMenuItem("Salir");
        // JTextArea infoCategorias = new JTextArea();
        Color colorLabel=new Color(255,255,255);

        JLabel videoclub = new JLabel(" Heisenberg's Club");
        videoclub.setForeground(colorheisen);
        JButton altas = new JButton("Altas");
        JButton alquilar = new JButton("Alquilar");
        JButton devolver = new JButton("Devolver");
        JButton listar = new JButton("Listar");

        this.setJMenuBar(barra);
        barra.add(archivo);
        archivo.add(cargarCategorias);
        archivo.add(salir);
        // panelPrincipal.add(infoCategorias);
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
                fA.setSize(900, 700);
                fA.setContentPane(fA.getPanelPrincipal());
                fA.setVisible(true);
            }
        });

        /*setInfoCategorias();
        setCargarCategorias();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSalir();
        setArchivo();
        setBarra();
        setPanelPrincipal();*/

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}

