package control;


import model.Pelicula;
import model.Socio;
import view.*;

import javax.management.loading.PrivateMLet;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Main {
    /**
     * main
     * @param args
     */

    public static void main(String[] args) {


        try{
            ConexionBaseDatos.db=ConexionBaseDatos.conexionBase();
  //          System.out.println(((Socio)ConexionBaseDatos.db.get(0).get(0)).getMultimediaAlquilado().get(0).getTitulo());
            System.out.println(((Pelicula)ConexionBaseDatos.db.get(2).get(0)).getDiaAlquilado().getTime());
            System.out.println(((Socio)ConexionBaseDatos.db.get(0).get(0)).getNif());
            System.out.println(((Socio)ConexionBaseDatos.db.get(0).get(0)).getMultimediaAlquilado());
            FormVideoclub w = new FormVideoclub();
            w.setSize(900, 700);
            w.setContentPane(w.getPanelPrincipal());
            w.setVisible(true);
            w.setDefaultCloseOperation(EXIT_ON_CLOSE);
            w.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    ConexionBaseDatos.modificarBD(ConexionBaseDatos.db);
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}