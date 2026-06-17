package PixelStudio;

import java.util.HashMap;
import java.util.Scanner;

public class GestorEmpresa {
    private static final double PRESUPUESTO_MAXIMO= 20000;
    private static HashMap<String, Trabajador> trabajadores= new HashMap<>();


    public void contratarDesarrollador() throws PresupuestoSuperadoException {
        double gastoActual = 0;
        for (Trabajador t : trabajadores.values()) {
            gastoActual += t.getSalarioBase();
        }
        if ((gastoActual) > PRESUPUESTO_MAXIMO) {
            throw new PresupuestoSuperadoException("Error: El presupuesto de " + PRESUPUESTO_MAXIMO + "€ sería superado.");
        }

        System.out.println("Desarrollador contratado correctamente.");
    }

    public void despedirTrabajador(String dni) throws PresupuestoSuperadoException{
        if (trabajadores.containsKey(dni)) {
            trabajadores.remove(dni);
        }else{
            throw new TrabajadorNoExisteException("No existe el trabajador");
        }
    }

    public void mostrarTrabajadores(){

    }





}
