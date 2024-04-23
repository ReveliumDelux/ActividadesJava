import java.util.Scanner;

public class Identificacion {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String nom, ced;
            int edad, cantidadVisitas = 0, totalEdad = 0;
            char genero;

            System.out.println("Ingrese la cantidad de visitas a registrar:");
            int cantidadTotalVisitas = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= cantidadTotalVisitas; i++) {

                System.out.println("\nIngrese el nombre del visitante:");
                nom = scanner.nextLine();
                System.out.println("\nIngrese la cédula del visitante:");
                ced = scanner.nextLine();
                System.out.println("\nIngrese la edad del visitante:");
                edad = scanner.nextInt();
                totalEdad += edad;
                scanner.nextLine();

                System.out.println("\nIngrese el género del visitante (M/F):");
                genero = scanner.next().charAt(0);

                cantidadVisitas++;
                double promedioEdad = (double) totalEdad / cantidadVisitas;

                System.out.println("\n\tInformación del visitante en PH Eric:");

                System.out.println("\n\tNombre: " + nom);
                System.out.println("\n\tCédula: " + ced);
                System.out.println("\n\tEdad: " + edad);
                System.out.println("\n\tGénero: " + genero);
                String mensajeEdad;
                if (promedioEdad >= 18) {
                    mensajeEdad = "Puede acceder";
                } else {
                    mensajeEdad = "No puede acceder";
                }
                System.out.println("\n\tCantidad total de visitas: " + cantidadVisitas);
                System.out.println("\n\tSu edad es de: " + promedioEdad + " años");
                System.out.println("\n\tEl visitante " + mensajeEdad);
            }


            scanner.close();
        }
}
