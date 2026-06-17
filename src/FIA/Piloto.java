package FIA;

import Astronauta.Empleado;

public class Piloto extends EmpleadoF1 {
    private CategoriaPiloto categoriaPiloto;

    public Piloto(String nombre, String apellido, double sueldoBase, CategoriaPiloto categoriaPiloto) {
        super(nombre, apellido, sueldoBase);
        this.categoriaPiloto = categoriaPiloto;
    }

    public CategoriaPiloto getCategoriaPiloto() {
        return categoriaPiloto;
    }

    public void setCategoriaPiloto(CategoriaPiloto categoriaPiloto) {
        this.categoriaPiloto = categoriaPiloto;
    }


    @Override
    public double calcularBonusRendimiento() {
        return sueldoBase*0.15;
    }
}
