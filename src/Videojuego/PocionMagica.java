package Videojuego;

public class PocionMagica extends ItemInventario{
    private int cantidadMililitros;

    public PocionMagica(String nombreItem, double pesoBase, int cantidadMililitros) {
        super(nombreItem, pesoBase);
        this.cantidadMililitros = cantidadMililitros;
    }

    public int getCantidadMililitros() {
        return cantidadMililitros;
    }


    @Override
    public double calcularPesoEfectivo() {
        return cantidadMililitros*0.001;
    }

    @Override
    public String toString() {
        return "Pocion Magica: " + nombreItem + " | Cantidad: " + cantidadMililitros + "ml";
    }
}
