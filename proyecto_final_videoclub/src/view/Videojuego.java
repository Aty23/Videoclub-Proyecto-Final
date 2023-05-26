package view;
import model.*;
public class Videojuego extends Multimedia{
    /**
     * atributos
     */
    private String plataforma;

    /**
     * constructor default
     */
    public Videojuego() {
        super();
        setPlataforma(Constantes.PLATAFORMA_DEFAULT);
    }

    /**
     * construcor por parámetros
     * @param titulo String
     * @param autor String
     * @param formato String
     * @param anyo int
     * @param plataforma String
     */
    public Videojuego(int id,String titulo, String autor, String formato, int anyo, String plataforma) {
        super(id, titulo, autor, formato, anyo);
        setPlataforma(plataforma);
    }

    /**
     * getters y setter
     *
     */
    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String platafotrma) {
        if(!platafotrma.equals("")){
            this.plataforma = platafotrma;
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
        return "Videojuego:\n" + super.toString() + "\nPlataforma: " + getPlataforma();
    }

}
