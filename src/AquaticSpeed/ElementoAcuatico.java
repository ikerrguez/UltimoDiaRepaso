package AquaticSpeed;

public abstract class ElementoAcuatico implements ImpactoPeso{
    protected String codigoIdentificador;
    protected double pesoBase;

    public ElementoAcuatico(String codigoIdentificador, double pesoBase) {
        this.codigoIdentificador = codigoIdentificador;
        this.pesoBase = pesoBase;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public double getPesoBase() {
        return pesoBase;
    }
}
