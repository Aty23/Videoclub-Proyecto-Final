package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class FormAlquilar extends JFrame {
    Color colorFondo=new Color(147,249,249);
    public JPanel panelPrincipal = new JPanel();
    public FormAlquilar() throws HeadlessException{
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }

}
