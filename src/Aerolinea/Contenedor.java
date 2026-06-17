package Aerolinea;

public class Contenedor extends CargaAerea{
    private String tipoMercancia;

    public Contenedor(String descripcion, double pesoBase, String tipoMercancia) {
        super(descripcion, pesoBase);
        this.tipoMercancia = tipoMercancia;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    @Override
    public double calcularPlusPeso() {
        return 200;
    }
}
