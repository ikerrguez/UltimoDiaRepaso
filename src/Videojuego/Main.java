package Videojuego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("--- RECOGER ARMA DE COMBATE ---");
                        System.out.println("Introduce el nombre del arma:");
                        String nombreArma = sc.nextLine();

                        System.out.println("Introduce el peso base (en kg):");
                        double pesoArma = sc.nextDouble();
                        sc.nextLine(); // Limpieza de buffer

                        System.out.println("Introduce el material (HIERRO, ACERO, MITHRIL):");
                        TipoMaterial material = TipoMaterial.valueOf(sc.nextLine().toUpperCase().trim());

                        GestorMochila.recogerArma(nombreArma, pesoArma, material);
                    } catch (MochilaSobrecargadaException e) {
                        System.out.println("ERROR DE INVENTARIO: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: El material introducido no es válido en este reino.");
                    }
                    break;

                case 2:
                    try {
                        System.out.println("--- RECOGER POCIÓN MÁGICA ---");
                        System.out.println("Introduce el nombre de la poción:");
                        String nombrePocion = sc.nextLine();

                        System.out.println("Introduce el peso base (en kg):");
                        double pesoPocion = sc.nextDouble();
                        sc.nextLine(); // Limpieza de buffer

                        System.out.println("Introduce la cantidad en mililitros (ml):");
                        int ml = sc.nextInt();
                        sc.nextLine(); // Limpieza de buffer vital antes de la siguiente iteración

                        GestorMochila.recogerPosicion(nombrePocion, pesoPocion, ml);
                    } catch (MochilaSobrecargadaException e) {
                        System.out.println("ERROR DE INVENTARIO: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("--- TIRAR ÍTEM DE LA MOCHILA ---");
                        System.out.println("Introduce el nombre del ítem que quieres tirar:");
                        String nombreTirar = sc.nextLine();

                        GestorMochila.tirarItem(nombreTirar);
                    } catch (ItemNoEncontradoException e) {
                        System.out.println("ERROR DE ACCIÓN: " + e.getMessage());
                    }
                    break;

                case 4:
                    GestorMochila.inspeccionarMochila();
                    break;

                case 5:
                    bandera = false;
                    System.out.println("Cerrando el inventario. Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción no válida. Prueba otra acción en tu menú de aventurero.");
            }
        }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MOCHILA DE AVENTURERO (MYTHIC CHRONICLES) ===");
        System.out.println("1. Recoger Arma");
        System.out.println("2. Recoger Poción");
        System.out.println("3. Tirar Ítem");
        System.out.println("4. Inspeccionar Mochila (Auditoría de Peso)");
        System.out.println("5. Salir del Juego");
        System.out.println("Elige tu próxima acción:");
    }
}