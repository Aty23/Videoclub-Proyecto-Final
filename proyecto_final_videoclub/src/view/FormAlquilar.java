package view;

import control.ConexionBaseDatos;
import control.metodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormAlquilar extends JFrame {
    Color colorButtons = new Color(82, 82, 82);
    Color colorLetraBoton = new Color(255, 255, 255);
    private String dniBuscar;
    private int elementoAlquilado;
    private JList lstBuscarPeli;
    private JList lstBuscarVG;
    private JList lstBuscarDisc;
    private Color colorFondo = new Color(65, 65, 65);

    public JPanel panelPrincipal = new JPanel();
    private JComboBox cmbEligeMultimedia = new JComboBox<>();
    private JLabel dniLabel = new JLabel("Dni Cliente");

    private JTextField dniCliente = new JTextField();
    private JButton dniBtn = new JButton("Enviar");

    private JScrollPane scrollerMultimedia;
    private JTextField txtfldMulti;

    public FormAlquilar() throws HeadlessException {
        try {
            Color letradni = new Color(255, 255, 255);
            dniLabel.setForeground(letradni);
            dniBtn.setBackground(colorButtons);
            dniBtn.setForeground(colorLetraBoton);
            dniLabel.setBounds(0, 0, 100, 30);
            panelPrincipal.add(dniLabel);
            dniCliente.setBounds(0, 30, 100, 25);
            panelPrincipal.add(dniCliente);
            dniBtn.setBounds(100, 30, 75, 25);
            panelPrincipal.add(dniBtn);

            cmbEligeMultimedia.setBounds(100, 100, 350, 50);
            panelPrincipal.add(cmbEligeMultimedia);
            panelPrincipal.setLayout(null);
            panelPrincipal.setBackground(colorFondo);
            cmbEligeMultimedia.addItem("Elige uno");
            cmbEligeMultimedia.addItem("Películas");
            cmbEligeMultimedia.addItem("Discos");
            cmbEligeMultimedia.addItem("Videojuegos");

            /*txtfldMulti = new JTextField(20);
            txtfldMulti.setBounds(100, 200, 350, 30);
            txtfldMulti.setVisible(true);
            panelPrincipal.add(txtfldMulti);

           JButton btnBuscar = new JButton("Buscar");
            btnBuscar.setBackground(colorButtons);
            btnBuscar.setForeground(colorLetraBoton);
            btnBuscar.setBounds(500, 200, 100, 30);
            btnBuscar.setVisible(true);
            panelPrincipal.add(btnBuscar);*/

            JButton btnAlquilar = new JButton("Alquilar");
            btnAlquilar.setBackground(colorButtons);
            btnAlquilar.setForeground(colorLetraBoton);
            btnAlquilar.setBounds(500, 500, 100, 30);
            btnAlquilar.setVisible(true);
            panelPrincipal.add(btnAlquilar);

            JLabel lblAlquiler = new JLabel("El precio del alquiler es: ");
            Color letrAlquilar = new Color(255, 255, 255);
            lblAlquiler.setForeground(letrAlquilar);
            lblAlquiler.setBounds(100, 500, 300, 30);
            lblAlquiler.setVisible(true);
            panelPrincipal.add(lblAlquiler);

            scrollerMultimedia.setBounds(100, 300, 350, 200);
            scrollerMultimedia.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollerMultimedia.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            panelPrincipal.add(scrollerMultimedia);
            scrollerMultimedia.setVisible(true);

            DefaultListModel<Disco> modeloDisco = new DefaultListModel<>();

            for (int i = 0; i < ConexionBaseDatos.db.get(3).size(); i++) {
                modeloDisco.addElement((Disco) ConexionBaseDatos.db.get(3).get(i));
            }
            DefaultListModel<Videojuego> modeloVideojuego = new DefaultListModel<>();

            for (int i = 0; i < ConexionBaseDatos.db.get(3).size(); i++) {
                modeloVideojuego.addElement((Videojuego) ConexionBaseDatos.db.get(3).get(i));
            }
            DefaultListModel<Pelicula> modeloPelicula = new DefaultListModel<>();

            for (int i = 0; i < ConexionBaseDatos.db.get(3).size(); i++) {
                modeloPelicula.addElement((Pelicula) ConexionBaseDatos.db.get(3).get(i));
            }





            cmbEligeMultimedia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")) {
                            lstBuscarPeli = new JList<Pelicula>(modeloPelicula);
                            scrollerMultimedia = new JScrollPane(lstBuscarPeli);

                        } else if (cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")) {
                            lstBuscarDisc = new JList<Disco>(modeloDisco);
                            scrollerMultimedia = new JScrollPane(lstBuscarDisc);

                        } else if (cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")) {

                            lstBuscarVG = new JList<Videojuego>(modeloVideojuego);
                            scrollerMultimedia = new JScrollPane(lstBuscarVG);
                        }

                    } catch (Exception v) {
                        JOptionPane.showMessageDialog(null, "fallo buscar Multimedia");
                    }


                }
            });
            /*btnBuscar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //((Pelicula)ConexionBaseDatos.db.get(1).get(0)).getTitulo();
                    //casteo------clase base datos.array.array.objeto.metodo
                    if (txtfldMulti != null) {
                        lstBuscar = new JList<>(buscadorMultimedia(txtfldMulti.getText()));
                        panelPrincipal.add(lstBuscar);
                        lstBuscar.setVisibleRowCount(buscadorMultimedia(txtfldMulti.getText()).size());
                        lstBuscar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        elementoAlquilado = lstBuscar.getSelectedIndex();
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes introducuir un texto");
                    }


                }
            });*/
            btnAlquilar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dniBuscar != null) {
                        if (cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")) {
                            lblAlquiler.setText("El precio del alquiler es: " + metodos.alquilar(((Multimedia) lstBuscarPeli.getModel().getElementAt(elementoAlquilado)),
                                    metodos.buscarUsuario(dniBuscar)));

                        } else if (cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")) {
                            lblAlquiler.setText("El precio del alquiler es: " + metodos.alquilar(((Multimedia) lstBuscarDisc.getModel().getElementAt(elementoAlquilado)),
                                    metodos.buscarUsuario(dniBuscar)));

                        } else if (cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")) {

                            lblAlquiler.setText("El precio del alquiler es: " + metodos.alquilar(((Multimedia) lstBuscarVG.getModel().getElementAt(elementoAlquilado)),
                                    metodos.buscarUsuario(dniBuscar)));
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Debes introducir un DNI");
                    }
                }
            });

            dniBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    dniBuscar = dniCliente.getText();
                    Socio autenticado = metodos.buscarUsuario(dniBuscar);
                    if (dniBuscar != null) {
                        if (autenticado == null) {
                            JOptionPane.showMessageDialog(null, "DNI Incorrecto");

                        } else {
                            JOptionPane.showMessageDialog(null, "DNI Correcto");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes introducir un DNI");
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

   /* public DefaultListModel<Multimedia> buscadorMultimedia(String nombreMultimedia) {
        //ArrayList<Multimedia> resultado = new ArrayList<>();
        DefaultListModel<Multimedia> resultado = new DefaultListModel<>();

        try{
            if (cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")) {
                for (int i = 0; i < ConexionBaseDatos.db.size(); i++) {
                    if (((Pelicula) ConexionBaseDatos.db.get(2).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                        resultado.addElement(((Pelicula) ConexionBaseDatos.db.get(2).get(i)));
                    }
                }

            } else if (cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")) {
                for (int i = 0; i < ConexionBaseDatos.db.size(); i++) {
                    if (((Disco) ConexionBaseDatos.db.get(4).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                        resultado.addElement(((Disco) ConexionBaseDatos.db.get(4).get(i)));
                    }
                }
            } else if (cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")) {
                for (int i = 0; i < ConexionBaseDatos.db.size(); i++) {
                    if (((Videojuego) ConexionBaseDatos.db.get(1).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                        resultado.addElement(((Videojuego) ConexionBaseDatos.db.get(1).get(i)));
                    }
                }

            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "fallo buscar Multimedia");
        }
        return resultado;


    }*/

}
