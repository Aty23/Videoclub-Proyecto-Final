package model;
import model.*;

import java.util.*;

public class Socio {
    /**
     * atributos
     */
    private String nif;
    private String nombre;
    private int anyoNacimiento;
    private String poblacion;
    private boolean alquilando, recargoPendiente=false;
    ArrayList<Multimedia> multimediaAlquilado=new ArrayList<Multimedia>();

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
     *@param multimediaAlquilado ArrayList<Multimedia>
     */

    public Socio(String nif, String nombre, int anyoNacimiento, String poblacion, boolean alquilando,
                 ArrayList<Multimedia> multimediaAlquilado) {
        setNif(nif);
        setNombre(nombre);
        setAnyoNacimiento(anyoNacimiento);
        setPoblacion(poblacion);
        setAlquilando(alquilando);
        setMultimediaAlquilado(multimediaAlquilado);
    }



    /**
     * getters y setters
     */
    public void setMultimediaAlquilado(ArrayList<Multimedia> multimediaAlquilado) {
        if(multimediaAlquilado==null){
            this.multimediaAlquilado= new ArrayList<>();
        }else {
            this.multimediaAlquilado = multimediaAlquilado;
        }
    }
    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public boolean isRecargoPendiente() {
        return recargoPendiente;
    }

    public ArrayList<Multimedia> getMultimediaAlquilado() {
        return multimediaAlquilado;
    }
    public String getTitulosMultimediaAlquilado(){
        try {
            System.out.println(getNif());
            if(multimediaAlquilado==null){
                System.out.println("AaA");
                return null;
            }
            String lineaMultimediaAlquilado = "";
            for (int i = 0; 0 < multimediaAlquilado.size(); i++) {
                System.out.println("AAAAAAAAAAAAAAAAAA");
                lineaMultimediaAlquilado =lineaMultimediaAlquilado +  multimediaAlquilado.get(i).getTitulo() + "/";
                System.out.println(lineaMultimediaAlquilado);
                if(i==multimediaAlquilado.size()-1){
                    return lineaMultimediaAlquilado;
                }
            }
            System.out.println(lineaMultimediaAlquilado);
            if (lineaMultimediaAlquilado.equals("")) {
                System.out.println(lineaMultimediaAlquilado);
                System.out.println("AAAAA");
                System.out.println(getMultimediaAlquilado().size());
                System.out.println(getMultimediaAlquilado().get(0).getTitulo());
                return null;

            }
            System.out.println(lineaMultimediaAlquilado);
            return lineaMultimediaAlquilado;
        }catch (Exception e){
            return null;
        }
    }

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
    public String nombresMultimediaAlquilados(){
        String linea="";
        for(int i=0; i<multimediaAlquilado.size(); i++){
            linea+=multimediaAlquilado.get(i).getTitulo() + "\n";
        }
        return linea;
    }




}
