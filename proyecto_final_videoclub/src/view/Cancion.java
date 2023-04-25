package view;
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
     * @param nombre
     * @param duracionSegundos
     */
    public Cancion(String nombre, int duracionSegundos) {
        setNombre(nombre);
        setDuracionSegundos(duracionSegundos);
    }

    /**
     * getters y setters
     * @return
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
}
