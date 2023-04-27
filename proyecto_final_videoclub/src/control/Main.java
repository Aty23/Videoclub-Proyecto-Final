package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.*;
import view.*;

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
        Date A = new Date();
        System.out.println(A);
        ArrayList<Multimedia> multimedias= new ArrayList<Multimedia>();
        ArrayList<Socio> socios= new ArrayList<Socio>();
        Scanner sc= new Scanner(System.in);
        System.out.println(OperacionesMenu.textoMenu());
        switch (OperacionesMenu.selectMenu(sc)){

        }
    }





}