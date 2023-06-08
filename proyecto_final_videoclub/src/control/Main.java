package control;


import view.*;

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
            FormVideoclub w = new FormVideoclub();
            w.setSize(900, 700);
            w.setContentPane(w.getPanelPrincipal());
            w.setVisible(true);
            w.setDefaultCloseOperation(EXIT_ON_CLOSE);
            if(w.getDefaultCloseOperation()==3){
                ConexionBaseDatos.modificarBD(ConexionBaseDatos.db);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}