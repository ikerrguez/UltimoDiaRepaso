package Astronauta;

public class Astronauta extends Empleado{
    private Especialidad especialidades;

    public Astronauta(String nombre, double salarioBase, Especialidad especialidades) {
        super(nombre, salarioBase);
        this.especialidades = especialidades;
    }

    public Especialidad getEspecialidades() {
        return especialidades;
    }


    @Override
    public double calcularIncentivo() {
        return salarioBase*0.15;
    }
}
