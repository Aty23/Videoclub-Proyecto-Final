package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;

import control.ConexionBaseDatos;

public class FormVideoclub extends JFrame{
    public JPanel panelPrincipal = new JPanel();

    public FormVideoclub()throws HeadlessException {
        Color colorFondo=new Color(65,65,65);
        Color colorLetraBoton=new Color(255,255,255);
        Color colorheisen=new Color(255,255,255);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);
        Color colorButtons= new Color(82,82,82);
        JMenuBar barra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem cargarCategorias = new JMenuItem("Cargar categorias");
        JMenuItem salir = new JMenuItem("Salir");
        Color colorLabel=new Color(255,255,255);

        JLabel videoclub = new JLabel(" Heisenberg's Club");
        videoclub.setForeground(colorheisen);
        JButton altas = new JButton("Altas");
        JButton alquilar = new JButton("Alquilar");
        JButton devolver = new JButton("Devolver");
        JButton listar = new JButton("Listar");

        JLabel dniLabel = new JLabel("Dni Cliente");
        JTextField dniCliente = new JTextField();
        JButton dniBtn = new JButton("Enviar");

        this.setJMenuBar(barra);
        barra.add(archivo);
        archivo.add(cargarCategorias);
        archivo.add(salir);

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

        dniLabel.setBounds(0,0,100,30);
        panelPrincipal.add(dniLabel);
        dniCliente.setBounds(0,30,100,25);
        panelPrincipal.add(dniCliente);
        dniBtn.setBounds(100,30,75,25);
        panelPrincipal.add(dniBtn);

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

        /* Action Listener provisional */
        dniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dni = dniCliente.getText();
                boolean autenticado = autenticarUsuario(dni);

                if (autenticado) {
                    JOptionPane.showMessageDialog(null, "Correcto");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrecto");
                }
            }
        });


    }

    /* Metodo provisional */
    public boolean autenticarUsuario(String dni) {
        for (int i = 0; i < ConexionBaseDatos.db.get(0).size(); i++){
            if (((Socio)ConexionBaseDatos.db.get(0).get(i)).getNif().equals(dni)){
                return true;
            }
        }
        return false;
    }


    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}

