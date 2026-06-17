package FIA;

public abstract class EmpleadoF1 implements Rendimiento {
    protected String nombre;
    protected String apellido;
    protected double sueldoBase;

    public EmpleadoF1(String nombre, String apellido, double sueldoBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldoBase = sueldoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
