package Aerolinea;

public abstract class CargaAerea implements Pesable{
    private String descripcion;
    private double pesoBase;

    public CargaAerea(String descripcion, double pesoBase) {
        this.descripcion = descripcion;
        this.pesoBase = pesoBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPesoBase() {
        return pesoBase;
    }


}
