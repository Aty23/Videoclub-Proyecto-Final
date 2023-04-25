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
        setDuracionDisco(Constantes.DURACUION_DEFAULT);
        canciones = new ArrayList<>();
    }

    /**
     * costructor por parámetros
     * @param duracionDisco
     * @param canciones
     * @param titulo
     * @param autor
     * @param formato
     * @param anyo
     */
    public Disco(int duracionDisco, ArrayList<Cancion> canciones, String titulo, String autor, String formato, int anyo) {
        super(titulo, autor, formato, anyo);
        setDuracionDisco(duracionDisco);
        setCanciones(canciones);
    }

    /**
     * getters y setters
     * @return
     */

    public int getDuracionDisco() {
        return duracionDisco;
    }

    public void setDuracionDisco(int duracionDisco) {
        this.duracionDisco = duracionDisco;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * método para añadir canciones
     * @param cancion
     */
    public void anyadirCanciones(Cancion cancion){
        canciones.add(cancion);
    }
}
