package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jorman Noriega, Andres Contreras, Julio Rios, Sergio Arango
 */
public class Saldo {

    //ATRIBUTOS
    private double saldo;
    private ArrayList<Ingreso> ingresos;
    private ArrayList<Egreso> egresos;
    private ArrayList<Deuda> deudas;

    //METODO CONSTRUCTOR
    public Saldo() {

    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Saldo(double saldo) {
        this.saldo = saldo;
        this.ingresos = new ArrayList();
        this.egresos = new ArrayList();
        this.deudas = new ArrayList();
    }

    //METODO GET Y SET DE SALDO
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //METODO GET Y SET DE INGRESOS
    public ArrayList<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(ArrayList<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    //METODO GET Y SET DE EGRESOS
    public ArrayList<Egreso> getEgresos() {
        return egresos;
    }

    public void setEgresos(ArrayList<Egreso> egresos) {
        this.egresos = egresos;
    }

    //METODO GET Y SET DE DEUDAS
    public ArrayList<Deuda> getDeudas() {
        return deudas;
    }

    public void setDeudas(ArrayList<Deuda> deudas) {
        this.deudas = deudas;
    }

    //METODO REGISTRAR INGRESO
    public void registrarIngreso(double ingreso, String asunto) {
        Ingreso nuevoIngreso = new Ingreso(ingreso, asunto);
        this.ingresos.add(nuevoIngreso);
        this.saldo += ingreso;
    }

    //METODO REGISTRAR EGRESO
    public void registrarEgreso(double egreso, String asunto) {
        Egreso nuevoEgreso = new Egreso(egreso, asunto);
        this.egresos.add(nuevoEgreso);
        this.saldo -= egreso;
    }

    //METODO REGISTRAR DEUDAS
    public void registrarDeudas(double deudas, String asunto, LocalDate fecha) {
        Deuda nuevaDeuda = new Deuda(deudas, asunto, fecha);
        this.deudas.add(nuevaDeuda);
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return " " + saldo;
    }

}
