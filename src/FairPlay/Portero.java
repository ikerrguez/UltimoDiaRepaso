package FairPlay;

public class Portero extends JugadorClub{
    private int partidosImbatido;

    public Portero(String nombre, double sueldoBase, int partidosImbatido) {
        super(nombre, sueldoBase);
        this.partidosImbatido = partidosImbatido;
    }

    public int getPartidosImbatido() {
        return partidosImbatido;
    }


    @Override
    public double calcularBonusVariables() {
        return 500*partidosImbatido;
    }

    @Override
    public String toString() {
        return "Portero: " + getNombre() + " | Partidos Imbatidos: " + partidosImbatido;
    }
}
