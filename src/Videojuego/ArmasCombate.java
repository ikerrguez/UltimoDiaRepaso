package Videojuego;

public class ArmasCombate extends ItemInventario{
    private TipoMaterial tipoMaterial;

    public ArmasCombate(String nombreItem, double pesoBase, TipoMaterial tipoMaterial) {
        super(nombreItem, pesoBase);
        this.tipoMaterial = tipoMaterial;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    @Override
    public double calcularPesoEfectivo() {
        if (tipoMaterial == TipoMaterial.HIERRO || tipoMaterial == TipoMaterial.ACERO) {
            return pesoBase + (pesoBase * 0.15);
        }
        return pesoBase;
    }

    @Override
    public String toString() {
        return "Arma: " + nombreItem + " | Material: " + tipoMaterial + " | Peso Efectivo: " + calcularPesoEfectivo();
    }
}
