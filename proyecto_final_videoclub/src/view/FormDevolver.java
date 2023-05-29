package view;

import javax.swing.*;
import java.awt.*;

public class FormDevolver extends JFrame{
    Color colorFondo=new Color(147,249,249);
    public JPanel panelPrincipal = new JPanel();
    public FormDevolver() throws HeadlessException{
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(colorFondo);

    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
