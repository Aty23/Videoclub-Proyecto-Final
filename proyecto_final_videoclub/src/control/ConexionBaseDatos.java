package control;

import view.*;

import java.sql.*;
import java.util.ArrayList;


public class ConexionBaseDatos {

    public static ArrayList<ArrayList<Object>> conexionBase(){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String bd = "Videoclub";
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String pass = "1234";
        ArrayList<ArrayList<Object>> info = new ArrayList<ArrayList<Object>>();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + bd, user,pass);
            try{
                info.add(datosSocio(con));
                info.add(datosVideojuego(con));
                info.add(datosPelicula(con));
                info.add(datosCancion(con));
                info.add(datosDisco(con));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
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
                    rsSocio.getInt("anyoNacimiento"),rsSocio.getString("poblacion"),
                    rsSocio.getBoolean("alquilando"),rsSocio.getDate("alquiler") );
            infoSocio.add(socio);
        }
        return infoSocio;
    }
    private static ArrayList<Object> datosVideojuego(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsVideojuego = st.executeQuery("select * from Videojuego");
        ArrayList<Object> infoVideojuego = new ArrayList<Object>();
        while (rsVideojuego.next()) {
            Videojuego videojuego = new Videojuego(rsVideojuego.getInt("Id"), rsVideojuego.getString("titulo"), rsVideojuego.getString("autor"),
                    rsVideojuego.getString("formato"),
                    rsVideojuego.getInt("anyo"), rsVideojuego.getString("plataforma"));
            infoVideojuego.add(videojuego);
        }
        return infoVideojuego;
    }
    private static ArrayList<Object> datosPelicula(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsPelicula = st.executeQuery("select * from Pelicula");
        ArrayList<Object> infoPelicula = new ArrayList<Object>();
        while (rsPelicula.next()) {
            Pelicula pelicula = new Pelicula(rsPelicula.getInt("Id"),rsPelicula.getString("titulo"), rsPelicula.getString("autor"),
                    rsPelicula.getString("formato"),
                    rsPelicula.getInt("anyo"), rsPelicula.getInt("duracion"),
                    rsPelicula.getString("actorprincipal"), rsPelicula.getString("actrizPrincipal"));
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

            Disco disco = new Disco(rsDisco.getInt("Id"),rsDisco.getString("titulo"), rsDisco.getString("autor"),
                    rsDisco.getString("formato"), rsDisco.getInt("anyo"), rsDisco.getInt("duracion"),
                    cancionesDisco(rsDisco, con));
            infoDisco.add(disco);
        }
        return infoDisco;
    }
    private static ArrayList<Cancion> cancionesDisco(ResultSet rsDisco, Connection con) throws SQLException{
        String canciones = "";
        ArrayList<String> cancionesArray = new ArrayList<String>();
        ArrayList<Cancion> cancionesDisco = new ArrayList<Cancion>();
        while (rsDisco.next()){
            canciones= rsDisco.getString("cancionesDisco");
            String[] cancionesSplit = canciones.split("/");
            for(int i=0; i<cancionesSplit.length; i++){
                Cancion c = compararCanciones(cancionesSplit[i], con);
                if(c!=null){
                    cancionesDisco.add(c);
                }
            }

        }
        return cancionesDisco;
    }
    private static Cancion compararCanciones(String cancion, Connection con) throws SQLException{
        ArrayList<Object> canciones = datosCancion(con);
        for(int i=0; i<canciones.size(); i++){
            if(cancion.equals(((Cancion)canciones.get(i)).getNombre())){
                return (Cancion) canciones.get(i);
            }
        }
        return null;
    }
    public static void modificarBD(ArrayList<ArrayList<Object>> info){
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
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void modificarSoio(ArrayList<Object> infoSocio, Statement st) throws SQLException{
        st.executeQuery("delete * from socio");
        for(int i=0; i<infoSocio.size(); i++){
            try{
                st.executeQuery("insert into socio values('" + ((Socio)infoSocio.get(i)).getNif() + "', '"
                    + ((Socio)infoSocio.get(i)).getNombre() + "', " + ((Socio)infoSocio.get(i)).getFechaNacimiento()
                    + ", '" + ((Socio)infoSocio.get(i)).getPoblacion() + "', " + ((Socio)infoSocio.get(i)).isAlquilando()
                    + ", " + ((Socio)infoSocio.get(i)).getMultimediaAlquilado() + ");");
            }catch (Exception e){}
        }
    }
    private static void modificarVideojuego(ArrayList<Object> infoVideojuego, Statement st) throws SQLException{
        st.executeQuery("delete * from videojuego");
        for(int i=0; i<infoVideojuego.size(); i++){
            try{
                st.executeQuery("insert into videojuego values('" + ((Videojuego)infoVideojuego.get(i)).getTitulo() + "', '"
                        + ((Videojuego)infoVideojuego.get(i)).getAutor() + "', '" + ((Videojuego)infoVideojuego.get(i)).getFormato()
                        +"', " + ((Videojuego)infoVideojuego.get(i)).getAnyo()
                        + ", '" + ((Videojuego)infoVideojuego.get(i)).getPlataforma() + "');");
            }catch (Exception e){}
        }
    }
    private static void modificarPelicula(ArrayList<Object> infoPelicula, Statement st) throws SQLException{
        st.executeQuery("delete * from pelicula");
        for(int i=0; i<infoPelicula.size(); i++){
            try{
                st.executeQuery("insert into pelicula values('" + ((Pelicula)infoPelicula.get(i)).getTitulo() + "', '"
                        + ((Pelicula)infoPelicula.get(i)).getAutor() + "', '" + ((Pelicula)infoPelicula.get(i)).getFormato()
                        +"', " + ((Pelicula)infoPelicula.get(i)).getAnyo()
                        + ", " + ((Pelicula)infoPelicula.get(i)).getDuracion() + ", '"
                        + ((Pelicula)infoPelicula.get(i)).getActorPrincipal() + "', '"
                        + ((Pelicula)infoPelicula.get(i)).getActrizPrincipal() + "');");
            }catch (Exception e){}
        }
    }
    private static void modificarCancion(ArrayList<Object> infoCancion, Statement st) throws SQLException{
        st.executeQuery("delete * from canicon");
        for(int i=0; i<infoCancion.size(); i++){
            try{
                st.executeQuery("insert into cancion values('" + ((Cancion)infoCancion.get(i)).getNombre() + "', "
                + ((Cancion)infoCancion.get(i)).getDuracionSegundos() + ");");
            }catch (Exception e){}
        }
    }
    private static void modificarDisco(ArrayList<Object> infoDisco, Statement st) throws SQLException{
        st.executeQuery("delete * from disco");
        for(int i=0; i<infoDisco.size(); i++){
            try{
                st.executeQuery("insert into disco values('" + ((Disco)infoDisco.get(i)).getTitulo() + "', '"
                        + ((Disco)infoDisco.get(i)).getAutor() + "', '" + ((Disco)infoDisco.get(i)).getFormato()
                        +"', " + ((Disco)infoDisco.get(i)).getAnyo()
                        + ", " + ((Disco)infoDisco.get(i)).getDuracionDisco() +", '"
                        + lineaCacionesDisco(((Disco)infoDisco.get(i)).getColeccionCanciones()) + "');");
            }catch (Exception e){}
        }
    }
    private static String lineaCacionesDisco(ArrayList<Cancion> canciones){
        String cancionesDisco="/";
        for(int i=0; i<canciones.size(); i++){
            cancionesDisco+=canciones.get(i) + "/";
        }
        return cancionesDisco;
    }
}
