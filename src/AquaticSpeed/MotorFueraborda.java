package AquaticSpeed;

public class MotorFueraborda extends ElementoAcuatico{
    private String tipoCombustible;

    public MotorFueraborda(String codigoIdentificador, double pesoBase, String tipoCombustible) {
        super(codigoIdentificador, pesoBase);
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }


    @Override
    public double calcularPesoExtra() {
        return 45;
    }

    @Override
    public String toString() {
        return "Motor Fueraborda - Código: " + codigoIdentificador + " | Combustible: " + tipoCombustible;
    }
}
