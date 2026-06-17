package FIA;

public class Ingeniero extends EmpleadoF1{
    private String especialidad;

    public Ingeniero(String nombre, String apellido, double sueldoBase, String especialidad) {
        super(nombre, apellido, sueldoBase);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    @Override
    public double calcularBonusRendimiento() {
        return 500;
    }
}
