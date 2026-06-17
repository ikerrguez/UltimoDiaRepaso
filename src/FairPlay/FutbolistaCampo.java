package FairPlay;

public class FutbolistaCampo extends JugadorClub{
    private Demarcacion demarcacion;

    public FutbolistaCampo(String nombre, double sueldoBase, Demarcacion demarcacion) {
        super(nombre, sueldoBase);
        this.demarcacion = demarcacion;
    }

    public Demarcacion getDemarcacion() {
        return demarcacion;
    }


    @Override
    public double calcularBonusVariables() {
        if (demarcacion == Demarcacion.DELANTERO) {
            return getSueldoBase() * 0.20;
        } else {
            return getSueldoBase() * 0.10;
        }
    }

    @Override
    public String toString() {
        return "Futbolista de Campo: " + getNombre() + " | Demarcación: " + demarcacion + " | Sueldo Base: " + getSueldoBase() + "€";
    }


}
