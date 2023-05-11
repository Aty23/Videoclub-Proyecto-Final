package control;

import view.Socio;

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
}
