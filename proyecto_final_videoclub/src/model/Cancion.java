package model;
import model.*;
public class Cancion{
    /**
     * atributos
     */
    private String nombre;
    private int duracionSegundos;

    /**
     * constructor default
     */
    public Cancion() {
        setNombre(Constantes.NOMBRE_DEFAULT);
        setDuracionSegundos(Constantes.DURACUION_DEFAULT);
    }

    /**
     * constructor por parámetros
     * @param nombre String
     * @param duracionSegundos int
     */
    public Cancion(String nombre, int duracionSegundos) {
        setNombre(nombre);
        setDuracionSegundos(duracionSegundos);
    }

    /**
     * getters y setters
     *
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }
    /**
     * Pasa la duracion en segundos a minutos
     * @return String
     */
    private String duracionMinutos(){
        String duracionMinutos="";
        duracionMinutos = duracionMinutos +duracionSegundos/60+ ":" + duracionSegundos%60 + "\n";

        return duracionMinutos;
    }
    /**
     * toString de cancion
     * @return String
     */
    @Override
    public String toString() {
        return  nombre + "\t" +duracionMinutos() + " min";
    }
}
