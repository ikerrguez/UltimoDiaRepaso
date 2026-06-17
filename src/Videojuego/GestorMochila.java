package Videojuego;

import java.util.ArrayList;

public class GestorMochila {
    private static final double LIMITE_PESO_MOCHILA = 50;
    private static ArrayList<ItemInventario> mochila = new ArrayList<>();


    public static void recogerArma(String nombre, double peso, TipoMaterial material) throws MochilaSobrecargadaException {
        ArmasCombate nuevaArma = new ArmasCombate(nombre, peso, material);
        double pesoActual = 0;
        for (ItemInventario item : mochila) {
            pesoActual += item.calcularPesoEfectivo();
        }

        if (pesoActual + nuevaArma.calcularPesoEfectivo() > LIMITE_PESO_MOCHILA) {
            throw new MochilaSobrecargadaException("No se puede añadir el arma " + nombre + ". Se superaría el límite de peso de " + LIMITE_PESO_MOCHILA + "kg");
        }
        mochila.add(nuevaArma);
        System.out.println("Arma " + nombre + " añadida a la mochila.");
    }

    public static void recogerPosicion(String nombre, double peso, int cantidad) throws MochilaSobrecargadaException {
        PocionMagica nuevaPocion = new PocionMagica(nombre, peso, cantidad);
        double pesoActual = 0;
        for (ItemInventario item : mochila) {
            pesoActual += item.calcularPesoEfectivo();
        }
        if (pesoActual + nuevaPocion.calcularPesoEfectivo() > LIMITE_PESO_MOCHILA) {
            throw new MochilaSobrecargadaException("No se puede añadir la poción " + nombre + ". Se superaría el límite de peso de " + LIMITE_PESO_MOCHILA + "kg");
        }
        mochila.add(nuevaPocion);
        System.out.println("Poción " + nombre + " añadida a la mochila.");
    }

    public static void tirarItem(String nombre) {
        boolean eliminado = mochila.removeIf(item -> item.getNombreItem().equalsIgnoreCase(nombre));
        if (!eliminado) {
            throw new ItemNoEncontradoException("No se encontró el ítem '" + nombre + "' en la mochila.");
        }
        System.out.println("Ítem '" + nombre + "' eliminado de la mochila.");
    }

    public static void inspeccionarMochila() {
        double pesoTotalMochila = 0;
        System.out.println("--- Contenido de la Mochila ---");
        for (ItemInventario item : mochila) {
            double pesoEfectivo = item.calcularPesoEfectivo();
            System.out.println(item.toString() + " | Peso Base: " + item.getPesoBase() + "kg | Peso Total Item: " + pesoEfectivo + "kg");
            pesoTotalMochila += pesoEfectivo;
        }
        System.out.println("-------------------------------");
        System.out.println("Peso total actual: " + pesoTotalMochila + " / " + LIMITE_PESO_MOCHILA + " kg");
    }
}


