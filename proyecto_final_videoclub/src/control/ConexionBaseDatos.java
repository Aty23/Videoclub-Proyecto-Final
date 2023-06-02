package control;

import view.*;

import java.sql.*;
import java.util.ArrayList;


public class ConexionBaseDatos {

    public static ArrayList<ArrayList<Object>> db = ConexionBaseDatos.conexionBase();

    public static ArrayList<ArrayList<Object>> conexionBase() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String bd = "Videoclub";
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String pass = "1234";
        ArrayList<ArrayList<Object>> info = new ArrayList<ArrayList<Object>>();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + bd, user, pass);
            try {
                info.add(datosSocio(con));
                info.add(datosVideojuego(con));
                info.add(datosPelicula(con));
                info.add(datosCancion(con));
                info.add(datosDisco(con));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    private static ArrayList<Object> datosSocio(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsSocio = st.executeQuery("select * from Socio");
        ArrayList<Object> infoSocio = new ArrayList<Object>();
        while (rsSocio.next()) {
            Socio socio = new Socio(rsSocio.getString("dni"), rsSocio.getString("nombre"),
                    rsSocio.getInt("anyoNacimiento"), rsSocio.getString("poblacion"),
                    rsSocio.getBoolean("alquilando"), alquileresSocio( con,  rsSocio.getString("alquileresSocio")));
            infoSocio.add(socio);
        }
        return infoSocio;
    }

    private static ArrayList<Multimedia> alquileresSocio( Connection con, String alquileres) throws SQLException {
        ArrayList<Multimedia> multimediasAlquilados = new ArrayList<Multimedia>();
        String[] multimediasSplit = alquileres.split("/");
        for (int i = 0; i < multimediasSplit.length; i++) {
            Multimedia m = compararMultimedia(multimediasSplit[i], con);
            if (m != null) {
                multimediasAlquilados.add(m);
            }
        }

        return multimediasAlquilados;
    }

    private static Multimedia compararMultimedia(String multimedia, Connection con) throws SQLException {
        ArrayList<ArrayList<Object>> multimedias = new ArrayList<ArrayList<Object>>();
        multimedias.add(datosVideojuego(con));
        multimedias.add(datosPelicula(con));
        multimedias.add(datosDisco(con));
        for (int i = 0; i < multimedias.size(); i++) {
            if (multimedias.get(0).get(i) instanceof Videojuego && multimedia.equals(((Videojuego) multimedias.get(0).get(i)).getTitulo())) {
                return (Videojuego) multimedias.get(0).get(i);
            } else if (multimedias.get(1).get(i) instanceof Pelicula && multimedia.equals(((Pelicula) multimedias.get(0).get(i)).getTitulo())) {
                return (Pelicula) multimedias.get(1).get(i);
            } else if (multimedias.get(2).get(i) instanceof Disco && multimedia.equals(((Disco) multimedias.get(0).get(i)).getTitulo())) {
                return (Disco) multimedias.get(2).get(i);
            }
        }
        return null;
    }

    private static ArrayList<Object> datosVideojuego(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsVideojuego = st.executeQuery("select * from Videojuego");
        ArrayList<Object> infoVideojuego = new ArrayList<Object>();
        while (rsVideojuego.next()) {
            Videojuego videojuego = new Videojuego(rsVideojuego.getString("titulo"), rsVideojuego.getString("autor"),
                    rsVideojuego.getString("formato"), rsVideojuego.getInt("anyo"),
                    rsVideojuego.getDate("diaALquilado"), rsVideojuego.getString("plataforma"));
            infoVideojuego.add(videojuego);
        }
        return infoVideojuego;
    }

    private static ArrayList<Object> datosPelicula(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsPelicula = st.executeQuery("select * from Pelicula");
        ArrayList<Object> infoPelicula = new ArrayList<Object>();
        while (rsPelicula.next()) {
            Pelicula pelicula = new Pelicula(rsPelicula.getString("titulo"), rsPelicula.getString("autor"),
                    rsPelicula.getString("formato"),
                    rsPelicula.getInt("anyo"),rsPelicula.getDate("diaAlquilado"), rsPelicula.getInt("duracion"),
                    rsPelicula.getString("actorPrincipal"), rsPelicula.getString("actrizPrincipal"));
            infoPelicula.add(pelicula);
        }
        return infoPelicula;
    }

    private static ArrayList<Object> datosCancion(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsCanion = st.executeQuery("select * from Canion");
        ArrayList<Object> infoCancion = new ArrayList<Object>();
        while (rsCanion.next()) {
            Cancion cancion = new Cancion(rsCanion.getString("nombre"), rsCanion.getInt("duracionSegundos"));
            infoCancion.add(cancion);
        }
        return infoCancion;
    }

    private static ArrayList<Object> datosDisco(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsDisco = st.executeQuery("select * from Disco");
        ArrayList<Object> infoDisco = new ArrayList<Object>();
        while (rsDisco.next()) {

            Disco disco = new Disco(rsDisco.getString("titulo"), rsDisco.getString("autor"),
                    rsDisco.getString("formato"), rsDisco.getInt("anyo"), rsDisco.getDate("diaAlquilado"),
                    rsDisco.getInt("duracion"), cancionesDisco(con, rsDisco.getString("cancionesDisco")));
            infoDisco.add(disco);
        }
        return infoDisco;
    }

    private static ArrayList<Cancion> cancionesDisco(Connection con, String canciones) throws SQLException {
        ArrayList<Cancion> cancionesDisco = new ArrayList<Cancion>();
        String[] cancionesSplit = canciones.split("/");
        for (int i = 0; i < cancionesSplit.length; i++) {
            Cancion c = compararCanciones(cancionesSplit[i], con);
            if (c != null) {
                cancionesDisco.add(c);
            }
        }
        return cancionesDisco;
    }

    private static Cancion compararCanciones(String cancion, Connection con) throws SQLException {
        ArrayList<Object> canciones = datosCancion(con);
        for (int i = 0; i < canciones.size(); i++) {
            if (cancion.equals(((Cancion) canciones.get(i)).getNombre())) {
                return (Cancion) canciones.get(i);
            }
        }
        return null;
    }

    public static void modificarBD(ArrayList<ArrayList<Object>> info) {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String bd = "Videoclub";
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String pass = "1234";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + bd, user, pass);
            try {
                Statement st = con.createStatement();
                modificarSoio(info.get(0), st);
                modificarVideojuego(info.get(1), st);
                modificarPelicula(info.get(2), st);
                modificarCancion(info.get(3), st);
                modificarDisco(info.get(4), st);

                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void modificarSoio(ArrayList<Object> infoSocio, Statement st) throws SQLException {
        st.executeQuery("delete * from socio");
        for (int i = 0; i < infoSocio.size(); i++) {
            try {
                st.executeQuery("insert into socio values('" + ((Socio) infoSocio.get(i)).getNif() + "', '"
                        + ((Socio) infoSocio.get(i)).getNombre() + "', " + ((Socio) infoSocio.get(i)).getFechaNacimiento()
                        + ", '" + ((Socio) infoSocio.get(i)).getPoblacion() + "', " + ((Socio) infoSocio.get(i)).isAlquilando()
                        + ", " + ((Socio) infoSocio.get(i)).getTitulosMultimediaAlquilado() + ");");
            } catch (Exception e) {
            }
        }
    }


    private static void modificarVideojuego(ArrayList<Object> infoVideojuego, Statement st) throws SQLException {
        st.executeQuery("delete * from videojuego");
        for (int i = 0; i < infoVideojuego.size(); i++) {
            try {
                st.executeQuery("insert into videojuego values('" + ((Videojuego) infoVideojuego.get(i)).getTitulo() + "', '"
                        + ((Videojuego) infoVideojuego.get(i)).getAutor() + "', '" + ((Videojuego) infoVideojuego.get(i)).getFormato()
                        + "', " + ((Videojuego) infoVideojuego.get(i)).getAnyo() + ", '" + ((Videojuego)infoVideojuego.get(i)).getDiaAlquilado()
                        + ", '" + ((Videojuego) infoVideojuego.get(i)).getPlataforma() + "');");
            } catch (Exception e) {
            }
        }
    }

    private static void modificarPelicula(ArrayList<Object> infoPelicula, Statement st) throws SQLException {
        st.executeQuery("delete * from pelicula");
        for (int i = 0; i < infoPelicula.size(); i++) {
            try {
                st.executeQuery("insert into pelicula values('" + ((Pelicula) infoPelicula.get(i)).getTitulo() + "', '"
                        + ((Pelicula) infoPelicula.get(i)).getAutor() + "', '" + ((Pelicula) infoPelicula.get(i)).getFormato()
                        + "', " + ((Pelicula) infoPelicula.get(i)).getAnyo() + "', '" + ((Pelicula) infoPelicula.get(i)).getDiaAlquilado()
                        + ", " + ((Pelicula) infoPelicula.get(i)).getDuracion() + ", '"
                        + ((Pelicula) infoPelicula.get(i)).getActorPrincipal() + "', '"
                        + ((Pelicula) infoPelicula.get(i)).getActrizPrincipal() + "');");
            } catch (Exception e) {
            }
        }
    }

    private static void modificarCancion(ArrayList<Object> infoCancion, Statement st) throws SQLException {
        st.executeQuery("delete * from canicon");
        for (int i = 0; i < infoCancion.size(); i++) {
            try {
                st.executeQuery("insert into cancion values('" + ((Cancion) infoCancion.get(i)).getNombre() + "', "
                        + ((Cancion) infoCancion.get(i)).getDuracionSegundos() + ");");
            } catch (Exception e) {
            }
        }
    }

    private static void modificarDisco(ArrayList<Object> infoDisco, Statement st) throws SQLException {
        st.executeQuery("delete * from disco");
        for (int i = 0; i < infoDisco.size(); i++) {
            try {
                st.executeQuery("insert into disco values('" + ((Disco) infoDisco.get(i)).getTitulo() + "', '"
                        + ((Disco) infoDisco.get(i)).getAutor() + "', '" + ((Disco) infoDisco.get(i)).getFormato()
                        + "', " + ((Disco) infoDisco.get(i)).getAnyo() + "', '" + ((Disco) infoDisco.get(i)).getDiaAlquilado()
                        + ", " + ((Disco) infoDisco.get(i)).getDuracionDisco() + ", '"
                        + ((Disco) infoDisco.get(i)).lineaCacionesDisco() + "');");
            } catch (Exception e) {
            }
        }
    }

    /*public String lineaCacionesDisco(ArrayList<Cancion> canciones) {
        String cancionesDisco = "/";
        for (int i = 0; i < canciones.size(); i++) {
            cancionesDisco += canciones.get(i) + "/";
        }
        return cancionesDisco;
    }*/

}
