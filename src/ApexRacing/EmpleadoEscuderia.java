package ApexRacing;

public abstract class EmpleadoEscuderia implements RendimientoMonetario{
    protected String nombre;
    protected double salarioBase;

    public EmpleadoEscuderia(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
