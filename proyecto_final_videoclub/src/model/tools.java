package model;

import control.ConexionBaseDatos;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class tools {
    public static int pagarAlquiler(Multimedia multimedia) {
        int pagoAlquiler = Constantes.PRECIO_BASE_ALQUILER;
        if (multimedia instanceof Disco && ((Disco) multimedia).getDuracionDisco() < Constantes.DURACION_DISCO_DESCUENTO) {
            pagoAlquiler -= Constantes.DESCUENTO;
        } else if (multimedia instanceof Pelicula && ((Pelicula) multimedia).getAnyo() < Constantes.ANYO_DESCUENTO_PELICULA) {
            pagoAlquiler -= Constantes.DESCUENTO;
        } else if (multimedia instanceof Videojuego && ((Videojuego) multimedia).getAnyo() < Constantes.ANYO_DESCUENTO_VIDEOJUEGO) {
            pagoAlquiler -= Constantes.DESCUENTO;
        } else if ((multimedia instanceof Pelicula || multimedia instanceof Videojuego) && multimedia.getAnyo() == 2023) {
            pagoAlquiler += Constantes.PAGO_EXTRA_VIDEOJUEGOS_PELICULAS_2023;
        }
        return pagoAlquiler;

    }

    public static int alquilar(Multimedia multimedia, Socio socio) {
        Date hoy = new Date();
        Multimedia multimediaSeleccionado=comararMultimedia(multimedia);
        socio.getMultimediaAlquilado().add(multimediaSeleccionado);
        System.out.println(socio.getNif());
        multimediaSeleccionado.setDiaAlquilado(hoy);
        return pagarAlquiler(multimediaSeleccionado);
    }

    public static int devolverMultimedia(Multimedia multimedia, Socio socio) throws ParseException {
        for (int i = 0; i < socio.getMultimediaAlquilado().size(); i++) {
            if (socio.getMultimediaAlquilado().get(i).getTitulo().equals(multimedia.getTitulo())) {
                socio.getMultimediaAlquilado().remove(i);
                if (multimedia instanceof Disco) {
                    (ConexionBaseDatos.db.get(4)).add(multimedia);
                } else if (multimedia instanceof Pelicula) {
                    (ConexionBaseDatos.db.get(2)).add(multimedia);
                } else if (multimedia instanceof Videojuego) {
                    (ConexionBaseDatos.db.get(1)).add(multimedia);
                }
            }
        }
        return recargoRetraso(multimedia);
    }

    public static int recargoRetraso(Multimedia multimedia) throws ParseException {
        int recargo = 0;
        Date hoy = new Date();
        long diferenciaMilisec = hoy.getTime() - multimedia.getDiaAlquilado().getTime();
        long diferenciaDias = TimeUnit.MILLISECONDS.toDays(diferenciaMilisec);
        if (diferenciaDias > 3) {
            recargo = (int) (diferenciaDias - 3) * 2;
        }


        return recargo;
    }

    public static Socio buscarUsuario(String dni) {
        if (dni != null) {
            for (int i = 0; i < ConexionBaseDatos.db.get(0).size(); i++) {
                if (((Socio) ConexionBaseDatos.db.get(0).get(i)).getNif().equals(dni)) {
                    return ((Socio) ConexionBaseDatos.db.get(0).get(i));
                }
            }
        } else System.out.println("El dni es null");
        return null;
    }

    public static Multimedia comararMultimedia(Multimedia multimedia) {
        ArrayList<ArrayList<Object>> array = new ArrayList<>();
        array.add(ConexionBaseDatos.db.get(1));
        array.add(ConexionBaseDatos.db.get(2));
        array.add(ConexionBaseDatos.db.get(4));
        System.out.println(array.size());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(0).get(i) instanceof Videojuego && multimedia.getTitulo().equals(((Videojuego) array.get(0).get(i)).getTitulo())) {
                return (Videojuego) ConexionBaseDatos.db.get(1).get(i);
            } else if (array.get(1).get(i) instanceof Pelicula && multimedia.getTitulo().equals(((Pelicula) array.get(1).get(i)).getTitulo())) {

                return (Pelicula) ConexionBaseDatos.db.get(2).get(i);
            } else if (array.get(2).get(i) instanceof Disco && multimedia.getTitulo().equals(((Disco) array.get(2).get(i)).getTitulo())) {
                return (Disco) ConexionBaseDatos.db.get(4).get(i);
            }
        }
        return null;

    }


}
