package control;

import java.util.ArrayList;
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
        ArrayList<Multimedia> multimedias= new ArrayList<Multimedia>();
        ArrayList<Socio> socios= new ArrayList<Socio>();
        Scanner sc= new Scanner(System.in);
        System.out.println(textoMenu());
        switch (selectMenu(sc)){

        }
    }

    /**
     * método que devuelve el menú
     * @return
     */
    public static String textoMenu(){
        return "1. Altas\n2. Alquilar multimeda a socio\n3. Devolver multimedia\n4. Listados\n0. Salir del programa";
    }

    /**
     * método para que se introduzca el selector para el switch (segúramente borraremos este método,
     * porque tenemos que hacer esto en la interfaz gráfica
     * @param sc
     * @return
     */
    public static int selectMenu(Scanner sc){
        int select=-1;
        do {
            try {
                select = sc.nextInt();
                if(select<0||select>4){
                    System.out.println("Indroduzca un valor entre el 0 y el 4");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Valor introducido no numérico");
            } finally {
                sc.nextLine();
            }
        }while (select<0||select>4);
        return select;

    }
}