package control;

import view.Pelicula;
import view.Socio;
import view.Videojuego;

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
        ResultSet rsVideojuego = st.executeQuery("select * from Socio");
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
        ResultSet rsPelicula = st.executeQuery("select * from Socio");
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
    /*public ArrayList<Object> datosDisco(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rsPelicula = st.executeQuery("select * from Socio");
        ArrayList<Object> infoPelicula = new ArrayList<Object>();
        while (rsPelicula.next()) {
            Pelicula pelicula = new Pelicula(rsPelicula.getString("titulo"), rsPelicula.getString("autor"),
                    rsPelicula.getString("formato"),
                    rsPelicula.getInt("anyo"), rsPelicula.getInt("duracion"),
                    rsPelicula.getString("actorprincipal"), rsPelicula.getString("actrizPrincipal"));
            infoPelicula.add(pelicula);
        }
        return infoPelicula;
    }*/
}
