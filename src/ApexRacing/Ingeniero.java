package ApexRacing;

public class Ingeniero extends EmpleadoEscuderia{
    private String especialidad;

    public Ingeniero(String nombre, double salarioBase, String especialidad) {
        super(nombre, salarioBase);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }


    @Override
    public double calcularPlusObjetivos() {
        return 350;
    }

    @Override
    public String toString() {
        return "Ingeniero: " + nombre + " | Especialidad: " + especialidad;
    }

}
