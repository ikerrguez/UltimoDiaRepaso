    package FIA;

    import Astronauta.Empleado;

    import java.util.ArrayList;
    import java.util.Scanner;

    public class GestorEscuderia {
        private static final double LIMITE_FIA = 250000;
        private static ArrayList<EmpleadoF1> pilotoseingenieros = new ArrayList<>();

        public static void contratarPiloto() throws CostCapSuperadoException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dime el nombre");
            String nombrePiloto = sc.nextLine();
            System.out.println("Dime el apellido");
            String apellidoPiloto = sc.nextLine();
            System.out.println("Dime el sueldoBase");
            double sueldoBasePiloto = sc.nextDouble();
            sc.nextLine();
            System.out.println("Dime la categoria");
            String categoria = sc.nextLine();

            double gastoActual = 0;
            for (EmpleadoF1 emp : pilotoseingenieros) {
                gastoActual = gastoActual + emp.getSueldoBase();
            }
            if (gastoActual + sueldoBasePiloto > LIMITE_FIA) {
                throw new CostCapSuperadoException("Te pasas de pasta");
            }
            Piloto piloto = new Piloto(nombrePiloto, apellidoPiloto, sueldoBasePiloto, CategoriaPiloto.valueOf(categoria.toUpperCase().trim()));
            pilotoseingenieros.add(piloto);
        }

        public static void contratarIngeniero() throws CostCapSuperadoException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dime el nombre");
            String nombreIngeniero = sc.nextLine();
            System.out.println("Dime el apellido");
            String apellidoIngeniero = sc.nextLine();
            System.out.println("Dime el sueldoBase");
            double sueldoBaseIngeniero = sc.nextDouble();
            sc.nextLine();
            System.out.println("Dime la especialidad");
            String especialidad = sc.nextLine();
            double gastoActual = 0;
            for (EmpleadoF1 emp : pilotoseingenieros) {
                gastoActual += emp.getSueldoBase();
            }
            if (gastoActual + sueldoBaseIngeniero > LIMITE_FIA) {
                throw new CostCapSuperadoException("Te pasas de pasta");
            }
            Ingeniero ingeniero = new Ingeniero(nombreIngeniero, apellidoIngeniero, sueldoBaseIngeniero, especialidad);
            pilotoseingenieros.add(ingeniero);
            System.out.println("Ingeniero añadido correctamente");
        }

        public static void despedirEmpleado() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dime el nombre del empleado a despedir:");
            String nombre = sc.nextLine();

            boolean eliminado = pilotoseingenieros.removeIf(emp -> emp.getNombre().equalsIgnoreCase(nombre));

            if (!eliminado) {
                throw new EmpleadoNoEncontradoException("El empleado con nombre " + nombre + " no existe en la escudería.");
            } else {
                System.out.println("Empleado despedido correctamente.");
            }
        }


        public static void mostrarNominasTotales() {
            double gastoTotalMes = 0;
            for (EmpleadoF1 emp : pilotoseingenieros) {
                double bonus = emp.calcularBonusRendimiento();
                double sueldoTotal = emp.getSueldoBase() + bonus;
                gastoTotalMes += sueldoTotal;

                System.out.println("Nombre: " + emp.getNombre() + " " + emp.getApellido());
                System.out.println("Sueldo Total: " + sueldoTotal + "€");
                System.out.println("-----------------------------");
            }
            System.out.println("Gasto total del club este mes: " + gastoTotalMes + "€");
        }

    }
