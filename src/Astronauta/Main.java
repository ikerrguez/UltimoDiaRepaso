package Astronauta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorAgencia gestorAgencia = new GestorAgencia();
        boolean bandera= true;
        while (bandera) {
            mostrarMenu();
            int opcion= sc.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        gestorAgencia.contratarAstronauta();
                    } catch (PresupuestoAgotadoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        gestorAgencia.contratarIngeniero();
                    } catch (PresupuestoAgotadoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        gestorAgencia.despedirEmpleado();
                    } catch (EmpleadoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try {
                        gestorAgencia.mostrarEmpleados();
                    } catch (EmpleadoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    bandera=false;
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
    public static void mostrarMenu(){
        System.out.println("MENU");
        System.out.println("1. Contratar astronauta");
        System.out.println("2. Contratar ingeniero");
        System.out.println("3. Despedir empleado");
        System.out.println("4. Mostrar enpleados");
        System.out.println("5. Salir");
    }
}
