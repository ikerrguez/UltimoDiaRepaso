package Astronauta;

public class Ingeniero extends Empleado{
    private String proyectoActual;

    public Ingeniero(String nombre, double salarioBase, String proyectoActual) {
        super(nombre, salarioBase);
        this.proyectoActual = proyectoActual;
    }

    public String getProyectoActual() {
        return proyectoActual;
    }

    @Override
    public double calcularIncentivo() {
        return 300;
    }
}
