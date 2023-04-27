package view;
import model.*;
public class Videojuego extends Multimedia{
    /**
     * atributos
     */
    private String platafotrma;

    /**
     * constructor default
     */
    public Videojuego() {
        super();
        setPlatafotrma(Constantes.PLATAFORMA_DEFAULT);
    }

    /**
     * construcor por parámetros
     * @param titulo String
     * @param autor String
     * @param formato String
     * @param anyo int
     * @param platafotrma String
     */
    public Videojuego(String titulo, String autor, String formato, int anyo, String platafotrma) {
        super(titulo, autor, formato, anyo);
        setPlatafotrma(platafotrma);
    }

    /**
     * getters y setter
     *
     */
    public String getPlatafotrma() {
        return platafotrma;
    }

    public void setPlatafotrma(String platafotrma) {
        if(!platafotrma.equals("")){
            this.platafotrma = platafotrma;
        }else{
            throw new RuntimeException("No se ha introducido la plataforma");
        }

    }

    /**
     * override de toString
     * @return String
     */
    @Override
    public String toString() {
        return "Videojuego:\n" + super.toString() + "\nPlataforma: " + getPlatafotrma();
    }
}
