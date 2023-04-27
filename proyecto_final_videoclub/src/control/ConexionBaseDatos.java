package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexionBaseDatos {

    public void conexionBase(){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String bd = "VideoclubDB";
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String pass = "1234";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + bd, user,pass);
            try{
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from clientes");



                }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
