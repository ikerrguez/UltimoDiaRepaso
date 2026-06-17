package AquaticSpeed;

import java.util.ArrayList;

public class GestorLancha {
    private static final double LIMITE_WEIGHT_CAP= 2500;
    private static ArrayList<ElementoAcuatico> listaAgua= new ArrayList<>();

    protected static void anhadirPiloto(String codigo, double peso, TipoEquipamiento equipo) throws PesoMaximoExcedidoException{
        double pesoActual = 0;
        for (ElementoAcuatico e : listaAgua) {
            pesoActual += e.getPesoBase() + e.calcularPesoExtra();
        }

        PilotoAcuatico nuevoPiloto = new PilotoAcuatico(codigo, peso, equipo);
        double pesoNuevoElemento = nuevoPiloto.getPesoBase() + nuevoPiloto.calcularPesoExtra();

        if (pesoActual + pesoNuevoElemento > LIMITE_WEIGHT_CAP) {
            throw new PesoMaximoExcedidoException("No se puede añadir el piloto. Se excedería el límite de peso de " + LIMITE_WEIGHT_CAP + " kg.");
        }

        listaAgua.add(nuevoPiloto);
        System.out.println("Piloto acuático añadido correctamente.");
    }

    protected static void anhadirMotor(String codigo, double peso, String combustible) throws PesoMaximoExcedidoException{
        double pesoActual = 0;
        for (ElementoAcuatico e : listaAgua) {
            pesoActual += e.getPesoBase() + e.calcularPesoExtra();
        }

        MotorFueraborda nuevoMotor = new MotorFueraborda(codigo, peso, combustible);
        double pesoNuevoElemento = nuevoMotor.getPesoBase() + nuevoMotor.calcularPesoExtra();

        if (pesoActual + pesoNuevoElemento > LIMITE_WEIGHT_CAP) {
            throw new PesoMaximoExcedidoException("No se puede añadir el motor. Se excedería el límite de peso de " + LIMITE_WEIGHT_CAP + " kg.");
        }

        listaAgua.add(nuevoMotor);
        System.out.println("Motor acuático añadido correctamente.");
    }

    public static void retirarElemento(String codigo){
        boolean eliminado = listaAgua.removeIf(e -> e.getCodigoIdentificador().equalsIgnoreCase(codigo));
        if (!eliminado) {
            throw new ElementoNoEncontradoException("No se encontró ningún elemento con el código: " + codigo);
        }
        System.out.println("Elemento retirado de la lancha.");
    }

    public static void verCargaTotal(){
        double pesoTotalBase = 0;
        double pesoTotalExtra = 0;

        System.out.println("--- Estado de Carga de la Lancha ---");
        for (ElementoAcuatico e : listaAgua) {
            double pesoExtra = e.calcularPesoExtra();
            System.out.println(e.toString() + " | Peso Base: " + e.getPesoBase() + "kg | Peso Extra: " + pesoExtra + "kg");
            pesoTotalBase += e.getPesoBase();
            pesoTotalExtra += pesoExtra;
        }
        System.out.println("-------------------------------------");
        System.out.println("Peso total base: " + pesoTotalBase + "kg");
        System.out.println("Peso total extra: " + pesoTotalExtra + "kg");
        double pesoTotalAcumulado = pesoTotalBase + pesoTotalExtra;
        System.out.println("Peso total acumulado: " + pesoTotalAcumulado + "kg");
        System.out.println("Límite Weight Cap: " + LIMITE_WEIGHT_CAP + "kg");
        System.out.println("Capacidad disponible: " + (LIMITE_WEIGHT_CAP - pesoTotalAcumulado) + "kg");
    }
}
