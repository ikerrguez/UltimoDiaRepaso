package FIA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            try {
                switch (opcion) {
                    case 1:
                        GestorEscuderia.contratarPiloto();
                        break;
                    case 2:
                        GestorEscuderia.contratarIngeniero();
                        break;
                    case 3:
                        GestorEscuderia.despedirEmpleado();
                        break;
                    case 4:
                        GestorEscuderia.mostrarNominasTotales();
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (CostCapSuperadoException | EmpleadoNoEncontradoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE ESCUDERÍA F1 ---");
        System.out.println("1. Contratar Piloto");
        System.out.println("2. Contratar Ingeniero");
        System.out.println("3. Despedir Empleado");
        System.out.println("4. Mostrar Nóminas Totales");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

}
