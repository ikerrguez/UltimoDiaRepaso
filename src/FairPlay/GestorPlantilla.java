package FairPlay;

import java.util.HashMap;

public class GestorPlantilla {
    private static final double LIMITE_FAIR_PLAY= 250000;
    private static HashMap<Integer, JugadorClub> mapaPlantilla = new HashMap<>();

    public static void inscribirFutbolista(int dorsal, String nombre, double sueldo, Demarcacion dem) throws LimiteSalarialExcedidoException{
        if (mapaPlantilla.containsKey(dorsal)) {
            throw new DorsalDuplicadoException("El dorsal " + dorsal + " ya está ocupado.");
        }
        double gastoActual = 0;
        for (JugadorClub j : mapaPlantilla.values()) {
            gastoActual += j.getSueldoBase();
        }

        if (gastoActual + sueldo > LIMITE_FAIR_PLAY) {
            throw new LimiteSalarialExcedidoException("No se puede inscribir a " + nombre + ". Se excedería el límite salarial de " + LIMITE_FAIR_PLAY + "€");
        }

        FutbolistaCampo nuevoFutbolista = new FutbolistaCampo(nombre, sueldo, dem);
        mapaPlantilla.put(dorsal, nuevoFutbolista);
        System.out.println("Futbolista " + nombre + " inscrito correctamente con el dorsal " + dorsal);
    }

    public static void inscribirPortero(int dorsal, String nombre, double sueldo, int imbatido) throws LimiteSalarialExcedidoException{
        if (mapaPlantilla.containsKey(dorsal)) {
            throw new DorsalDuplicadoException("El dorsal " + dorsal + " ya está ocupado.");
        }

        double gastoActual = 0;
        for (JugadorClub j : mapaPlantilla.values()) {
            gastoActual += j.getSueldoBase();
        }

        if (gastoActual + sueldo > LIMITE_FAIR_PLAY) {
            throw new LimiteSalarialExcedidoException("No se puede inscribir al portero " + nombre + ". Se excedería el límite salarial de " + LIMITE_FAIR_PLAY + "€");
        }

        Portero nuevoPortero = new Portero(nombre, sueldo, imbatido);
        mapaPlantilla.put(dorsal, nuevoPortero);
        System.out.println("Portero " + nombre + " inscrito correctamente con el dorsal " + dorsal);
    }

    public static void darDeBajaJugador(int dorsal){
        if (!mapaPlantilla.containsKey(dorsal)) {
            throw new java.util.NoSuchElementException("El dorsal " + dorsal + " no está asignado a ningún jugador.");
        }
        JugadorClub eliminado = mapaPlantilla.remove(dorsal);
        System.out.println("El jugador " + eliminado.getNombre() + " con dorsal " + dorsal + " ha sido dado de baja.");

    }

    public static void verMasaSalarial(){
        double totalSueldos = 0;
        double totalBonus = 0;

        System.out.println("--- AUDITORÍA DE MASA SALARIAL ---");
        for (JugadorClub j : mapaPlantilla.values()) {
            double bonus = j.calcularBonusVariables();
            totalSueldos += j.getSueldoBase();
            totalBonus += bonus;
            System.out.println(j.toString() + " | Sueldo: " + j.getSueldoBase() + "€ | Bonus: " + bonus + "€");
        }

        System.out.println("----------------------------------");
        System.out.println("Total Sueldos Base: " + totalSueldos + "€");
        System.out.println("Total Bonus Variables: " + totalBonus + "€");
        System.out.println("Masa Salarial Total: " + (totalSueldos + totalBonus) + "€");
        System.out.println("Límite Fair Play: " + LIMITE_FAIR_PLAY + "€");
        System.out.println("----------------------------------");
    }
}
