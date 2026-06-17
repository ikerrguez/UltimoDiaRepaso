package PixelStudio;

public abstract class Trabajador implements Bonificable {
    protected String nombre;
    protected double salarioBase;
    protected String dni;

    public Trabajador(String nombre, double salarioBase, String dni) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getDni() {
        return dni;
    }
}
