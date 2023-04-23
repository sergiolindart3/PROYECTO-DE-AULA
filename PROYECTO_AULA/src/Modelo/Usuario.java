package Modelo;

/**
 *
 * @author Jorman Noriega, Andres Contreras, Julio Rios, Sergio Arango
 */
public class Usuario {

    //ATRIBUTOS
    private String nombre;
    private String correo;
    private String contraseña;
    private Saldo saldo;

    //METODO CONSTRUCTOR
    public Usuario() {

    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Usuario(String nombre, String correo, String contraseña, Saldo saldo) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    //METODO GET Y SET DE NOMBRE
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //METODO GET Y SET DE CORREO
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //METODO GET Y SET DE CONTRASEÑA
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //METODO GET Y SET DE SALDO
    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
}
