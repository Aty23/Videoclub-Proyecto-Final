package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Multimedia {
    /**
     * atributos
     */
    private String titulo;
    private String autor;
    private String formato;
    private int anyo;
    private Date diaAlquilado;



    /**
     * constructor default
     */
    public Multimedia(){
        setTitulo(Constantes.TITULO_DEFAULT);
        setAutor(Constantes.AUTOR_DEFAULT);
        setFormato(Constantes.FORMATO_DEFAULT);
        setAnyo(Constantes.ANYO_DEFAULT);
    }

    /**
     * constructor por parámetros
     * @param titulo String
     * @param autor String
     * @param formato String
     * @param anyo int
     */

    public Multimedia( String titulo, String autor, String formato, int anyo, Date diaAlquilado) {
        setTitulo(titulo);
        setAutor(autor);
        setFormato(formato);
        setAnyo(anyo);
        //setNoAlquilado();
        setDiaAlquilado(diaAlquilado);
    }



    /**
     * getters y setters
     *
     */
    public void setNoAlquilado(){
        this.diaAlquilado=null;
    }
    public void setDiaAlquilado(Date diaAlquilado) {
        this.diaAlquilado = diaAlquilado;

    }
    public Date getDiaAlquilado() throws ParseException {
        if(this.diaAlquilado==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDefault = format.parse("1960-01-01");
            return dateDefault;
        }
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
                formato.equals(ListaFormatos.BLURAY.toString())||formato.equals(ListaFormatos.ARCHIVO.toString())||
                formato.equals(ListaFormatos.cd.toString())||formato.equals(ListaFormatos.dvd.toString())||
                formato.equals(ListaFormatos.bluray.toString())||formato.equals(ListaFormatos.archivo.toString())){
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

