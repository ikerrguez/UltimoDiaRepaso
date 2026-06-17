package ApexRacing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean bandera= true;
        while (bandera){
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    try {
                        System.out.println("Dime el nombre del piloto");
                        String nombrePiloto = sc.nextLine();
                        System.out.println("Dime el salario del piloto");
                        double salarioPiloto = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("¿Qué tipo de licencia tiene el piloto?");
                        TipoLicencia tipoLicencia = TipoLicencia.valueOf(sc.nextLine().toUpperCase());
                        GestorEscuderia.ficharPiloto(nombrePiloto, salarioPiloto, tipoLicencia);
                    }catch (TechoGastoExcedidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Dime el nombre del ingeniero");
                        String nombreIngeniero = sc.nextLine();
                        System.out.println("Dime el salario del ingeniero");
                        double salarioIngeniero = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Dime la especialidad del ingeniero");
                        String especialidad = sc.nextLine();
                        GestorEscuderia.contratarIngeniero(nombreIngeniero, salarioIngeniero, especialidad);
                        System.out.println("Ingeniero contratado correctamente");
                    } catch (TechoGastoExcedidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Dime el nombre del empleado a despedir");
                        String nombreDespedir = sc.nextLine();
                        GestorEscuderia.despedirEmpleado(nombreDespedir);
                    } catch (EmpleadoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    GestorEscuderia.verGastosTotales();
                    break;
                case 5:
                    bandera= false;
                    System.out.println("Apagando motores... Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }

        }

    }

    public static void mostrarMenu(){
        System.out.println("--MENÚ INTERACTIVO--");
        System.out.println("1. Fichar piloto");
        System.out.println("2. Contratar ingeniero");
        System.out.println("3. Despedir empleado");
        System.out.println("4. Auditoria de boxes");
        System.out.println("5. Apagar motores(Salir)");
        System.out.println("Elige una opción");

    }
}
