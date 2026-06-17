package PixelStudio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorEmpresa gestorEmpresa = new GestorEmpresa();
        boolean bandera = true;
        while (bandera) {
            int opcion = sc.nextInt();
            mostrarMenu();
            switch (opcion) {
                case 1:
                    System.out.println("Dime tu dni");
                    String dni= sc.nextLine();
                    System.out.println("Dime tu nombre");
                    String nombreDesarrollador= sc.nextLine();
                    System.out.println("Dime tu salario");
                    double salarioDesa= sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Dime el lenguaje");
                    String lenguaje = sc.nextLine();
                    Desarrollador desarrollador= new Desarrollador(nombreDesarrollador,salarioDesa,dni,Lenguaje.valueOf(lenguaje));
                    //AQUI HAY QUE FIJARSE PORQ LENGUAJE ES ENUM
                    try {
                        gestorEmpresa.contratarDesarrollador();
                    } catch (PresupuestoSuperadoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Dime tu dni");
                    String dniDis= sc.nextLine();
                    System.out.println("Dime tu nombre");
                    String nombreDis= sc.nextLine();
                    System.out.println("Dime tu salario");
                    double salarioDis= sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Dime la herramienta");
                    String herramienta= sc.nextLine();
                    Disenhador diseñador= new Disenhador(nombreDis,salarioDis,herramienta,dniDis);



            }

        }


        }
    public static void mostrarMenu () {
        System.out.println("MENU");
        System.out.println("1. Contratar desarrollador");
        System.out.println("2. Contratar diseñador");
        System.out.println("3. Despedir trabajador");
        System.out.println("4. Mostrar trabajadores");
        System.out.println("5. Salir");
    }
}
