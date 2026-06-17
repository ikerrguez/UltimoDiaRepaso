package FairPlay;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) {
            mostrarMenus();
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpieza de buffer tras leer entero

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("--- INSCRIBIR FUTBOLISTA ---");
                        System.out.println("Introduce el dorsal del jugador:");
                        int dorsal = sc.nextInt();
                        sc.nextLine(); // Limpieza de buffer

                        System.out.println("Introduce el nombre del futbolista:");
                        String nombre = sc.nextLine();

                        System.out.println("Introduce el sueldo base mensual:");
                        double sueldo = sc.nextDouble();
                        sc.nextLine(); // Limpieza de buffer

                        System.out.println("Introduce la demarcación (DEFENSA, CENTROCAMPISTA, DELANTERO):");
                        Demarcacion dem = Demarcacion.valueOf(sc.nextLine().toUpperCase().trim());

                        GestorPlantilla.inscribirFutbolista(dorsal, nombre, sueldo, dem);

                    } catch (LimiteSalarialExcedidoException e) {
                        System.out.println("Error Financiero: " + e.getMessage());
                    } catch (DorsalDuplicadoException e) {
                        System.out.println("Error de Plantilla: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: Esa demarcación no existe.");
                    }
                    break;

                case 2:
                    try {
                        System.out.println("--- INSCRIBIR PORTERO ---");
                        System.out.println("Introduce el dorsal del portero:");
                        int dorsalPortero = sc.nextInt();
                        sc.nextLine(); // Limpieza de buffer

                        System.out.println("Introduce el nombre del portero:");
                        String nombrePortero = sc.nextLine();

                        System.out.println("Introduce el sueldo base mensual:");
                        double sueldoPortero = sc.nextDouble();
                        sc.nextLine(); // Limpieza de buffer

                        System.out.println("Introduce el número de partidos imbatido:");
                        int imbatido = sc.nextInt();
                        sc.nextLine(); // Limpieza de buffer

                        GestorPlantilla.inscribirPortero(dorsalPortero, nombrePortero, sueldoPortero, imbatido);

                    } catch (LimiteSalarialExcedidoException e) {
                        System.out.println("Error Financiero: " + e.getMessage());
                    } catch (DorsalDuplicadoException e) {
                        System.out.println("Error de Plantilla: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("--- DAR DE BAJA JUGADOR ---");
                        System.out.println("Introduce el dorsal del jugador a dar de baja:");
                        int dorsalBaja = sc.nextInt();
                        sc.nextLine(); // Limpieza de buffer

                        GestorPlantilla.darDeBajaJugador(dorsalBaja);

                    } catch (NoSuchElementException e) {
                        System.out.println("Error de Selección: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Auditoría financiera en una sola línea de código
                    GestorPlantilla.verMasaSalarial();
                    break;

                case 5:
                    bandera = false;
                    System.out.println("Cerrando el mercado de fichajes... Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
            }
        }
        sc.close(); // Cerramos el Scanner al finalizar el bucle
    }

    private static void mostrarMenus() {
        System.out.println("\n-- MENÚ INTERACTIVO REAL CLUB BALOMPIÉ --");
        System.out.println("1. Inscribir futbolista");
        System.out.println("2. Inscribir portero");
        System.out.println("3. Dar de baja jugador");
        System.out.println("4. Auditoria financiera");
        System.out.println("5. Salir");
        System.out.println("Elige una opción:");
    }
}