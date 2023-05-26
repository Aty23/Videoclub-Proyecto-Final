package control;

import model.Constantes;
import view.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class metodos {
    public static int pagarAlquiler(Multimedia multimedia){
        int pagoAlquiler= Constantes.PRECIO_BASE_ALQUILER;
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
        return pagoAlquiler;

    }
    public static int alquilar(Multimedia multimedia, Socio socio){
        Date hoy = new Date();
        socio.getMultimediaAlquilado().add(multimedia);
        multimedia.setDiaAlquilado(hoy);
        return  pagarAlquiler(multimedia);
    }
    public static int devolverMultimedia(Multimedia multimedia,Socio socio){
       for(int i=0; i<socio.getMultimediaAlquilado().size();i++){
           if(socio.getMultimediaAlquilado().get(i).getId()== multimedia.getId()){
               socio.getMultimediaAlquilado().remove(multimedia);
           }
       }
       return recargoRetraso(multimedia);
    }
   public static int recargoRetraso(Multimedia multimedia){
        int recargo;
        Date hoy = new Date();
        long diferenciaMilisec= hoy.getTime()-multimedia.getDiaAlquilado().getTime();
        long diferenciaDias= TimeUnit.MILLISECONDS.toDays(diferenciaMilisec);
        recargo=(int) (diferenciaDias-3)*2;

       return recargo;
    }
}
