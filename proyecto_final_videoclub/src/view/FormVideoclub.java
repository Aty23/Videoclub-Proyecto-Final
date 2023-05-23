package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

public class FormVideoclub extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormVideoclub()throws HeadlessException {
        panelPrincipal.setLayout(null);
        JMenuBar barra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem cargarCategorias = new JMenuItem("Cargar categorias");
        JMenuItem salir = new JMenuItem("Salir");
        // JTextArea infoCategorias = new JTextArea();
        JLabel videoclub = new JLabel("Bienvenido al videoclub");
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
        altas.setBounds(400,200,100,50);
        panelPrincipal.add(altas);
        alquilar.setBounds(400,300,100,50);
        panelPrincipal.add(alquilar);
        devolver.setBounds(400,400,100,50);
        panelPrincipal.add(devolver);
        listar.setBounds(400,500,100,50);
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

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormListados fL = new FormListados();
                fL.setSize(900, 700);
                fL.setContentPane(fL.getPanelPrincipal());
                fL.setVisible(true);
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

