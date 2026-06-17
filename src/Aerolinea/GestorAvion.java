package Aerolinea;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class GestorAvion {
    private static final double PESO_MAXIMO= 100000;
    private static HashMap<String, CargaAerea> maletasycontenedores= new HashMap<>();

    public void registrarMaleta(String codigo, String descripcion, double pesoBase, ClaseBilletaje claseBilletaje) throws PesoMaximoExcedidoException {
        if (maletasycontenedores.containsKey(codigo)) {
            throw new CodigoDuplicadoException("El código de etiqueta " + codigo + " ya existe.");
        }

        double pesoActual = 0;
        for (CargaAerea carga : maletasycontenedores.values()) {
            pesoActual += carga.getPesoBase();
        }

        if (pesoActual + pesoBase > PESO_MAXIMO) {
            throw new PesoMaximoExcedidoException("No se puede registrar la maleta: se supera el peso máximo permitido.");
        }

        maletasycontenedores.put(codigo, new Maleta(descripcion, pesoBase, claseBilletaje));
    }

    public void registrarContenedor(String codigo, String descripcion, double pesoBase, String tipoMercancia) throws PesoMaximoExcedidoException {
        if (maletasycontenedores.containsKey(codigo)) {
            throw new CodigoDuplicadoException("El código de contenedor " + codigo + " ya existe.");
        }

        double pesoActual = 0;
        for (CargaAerea carga : maletasycontenedores.values()) {
            pesoActual += carga.getPesoBase();
        }

        if (pesoActual + pesoBase > PESO_MAXIMO) {
            throw new PesoMaximoExcedidoException("No se puede registrar el contenedor: se supera el peso máximo permitido.");
        }

        maletasycontenedores.put(codigo, new Contenedor(descripcion, pesoBase, tipoMercancia));
    }

    public void retirarCarga(String codigo) {
        if (!maletasycontenedores.containsKey(codigo)) {
            throw new NoSuchElementException("No se encontró ninguna carga con el código: " + codigo);
        }
        maletasycontenedores.remove(codigo);
    }

    public void mostrarManifiestoCarga() {
        double pesoTotalAcumulado = 0;
        System.out.println("--- MANIFIESTO DE CARGA ---");

        for (CargaAerea carga : maletasycontenedores.values()) {
            double pesoTotalElemento = carga.getPesoBase() + carga.calcularPlusPeso();
            pesoTotalAcumulado += pesoTotalElemento;

            String tipoInfo = "";
            if (carga instanceof Maleta) {
                tipoInfo = "Maleta (" + ((Maleta) carga).getClaseBilletaje() + ")";
            } else if (carga instanceof Contenedor) {
                tipoInfo = "Contenedor (" + ((Contenedor) carga).getTipoMercancia() + ")";
            }

            System.out.println("Descripción: " + carga.getDescripcion() +
                    " | Tipo: " + tipoInfo +
                    " | Peso Total: " + pesoTotalElemento + " kg");
        }

        System.out.println("---------------------------");
        System.out.println("Peso total real transportado por el avión: " + pesoTotalAcumulado + " kg");
    }





}
