package FairPlay;

public abstract class JugadorClub implements RendimientoDeportivo{
    private String nombre;
    private double sueldoBase;

    public JugadorClub(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }
}
