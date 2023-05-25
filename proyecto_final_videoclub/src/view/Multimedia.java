package view;
import model.*;

import java.util.Date;

public abstract class Multimedia {
    /**
     * atributos
     */
    private int idMultimedia=0;
    private String titulo;
    private String autor;
    private String formato;
    private int anyo;
    private Date diaAlquilado;

    public void setDiaAlquilado(Date diaAlquilado) {
        this.diaAlquilado = diaAlquilado;
    }

    /**
     * constructor default
     */
    public Multimedia(){
        setTitulo(Constantes.TITULO_DEFAULT);
        setAutor(Constantes.AUTOR_DEFAULT);
        setFormato(Constantes.FORMATO_DEFAULT);
        setAnyo(Constantes.ANYO_DEFAULT);
        idMultimedia++;
    }

    /**
     * constructor por parámetros
     * @param titulo String
     * @param autor String
     * @param formato String
     * @param anyo int
     */

    public Multimedia(String titulo, String autor, String formato, int anyo) {
        setTitulo(titulo);
        setAutor(autor);
        setFormato(formato);
        setAnyo(anyo);
    }



    /**
     * getters y setters
     *
     */
    public int getIdMultimedia() {
        return idMultimedia;
    }

    public Date getDiaAlquilado() {
        return diaAlquilado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(!titulo.equals("")) {
            this.titulo = titulo;
        }else{
            throw new RuntimeException("No se ha introducido el título");
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(!autor.equals("")) {
            this.autor = autor;
        }else{
            throw new RuntimeException("No se ha introducido el autor");
        }
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        if(formato.equals(ListaFormatos.CD.toString())||formato.equals(ListaFormatos.DVD.toString())||
                formato.equals(ListaFormatos.BLUERAY.toString())||formato.equals(ListaFormatos.ARCHIVO.toString())){
            this.formato = formato;
        }else{
            throw new RuntimeException("El formato introducido no está entre los aceptados");
        }

    }
    public int getAnyo() {
        return anyo;
    }
    public void setAnyo(int anyo) {
        if(anyo>=1895&&anyo<=2023){
            this.anyo = anyo;
        }else{
            throw new RuntimeException("El año debe estar entre 1895 y 2023");
        }

    }

    /**
     * override de toString
     * @return String
     */
    @Override
    public String toString() {
        return "Título: " + getTitulo() + "\nAutor: " + getAutor() +
                "\nFormato: " + getFormato() + "\nAño: " + getAnyo();
    }

    /**
     * metodo equals propio de la clase para comparar el autor y el título
     * @param multimedia2 Multimedia
     * @return boolean
     */
    public boolean equals(Multimedia multimedia2) {
        if(getTitulo().equals(multimedia2.getTitulo())&&getAutor().equals(multimedia2.getAutor())) {
            return true;
        }
        return false;
    }
}

