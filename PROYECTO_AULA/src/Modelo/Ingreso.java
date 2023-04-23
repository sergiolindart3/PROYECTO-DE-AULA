package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Andres Contreras, Julio Rios, Sergio Arango
 */
public class Ingreso {

    //ATRIBUTOS
    private double ingreso;
    private String asunto;
    private LocalDate fecha;

    //METODO CONSTRUCTOR
    public Ingreso() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Ingreso(double ingreso, String asunto) {
        this.ingreso = ingreso;
        this.asunto = asunto;
        this.fecha = LocalDate.now();
    }

    //METODO GET Y SET DE INGRESO
    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    //METODO GET Y SET DE ASUNTO
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    //METODO GET Y SET DE FECHA
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return "Ingreso: " + ingreso + ", Asunto: " + asunto + ", Fecha: " + fecha + "\n";
    }
}
