package AquaticSpeed;

import java.util.Scanner;

import static ApexRacing.Main.mostrarMenu;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bandera= true;
        while (bandera) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Fichar piloto...");
                        System.out.println("Dime su codigo de identifiacdor");
                        String codigoPiloto= sc.nextLine();
                        System.out.println("Dime su peso");
                        double pesoPiloto= sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Dime su tipo de equipamiento");
                        TipoEquipamiento tipoEquipamiento= TipoEquipamiento.valueOf(sc.nextLine().toUpperCase());
                        GestorLancha.anhadirPiloto(codigoPiloto, pesoPiloto, tipoEquipamiento);
                    }catch (PesoMaximoExcedidoException e){
                        System.out.println(e.getMessage());
                    }catch (IllegalArgumentException e){
                        System.out.println("Ese tipo de equipamiento no existe");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Subiendo motor...");
                        System.out.println("Dime su codigo de identifiacdor");
                        String codigoMotor= sc.nextLine();
                        System.out.println("Dime su peso");
                        double pesoMotor= sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Dime su tipo de combustible");
                        String tipoComb= sc.nextLine();
                        GestorLancha.anhadirMotor(codigoMotor, pesoMotor, tipoComb);
                        }catch (PesoMaximoExcedidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Elemento a retirar");
                        System.out.println("Dime el codigo del elemento a retirar");
                        String codigoRetirar= sc.nextLine();
                        GestorLancha.retirarElemento(codigoRetirar);
                    }catch (ElementoNoEncontradoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    GestorLancha.verCargaTotal();
                    break;
                case 5:
                    bandera= false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
            }
        }
    }

    public static void mostrarMenu(){
        System.out.println("--MENÚ INTERACTIVO--");
        System.out.println("1. Subir piloto");
        System.out.println("2. Subir motor");
        System.out.println("3. Retirar elemento");
        System.out.println("4. Auditoría de carga");
        System.out.println("5. Salir");
        System.out.println("Debes elegir una opción");
    }
}

