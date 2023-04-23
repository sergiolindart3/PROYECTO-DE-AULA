package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Andres Contreras, Julio Rios, Sergio Arango
 */
public class Egreso {

    //ATRIBUTOS
    private double egreso;
    private String asunto;
    private LocalDate fecha;

    //METODO CONSTRUCTOR
    public Egreso() {

    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Egreso(double egreso, String asunto) {
        this.egreso = egreso;
        this.asunto = asunto;
        this.fecha = LocalDate.now();
    }

    //METODO GET Y SET DE EGRESO
    public double getEgreso() {
        return egreso;
    }

    public void setEgreso(double egreso) {
        this.egreso = egreso;
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
        return "Egreso: " + egreso + ", Asunto: " + asunto + ", Fecha: " + fecha + "\n";
    }
}
