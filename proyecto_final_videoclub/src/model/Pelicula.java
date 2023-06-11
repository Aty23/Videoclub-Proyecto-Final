package model;

import java.util.Date;

public class Pelicula extends Multimedia {
    /**
     * atributos
     */
    private int duracion;
    private String actorPrincipal;
    private String actrizPrincipal;

    /**
     * cosntructor default
     */
    public Pelicula() {
        super();
        setDuracion(Constantes.DURACUION_DEFAULT);
        setActorPrincipal(Constantes.ACTOR_PRINCIPAL_DEFAULT);
        setActrizPrincipal(Constantes.ACTRIZ_PRINCIPAL_DEFAULT);
    }

    /**
     * costructor por parámetros
     * @param titulo String
     * @param autor String
     * @param formato String
     * @param anyo int
     * @param duracion int
     * @param actorPrincipal String
     * @param actrizPrincipal String
     */
    public Pelicula(String titulo, String autor, String formato, int anyo, Date diaAlquilado, int duracion, String actorPrincipal, String actrizPrincipal) {
        super(titulo, autor, formato, anyo, diaAlquilado);
        setDuracion(duracion);
        setActorPrincipal(actorPrincipal);
        setActrizPrincipal(actrizPrincipal);
    }

    /**
     * getters y setters
     *
     */

    public int getDuracion() {
        return  duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0 && duracion < 240) {
            this.duracion = duracion;
        } else {
            throw new RuntimeException("La película no puede durar menos de 0 minutos ni más de 240 minutos");
        }
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        if (!actorPrincipal.equals("")) {
            this.actorPrincipal = actorPrincipal;
        } else {
            throw new RuntimeException("No se ha introducido el actor principal");
        }
    }


    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    public void setActrizPrincipal(String actrizPrincipal) {
        if (!actrizPrincipal.equals("")) {
            this.actrizPrincipal = actrizPrincipal;
        } else {
            throw new RuntimeException("No se ha introducido la actriz principal");
        }
    }

    /**
     * override de toString
     * @return String
     */
    @Override
    public String toString() {
        return "Película:\n" + super.toString() + "\nDuración: " + getDuracion() +
                "\nActor principal: " + getActorPrincipal() + "\nAtriz principal: " + getActrizPrincipal();
    }
}
