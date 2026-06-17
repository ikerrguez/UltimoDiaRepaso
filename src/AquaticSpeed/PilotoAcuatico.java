package AquaticSpeed;

public class PilotoAcuatico extends ElementoAcuatico{
    private TipoEquipamiento tipoEquipamiento;

    public PilotoAcuatico(String codigoIdentificador, double pesoBase, TipoEquipamiento tipoEquipamiento) {
        super(codigoIdentificador, pesoBase);
        this.tipoEquipamiento = tipoEquipamiento;
    }

    public TipoEquipamiento getTipoEquipamiento() {
        return tipoEquipamiento;
    }

    @Override
    public double calcularPesoExtra() {
        return pesoBase*0.05;
    }


    @Override
    public String toString() {
        return "Piloto Acuático - Código: " + codigoIdentificador + " | Equipamiento: " + tipoEquipamiento;
    }

}
