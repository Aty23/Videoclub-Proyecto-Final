package view;

import control.ConexionBaseDatos;
import model.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDevolver extends JFrame {
    private Color letradni = new Color(255, 255, 255);
    private Color colorLetraBoton = new Color(255, 255, 255);
    private Color colorButtons = new Color(82, 82, 82);
    private Color colorDevolver = new Color(255, 255, 255);
    private String dniBuscar;
    private int elementoDevolver;
    private JComboBox cmbEligeMultimedia = new JComboBox<>();

    Color colorFondo = new Color(65, 65, 65);
    public JPanel panelPrincipal = new JPanel();
    private JScrollPane scrollerDevolver;
    private JList lstDevolver;


    public FormDevolver() throws HeadlessException {
        try {
            panelPrincipal.setLayout(null);
            panelPrincipal.setBackground(colorFondo);
            //label  dni
            JLabel dniLabel = new JLabel("Dni Cliente");
            dniLabel.setForeground(letradni);
            dniLabel.setBounds(0, 0, 100, 30);
            panelPrincipal.add(dniLabel);
            //textfield dni
            JTextField dniCliente = new JTextField();
            dniCliente.setBounds(0, 30, 100, 25);
            panelPrincipal.add(dniCliente);
            //boton dni
            JButton dniBtn = new JButton("Enviar");
            dniBtn.setBackground(colorButtons);
            dniBtn.setForeground(colorLetraBoton);
            dniBtn.setBounds(100, 30, 75, 25);
            panelPrincipal.add(dniBtn);
            //lbl devolver
            JLabel Devolver = new JLabel("Articulos alquilados ");
            Devolver.setForeground(colorDevolver);
            Devolver.setBounds(300, 100, 300, 50);
            Devolver.setFont(new Font("Arial", Font.BOLD, 20));
            panelPrincipal.add(Devolver);
            //lista
            lstDevolver=new JList<>();
            //scroller
            scrollerDevolver= new JScrollPane(lstDevolver);//((Socio)ConexionBaseDatos.db.get(0).get(1)).get));
            scrollerDevolver.setBounds(230, 150, 350, 100);
            scrollerDevolver.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollerDevolver.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            panelPrincipal.add(scrollerDevolver);
            scrollerDevolver.setVisible(true);
            //boton devolver
            JButton btnDevolver = new JButton("Devolver");
            btnDevolver.setForeground(colorLetraBoton);
            btnDevolver.setBackground(colorButtons);
            btnDevolver.setBounds(330, 300, 100, 30);
            btnDevolver.setVisible(true);
            panelPrincipal.add(btnDevolver);
            //modelo
            DefaultListModel<Multimedia> modeloMultimedia = new DefaultListModel<>();


            dniBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dniBuscar = dniCliente.getText();
                    Socio autenticado = tools.buscarUsuario(dniBuscar);
                    if (dniBuscar != null) {

                        if (autenticado == null) {
                            JOptionPane.showMessageDialog(null, "Incorrecto");

                        } else {
                            JOptionPane.showMessageDialog(null, "Correcto");
                            for (int j = 0; j < autenticado.getMultimediaAlquilado().size(); j++) {
                                modeloMultimedia.addElement(tools.buscarUsuario(dniBuscar).getMultimediaAlquilado().get(j));

                            }
                            lstDevolver.setModel(modeloMultimedia);
                            System.out.println(lstDevolver);
                            System.out.println(modeloMultimedia);
                        }



                    } else {
                        JOptionPane.showMessageDialog(null, "Introduzca dni");
                    }
                }
            });
            btnDevolver.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        elementoDevolver = lstDevolver.getSelectedIndex();//lstDevolver es null
                        try{
                            JLabel Precio = new JLabel("Recargo" + tools.devolverMultimedia(((Multimedia) lstDevolver.getModel().getElementAt(elementoDevolver)), tools.buscarUsuario(dniBuscar)));
                            Precio.setForeground(colorDevolver);
                            Precio.setBounds(300, 500, 300, 50);
                            Precio.setFont(new Font("Arial", Font.BOLD, 20));
                            panelPrincipal.add(Precio);
                            Precio.setVisible(true);
                        }catch (Exception e1){
                            JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento");
                        }
                    } catch (Exception p) {
                        p.printStackTrace();
                    }


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
