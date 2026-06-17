package PixelStudio;

import Astronauta.Empleado;

public class Disenhador extends Empleado {
    private String herramienta;

    public Disenhador(String nombre, double salarioBase, String herramienta, String dniDis) {
        super(nombre, salarioBase);
        this.herramienta = herramienta;
    }

    public String getHerramienta() {
        return herramienta;
    }

    @Override
    public double calcularIncentivo() {
        return 250;
    }
}
