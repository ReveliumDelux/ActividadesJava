import java.util.Scanner;

public class GestionInventario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventarioTienda inventario = new InventarioTienda();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Menú de Opciones ===");
            System.out.println("1. Agregar Producto al Inventario");
            System.out.println("2. Vender Producto");
            System.out.println("3. Duplicar Inventario de Producto Vendido");
            System.out.println("4. Mostrar Inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad inicial en inventario: ");
                    int cantidadInicial = scanner.nextInt();
                    scanner.nextLine();
                    Producto productoNuevo = new Producto(nombreProducto, cantidadInicial);
                    inventario.agregarProducto(productoNuevo);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String nombreVenta = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVenta = scanner.nextInt();
                    scanner.nextLine();
                    inventario.venderProducto(nombreVenta, cantidadVenta);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a duplicar: ");
                    String nombreDuplicar = scanner.nextLine();
                    inventario.duplicarInventario(nombreDuplicar);
                    break;
                case 4:
                    inventario.mostrarInventario();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor seleccione una opción válida.");
                    break;
            }
        }
    }
}