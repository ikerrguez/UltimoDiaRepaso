package ApexRacing;

public class Piloto extends EmpleadoEscuderia {
    private TipoLicencia tipoLicencia;

    public Piloto(String nombre, double salarioBase, TipoLicencia tipoLicencia) {
        super(nombre, salarioBase);
        this.tipoLicencia = tipoLicencia;
    }

    public TipoLicencia getTipoLicencia() {
        return tipoLicencia;
    }


    @Override
    public double calcularPlusObjetivos() {
        return salarioBase*0.12;
    }


    @Override
    public String toString() {
        return "Piloto: " + nombre + " | Licencia: " + tipoLicencia;
    }
}
