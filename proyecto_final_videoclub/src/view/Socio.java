package view;
import model.*;
public class Socio {
    /**
     * atributos
     */
    private String nif;
    private String nombre;
    private int anyoNacimiento;
    private String poblacion;
    private boolean alquilando;
    private int diasAlquilando;

    /**
     * constructor default
     */
    public  Socio(){
        setNif(Constantes.NIF_DEFAULT);
        setNombre(Constantes.NOMBRE_DEFAULT);
        setAnyoNacimiento(Constantes.ANYO_NACIMIENTO_DEFAULT);
        setPoblacion(Constantes.POBLACION_DEFAULT);
        setAlquilando(Constantes.ALQUILANDO_DEFAULT);

    }

    /**
     * constructor por parámetros
     * @param nif
     * @param nombre
     * @param anyoNacimiento
     * @param poblacion
     * @param alquilando
     */

    public Socio(String nif, String nombre, int anyoNacimiento, String poblacion, boolean alquilando) {
        setNif(nif);
        setNombre(nombre);
        setAnyoNacimiento(anyoNacimiento);
        setPoblacion(poblacion);
        setAlquilando(alquilando);
    }

    /**
     * getters y setters
     * @return
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
            throw new RuntimeException("Población o introducida");
        }
    }

    public boolean isAlquilando() {
        return alquilando;
    }

    public void setAlquilando(boolean alquilando) {
        this.alquilando = alquilando;
    }

    public int getDiasAlquilando() {
        return diasAlquilando;
    }

    public void setDiasAlquilando(int diasAlquilando) {
        if(diasAlquilando>=0) {
            this.diasAlquilando = diasAlquilando;
        }else {
            throw new RuntimeException("Cantidad de dínas no valida");
        }
    }

    /**
     * controla si hay un alquiler activo
     * @param peli
     */
    public void alquilerPelicula(Pelicula peli){
        if(!alquilando){
            setAlquilando(true);
        }

    }
}
