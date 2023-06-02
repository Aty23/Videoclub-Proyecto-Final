package view;

import control.ConexionBaseDatos;
import control.metodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormAlquilar extends JFrame {
    private String dniBuscar;
    private int elementoAlquilado;
    private JList lstBuscar;
    private Color colorFondo=new Color(147,249,249);

    public JPanel panelPrincipal = new JPanel();
    private JComboBox cmbEligeMultimedia = new JComboBox<>();
    private JLabel dniLabel = new JLabel("Dni Cliente");
    private JTextField dniCliente = new JTextField();
    private JButton dniBtn = new JButton("Enviar");

    public FormAlquilar() throws HeadlessException{
        dniLabel.setBounds(0,0,100,30);
        panelPrincipal.add(dniLabel);
        dniCliente.setBounds(0,30,100,25);
        panelPrincipal.add(dniCliente);
        dniBtn.setBounds(100,30,75,25);
        panelPrincipal.add(dniBtn);

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

        JLabel lblAlquiler = new JLabel("El precio del alquiler es: ");
        lblAlquiler.setBounds(100,500,100,30);
        lblAlquiler.setVisible(true);
        panelPrincipal.add(lblAlquiler);








        try{
            cmbEligeMultimedia.addItem("Elige uno");
            cmbEligeMultimedia.addItem("Películas");
            cmbEligeMultimedia.addItem("Discos");
            cmbEligeMultimedia.addItem("Videojuegos");

        }catch (Exception e){
            e.printStackTrace();
        }
        btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //((Pelicula)ConexionBaseDatos.db.get(1).get(0)).getTitulo();
                //casteo------clase base datos.array.array.objeto.metodo
                lstBuscar = new JList<>((ListModel) buscadorMultimedia(txtfldMulti.getText()));
                panelPrincipal.add(lstBuscar);
                lstBuscar.setVisibleRowCount(buscadorMultimedia(txtfldMulti.getText()).size());
                lstBuscar.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                JScrollPane scrollerPeliculas = new JScrollPane(lstBuscar);
                scrollerPeliculas.setBounds(100,300,350,100);
                scrollerPeliculas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollerPeliculas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                panelPrincipal.add(scrollerPeliculas);
                scrollerPeliculas.setVisible(true);
                elementoAlquilado= lstBuscar.getSelectedIndex();

            }
        });
        btnAlquilar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = dniCliente.getText();
                lblAlquiler.setText("El precio del alquiler es: "+metodos.alquilar(((Multimedia) lstBuscar.getModel().getElementAt(elementoAlquilado)),metodos.buscarUsuario(dniBuscar)));
            }
        });

        dniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               dniBuscar = dniCliente.getText();
                Socio autenticado = metodos.buscarUsuario(dniBuscar);

                if (autenticado==null) {
                    JOptionPane.showMessageDialog(null, "Incorrecto");

                } else {
                    JOptionPane.showMessageDialog(null, "Correcto");
                }
            }
        });




    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
    public ArrayList<Multimedia> buscadorMultimedia(String nombreMultimedia){
        ArrayList<Multimedia> resultado = new ArrayList<>();
        if(cmbEligeMultimedia.getSelectedItem().toString().equals("Películas")){
            for (int i=0;i<ConexionBaseDatos.db.size();i++) {
                if (((Pelicula)ConexionBaseDatos.db.get(2).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                    resultado.add(((Pelicula)ConexionBaseDatos.db.get(2).get(i)));
                }
            }

        }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Discos")){
            for (int i=0;i<ConexionBaseDatos.db.size();i++) {
                if (((Disco)ConexionBaseDatos.db.get(4).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                    resultado.add(((Disco)ConexionBaseDatos.db.get(4).get(i)));
                }
            }
        }else if(cmbEligeMultimedia.getSelectedItem().toString().equals("Videojuegos")){
            for (int i=0;i<ConexionBaseDatos.db.size();i++) {
                if (((Videojuego)ConexionBaseDatos.db.get(1).get(i)).getTitulo().toLowerCase().contains(nombreMultimedia.toLowerCase())) {
                    resultado.add(((Videojuego)ConexionBaseDatos.db.get(1).get(i)));
                }
            }

        }

        return resultado;
    }

}
