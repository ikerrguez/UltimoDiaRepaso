package Astronauta;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorAgencia {

    private static final double PRESUPUESTO_MAXIMO = 15000;
    private static ArrayList<Empleado> astronautaseingenieros= new ArrayList<>();

    public void contratarAstronauta() throws PresupuestoAgotadoException {
        double nuevoSalario=0;
        for(Empleado e: astronautaseingenieros){
            nuevoSalario= nuevoSalario+e.getSalarioBase();
        }
        if(nuevoSalario>PRESUPUESTO_MAXIMO){
            throw new PresupuestoAgotadoException("Te pasas de guita");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu nombre");
        String nombre = sc.nextLine();
        System.out.println("Dime tu salario base");
        double salarioBase = sc.nextDouble();
        sc.nextLine();
        System.out.println("Dime tu especialidad");
        String especialidad = sc.nextLine();
        Astronauta astronauta= new Astronauta(nombre,salarioBase,Especialidad.valueOf(especialidad));

        astronautaseingenieros.add(astronauta);
        System.out.println("Astronauta añadido");
    }

    public void contratarIngeniero() throws PresupuestoAgotadoException {
        double nuevoSalario=0;
        for(Empleado e: astronautaseingenieros){
            nuevoSalario= nuevoSalario+e.getSalarioBase();
        }
        if(nuevoSalario>PRESUPUESTO_MAXIMO){
            throw new PresupuestoAgotadoException("Te pasas de guita");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu nombre");
        String nombreIngeniero = sc.nextLine();
        System.out.println("Dime tu salario base");
        double salarioBaseIngeniero = sc.nextDouble();
        sc.nextLine();
        System.out.println("Dime tu proyecto");
        String proyecto = sc.nextLine();
        Ingeniero ingeniero= new Ingeniero(nombreIngeniero,salarioBaseIngeniero,proyecto);

        astronautaseingenieros.add(ingeniero);
        System.out.println("Ingeniero añadido");
    }

    public void despedirEmpleado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el nombre del empleado a despedir:");
        String nombre = sc.nextLine();

        boolean eliminado = astronautaseingenieros.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre));

        if (!eliminado) {
            throw new EmpleadoNoEncontradoException("No se encontró ningún empleado con el nombre: " + nombre);
        }
        System.out.println("Empleado despedido correctamente.");

    }

    public void mostrarEmpleados() {
        double gastoTotal = 0;
        System.out.println("--- LISTADO DE EMPLEADOS ---");

        for (Empleado e : astronautaseingenieros) {
            double bonus = e.calcularIncentivo();
            double total = e.getSalarioBase() + bonus;
            gastoTotal += total;

            String tipo = (e instanceof Astronauta) ? "Astronauta" : "Ingeniero";

            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Tipo: " + tipo);
            System.out.println("Salario base: " + e.getSalarioBase() + "€");
            System.out.println("Bonus: " + bonus + "€");
            System.out.println("Total: " + total + "€");
            System.out.println("---------------------------");
        }

        System.out.println("Gasto total mensual: " + gastoTotal + "€");
    }
}
