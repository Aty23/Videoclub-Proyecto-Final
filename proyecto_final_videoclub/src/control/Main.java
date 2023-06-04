package control;

import java.util.ArrayList;
import java.util.Date;

import view.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Esto es una ayuda para utilizar el JavaDoc:
 * Si poneis /** (como está puesto al principio de cada comentario del javadoc) se pone automáticamente
 * y se deja una linea para que escribais la explicación de lo que haya debajo (métodos, getters y setters, atributos...)
 */
public class Main {
    /**
     * main
     * @param args
     */

    public static void main(String[] args) {
        ConexionBaseDatos.db=ConexionBaseDatos.conexionBase();
        try{
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