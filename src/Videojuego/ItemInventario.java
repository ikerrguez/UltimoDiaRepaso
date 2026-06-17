package Videojuego;

public abstract class ItemInventario implements PropiedadFisica {
    protected String nombreItem;
    protected double pesoBase;

    public ItemInventario(String nombreItem, double pesoBase) {
        this.nombreItem = nombreItem;
        this.pesoBase = pesoBase;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public double getPesoBase() {
        return pesoBase;
    }
}
