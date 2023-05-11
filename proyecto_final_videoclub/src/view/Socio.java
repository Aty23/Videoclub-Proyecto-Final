package view;
import model.*;

import javax.swing.plaf.PanelUI;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Socio {
    /**
     * atributos
     */
    private String nif;
    private String nombre;
    private int anyoNacimiento;
    private String poblacion;
    private boolean alquilando;
    private Date diaAlquilado;

    /**
     * constructor default
     */
    public  Socio(){
        setNif(Constantes.NIF_DEFAULT);
        setNombre(Constantes.NOMBRE_DEFAULT);
        setAnyoNacimiento(Constantes.ANYO_NACIMIENTO_DEFAULT);
        setPoblacion(Constantes.POBLACION_DEFAULT);
        setAlquilando(Constantes.ALQUILANDO_DEFAULT);
        setDiaAlquilado(Constantes.FECHA_DEFAULT);


    }

    /**
     * constructor por parámetros
     * @param nif String
     * @param nombre String
     * @param anyoNacimiento  int
     * @param poblacion String
     * @param alquilando boolean
     * @param diaAlquilado Date
     */

    public Socio(String nif, String nombre, int anyoNacimiento, String poblacion, boolean alquilando, Date diaAlquilado) {
        setNif(nif);
        setNombre(nombre);
        setAnyoNacimiento(anyoNacimiento);
        setPoblacion(poblacion);
        setAlquilando(alquilando);
        setDiaAlquilado(diaAlquilado);
    }

    /**
     * getters y setters
     *
     */

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.equals("")){
            this.nombre = nombre;
        }else{
            throw new RuntimeException("No se ha introducido el nombre");
        }
    }

    public int getFechaNacimiento() {
        return anyoNacimiento;
    }

    public void setAnyoNacimiento(int anyoNacimiento) {
        if(anyoNacimiento<=2005&&anyoNacimiento>=1907){
            this.anyoNacimiento = anyoNacimiento;
        }else{
            throw new RuntimeException("Año de nacimiento no valido");
        }

    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        if(!poblacion.equals("")) {
            this.poblacion = poblacion;
        }else{
            throw new RuntimeException("Población no introducida");
        }
    }

    public boolean isAlquilando() {
        return alquilando;
    }

    public void setAlquilando(boolean alquilando) {
        this.alquilando = alquilando;
    }

    public Date getDiaAlquilado() {
        return diaAlquilado;
    }

    public void setDiaAlquilado(Date diaAlquilado) {
        if(alquilando==true) {
            diaAlquilado = new Date();
        }
    }

    /**
     * controla si hay un alquiler activo
     *
     */
    public void alquilerPelicula(){
        if(!alquilando){
            setAlquilando(true);
        }

    }
    public void pagarAlquiler(Multimedia multimedia){
        int pagoAlquiler=Constantes.PRECIO_BASE_ALQUILER;
        if(multimedia instanceof Disco && ((Disco) multimedia).getDuracionDisco()<Constantes.DURACION_DISCO_DESCUENTO){
            pagoAlquiler -= Constantes.DESCUENTO;
        }
        else if(multimedia instanceof Pelicula && ((Pelicula)multimedia).getAnyo()<Constantes.ANYO_DESCUENTO_PELICULA){
            pagoAlquiler -= Constantes.DESCUENTO;
        }
        else if(multimedia instanceof Videojuego && ((Videojuego) multimedia).getAnyo()<Constantes.ANYO_DESCUENTO_VIDEOJUEGO){
            pagoAlquiler -= Constantes.DESCUENTO;
        }
        else if((multimedia instanceof Pelicula ||multimedia instanceof Videojuego) && multimedia.getAnyo()==2023){
            pagoAlquiler+=Constantes.PAGO_EXTRA_VIDEOJUEGOS_PELICULAS_2023;
        }

    }

    /**
     * Calcula el valor del recargo por retraso y devuelve el valor.
     * @param multimedia
     * @return int
     */
    public int recargoRetraso(Multimedia multimedia){
        int recargo;
        Date hoy = new Date();
        Date fechaAlquiler = new Date(123,1,8);


        long diferenciaMilisec= hoy.getTime()-diaAlquilado.getTime();
        long diferenciaDias= TimeUnit.MILLISECONDS.toDays(diferenciaMilisec);
        recargo= (int) (diferenciaDias-3)*2;
        System.out.println(diferenciaDias);
        return recargo;

    }
}
