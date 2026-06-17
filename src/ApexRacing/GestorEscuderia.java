package ApexRacing;

import java.util.ArrayList;

public class GestorEscuderia {

    private static final double LIMITE_COST_CAP= 150000;
    private static ArrayList<EmpleadoEscuderia> empleados= new ArrayList<>();


    public static void ficharPiloto(String nombre, double salario, TipoLicencia tipoLicencia) throws TechoGastoExcedidoException{
        double gastoActual = 0;
        for (EmpleadoEscuderia e : empleados) {
            gastoActual += e.getSalarioBase();
        }

        if (gastoActual + salario > LIMITE_COST_CAP) {
            throw new TechoGastoExcedidoException("No se puede fichar al piloto. Se excedería el límite de presupuesto de " + LIMITE_COST_CAP);
        }

        empleados.add(new Piloto(nombre, salario, tipoLicencia));
        System.out.println("Piloto añadido correctamente");
    }

    public static void contratarIngeniero(String nombre, double salario, String especialidad) throws TechoGastoExcedidoException{
        double gastoActual = 0;
        for (EmpleadoEscuderia e : empleados) {
            gastoActual += e.getSalarioBase();
        }

        if (gastoActual + salario > LIMITE_COST_CAP) {
            throw new TechoGastoExcedidoException("No se puede contratar al ingeniero. Se excedería el límite de presupuesto de " + LIMITE_COST_CAP);
        }

        empleados.add(new Ingeniero(nombre, salario, especialidad));
    }

    public static void despedirEmpleado(String nombre){
        //hay que usar removeIf
        boolean eliminado = empleados.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre));
        if (!eliminado) {
            throw new EmpleadoNoEncontradoException("No se encontró ningún empleado con el nombre: " + nombre);
        }
        System.out.println("Empleado despedido");
    }

    public static void verGastosTotales(){
        double totalSalarios = 0;
        double totalPlus = 0;

        System.out.println("--- Listado de Empleados y Gastos ---");
        for (EmpleadoEscuderia e : empleados) {
            double plus = e.calcularPlusObjetivos();
            System.out.println(e.toString() + " | Salario: " + e.getSalarioBase() + "€ | Plus: " + plus + "€");
            totalSalarios += e.getSalarioBase();
            totalPlus += plus;
        }

        System.out.println("-------------------------------------");
        System.out.println("Gasto total en salarios base: " + totalSalarios + "€");
        System.out.println("Gasto total en pluses: " + totalPlus + "€");
        System.out.println("Gasto total acumulado: " + (totalSalarios + totalPlus) + "€");
        System.out.println("Límite Cost Cap: " + LIMITE_COST_CAP + "€");

    }
}
