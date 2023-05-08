package control;

import java.util.Scanner;

public class OperacionesMenu {

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
