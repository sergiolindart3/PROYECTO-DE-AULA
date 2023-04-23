package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Andres Contreras, Julio Rios, Sergio Arango
 */
public class Deuda {

    //ATRIBUTOS
    private double deuda;
    private String asunto;
    private LocalDate fecha;

    //METODO CONSTRUCTOR
    public Deuda() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Deuda(double deuda, String asunto, LocalDate fecha) {
        this.deuda = deuda;
        this.asunto = asunto;
        this.fecha = fecha;
    }

    //METODO GET Y SET DE DEUDA
    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
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
        return "Deuda: " + deuda + ", Asunto: " + asunto + ", Fecha: " + fecha + "\n";
    }
}
