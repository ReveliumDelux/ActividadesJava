import java.util.Scanner;
public class DatosDeVisitantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nomb, ced;
        int edad;
        char genero;
        boolean esResidente;

        System.out.println("\nIngrese el nombre del visitante:");
        nomb = scanner.nextLine();
        System.out.println("\nIngrese la ced del visitante:");
        ced = scanner.nextLine();
        System.out.println("\nIngrese la edad del visitante:");
        edad = scanner.nextInt();
        System.out.println("\nIngrese el género del visitante (M/F):");
        genero = scanner.next().charAt(0);
        System.out.println("¿\nEs residente de PH Eric? (si/no):");
        String respuesta = scanner.next();
        if (respuesta.equalsIgnoreCase("si")) {
            esResidente = true;
        } else {
            esResidente = false;
        }

        System.out.println("\n\t\tInformación del visitante:");
        System.out.println("\n\tNombre: " + nomb);
        System.out.println("\n\tCedula: " + ced);
        System.out.println("\n\tEdad: " + edad);
        System.out.println("\n\tGénero: " + genero);
        System.out.println("¿\n\tEs residente?: " + esResidente);

        scanner.close();
    }
}