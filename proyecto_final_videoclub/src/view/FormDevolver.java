package view;

import control.ConexionBaseDatos;
import control.metodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDevolver extends JFrame{
    private String dniBuscar ;
    private int elementoDevolver;
    private JList lstDevolver ;
    Color colorFondo=new Color(65,65,65);
    public JPanel panelPrincipal = new JPanel();
    public FormDevolver() throws HeadlessException{

        JLabel dniLabel = new JLabel("Dni Cliente");
        JTextField dniCliente = new JTextField();
        JButton dniBtn = new JButton("Enviar");
        ConexionBaseDatos cb=new ConexionBaseDatos();

        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);
        Color colorDevolver=new Color(255,255,255);

        JLabel Devolver = new JLabel("Articulos alquilados ");
        Devolver.setForeground(colorDevolver);
        Devolver.setBounds(300,100,300,50);
        Devolver.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(Devolver);

        JScrollPane scrollerDevolver= new JScrollPane();//((Socio)ConexionBaseDatos.db.get(0).get(1)).get));
        scrollerDevolver.setBounds(230,150,350,100);
        scrollerDevolver.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerDevolver.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelPrincipal.add(scrollerDevolver);
        scrollerDevolver.setVisible(true);

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(330,300,100,30);
        btnDevolver.setVisible(true);
        panelPrincipal.add(btnDevolver);

        dniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dniBuscar= dniCliente.getText();
                Socio autenticado = metodos.buscarUsuario(dniBuscar);

                if (autenticado==null) {
                    JOptionPane.showMessageDialog(null, "Incorrecto");

                } else {
                    JOptionPane.showMessageDialog(null, "Correcto");
                    lstDevolver = new JList<>((ListModel) autenticado.getMultimediaAlquilado());
                    panelPrincipal.add(lstDevolver);
                    lstDevolver.setVisibleRowCount(autenticado.getMultimediaAlquilado().size());
                    lstDevolver.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                    JScrollPane scrollerDevolver= new JScrollPane(lstDevolver);//((Socio)ConexionBaseDatos.db.get(0).get(1)).get));
                    scrollerDevolver.setBounds(230,150,350,100);
                    scrollerDevolver.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollerDevolver.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    panelPrincipal.add(scrollerDevolver);
                    scrollerDevolver.setVisible(true);


                }
            }
        });
        dniBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementoDevolver=lstDevolver.getSelectedIndex();
                JLabel Precio = new JLabel("Recargo"+metodos.devolverMultimedia(((Multimedia)lstDevolver.getModel().getElementAt(elementoDevolver)),metodos.buscarUsuario(dniBuscar)));
                Precio.setForeground(colorDevolver);
                Precio.setBounds(300,500,300,50);
                Precio.setFont(new Font("Arial", Font.BOLD, 20));
                panelPrincipal.add(Precio);




            }
        });






    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
