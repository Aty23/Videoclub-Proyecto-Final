package view;
import model.*;

import java.util.ArrayList;

public class Disco extends Multimedia{
    /**
     * atributos
     */
    private int duracionDisco;
    private ArrayList<Cancion> canciones;

    /**
     * costructor default
     */

    public Disco() {
        super();
        setDuracionDisco();
        canciones = new ArrayList<>();
    }

    /**
     * costructor por parámetros
     * @param titulo String
     * @param autor String
     * @param formato String
     * @param anyo int
     * @param duracionDisco int
     * @param canciones ArrayList<Cancion>
     */
    public Disco(String titulo, String autor,String formato, int anyo, int duracionDisco, ArrayList<Cancion> canciones) {
        super(titulo, autor, formato, anyo);
        setDuracionDisco();
        setCanciones(canciones);
    }

    /**
     * getters y setters
     *
     */

    public int getDuracionDisco() {
        return duracionDisco;
    }

    public void setDuracionDisco() {
        int sumaTotalCanciones=0;
        for (int i=0;i<canciones.size();i++){
            sumaTotalCanciones += canciones.get(i).getDuracionSegundos();
        }
        this.duracionDisco=sumaTotalCanciones;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * método para añadir canciones
     * @param cancion Cancion
     */
    public void anyadirCanciones(Cancion cancion){
        canciones.add(cancion);
    }

    /**
     * metodo para devolver los toString de todas las canciones
     * @return String
     */
    String titulosCanciones(){
        String cancionesString="";
        for (int i=0;i< getCanciones().size();i++){
            cancionesString="-"+canciones.get(i).toString();
        }
        return cancionesString;
    }

    /**
     * Pasa la duracion en segundos a minutos
     * @return String
     */
    String duracionMinutos(){
        String duracionMinutos="";
        duracionMinutos = duracionMinutos +duracionDisco/60+ ":" + duracionDisco%60;

        return duracionMinutos;
    }

    /**
     * toString de disco
     * @return String
     */
    @Override
    public String toString() {
        return "\nDuracion Disco: " + duracionMinutos() +
               "\n Canciones:\n" + titulosCanciones();
    }
}
