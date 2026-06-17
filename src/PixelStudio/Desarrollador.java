package PixelStudio;

public class Desarrollador extends Trabajador{
    private Lenguaje lenguaje;

    public Desarrollador(String nombre, double salarioBase, String dni, Lenguaje lenguaje) {
        super(nombre, salarioBase, dni);
        this.lenguaje = lenguaje;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    @Override
    public double calcularBonus() {
        return salarioBase*0.20;
    }
}
