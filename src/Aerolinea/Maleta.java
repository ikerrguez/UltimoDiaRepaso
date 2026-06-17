package Aerolinea;

public class Maleta extends CargaAerea{
    private ClaseBilletaje claseBilletaje;

    public Maleta(String descripcion, double pesoBase, ClaseBilletaje claseBilletaje) {
        super(descripcion, pesoBase);
        this.claseBilletaje = claseBilletaje;
    }

    public ClaseBilletaje getClaseBilletaje() {
        return claseBilletaje;
    }


    @Override
    public double calcularPlusPeso() {
        return getPesoBase()*0.1;
    }
}
