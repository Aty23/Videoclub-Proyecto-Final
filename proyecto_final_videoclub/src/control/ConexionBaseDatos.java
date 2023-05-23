package control;

import view.*;

import java.sql.*;
import java.util.ArrayList;

public class ConexionBaseDatos {

    public ArrayList<ArrayList<Object>> conexionBase(){
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
    public ArrayList<Object> datosSocio(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsSocio = st.executeQuery("select * from Socio");
        ArrayList<Object> infoSocio = new ArrayList<Object>();
        while (rsSocio.next()) {
            Socio socio = new Socio(rsSocio.getString("dni"), rsSocio.getString("nombre"),
                    rsSocio.getInt("anyoNacimiento"),rsSocio.getString("poblacion"),
                    rsSocio.getBoolean("alquilando"), rsSocio.getDate("diaAlquilado"));
            infoSocio.add(socio);
        }
        return infoSocio;
    }
    public ArrayList<Object> datosVideojuego(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsVideojuego = st.executeQuery("select * from Videojuego");
        ArrayList<Object> infoVideojuego = new ArrayList<Object>();
        while (rsVideojuego.next()) {
            Videojuego videojuego = new Videojuego(rsVideojuego.getString("titulo"), rsVideojuego.getString("autor"),
                    rsVideojuego.getString("formato"),
                    rsVideojuego.getInt("anyo"), rsVideojuego.getString("plataforma"));
            infoVideojuego.add(videojuego);
        }
        return infoVideojuego;
    }
    public ArrayList<Object> datosPelicula(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsPelicula = st.executeQuery("select * from Pelicula");
        ArrayList<Object> infoPelicula = new ArrayList<Object>();
        while (rsPelicula.next()) {
            Pelicula pelicula = new Pelicula(rsPelicula.getString("titulo"), rsPelicula.getString("autor"),
                    rsPelicula.getString("formato"),
                    rsPelicula.getInt("anyo"), rsPelicula.getInt("duracion"),
                    rsPelicula.getString("actorprincipal"), rsPelicula.getString("actrizPrincipal"));
            infoPelicula.add(pelicula);
        }
        return infoPelicula;
    }
    public ArrayList<Object> datosCancion(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsCanion = st.executeQuery("select * from Canion");
        ArrayList<Object> infoCancion = new ArrayList<Object>();
        while (rsCanion.next()) {
            Cancion cancion = new Cancion(rsCanion.getString("nombre"), rsCanion.getInt("duracionSegundos"));
            infoCancion.add(cancion);
        }
        return infoCancion;
    }
    public ArrayList<Object> datosDisco(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsDisco = st.executeQuery("select * from Disco");
        ArrayList<Object> infoDisco = new ArrayList<Object>();
        while (rsDisco.next()) {

            Disco disco = new Disco(rsDisco.getString("titulo"), rsDisco.getString("autor"),
                    rsDisco.getString("formato"), rsDisco.getInt("anyo"), rsDisco.getInt("duracion"),
                    cancionesDisco(rsDisco, con));
            infoDisco.add(disco);
        }
        return infoDisco;
    }
    public ArrayList<Cancion> cancionesDisco(ResultSet rsDisco, Connection con) throws SQLException{
        String canciones = "";
        ArrayList<String> cancionesArray = new ArrayList<String>();
        ArrayList<Cancion> cancionesDisco = new ArrayList<Cancion>();
        while (rsDisco.next()){
            canciones= rsDisco.getString("cancionesDisco");
            String[] cancionesSplit = canciones.split("/");
            for(int i=0; i<cancionesSplit.length; i++){
                if(compararCanciones(cancionesSplit[i], con)!=null){
                    cancionesDisco.add(compararCanciones(cancionesSplit[i], con));
                }
            }

        }
        return cancionesDisco;
    }
    public Cancion compararCanciones(String cancion, Connection con) throws SQLException{
        ArrayList<Object> canciones = datosCancion(con);
        for(int i=0; i<canciones.size(); i++){
            if(cancion.equals(((Cancion)canciones.get(i)).getNombre())){
                return (Cancion) canciones.get(i);
            }
        }
        return null;
    }
}
