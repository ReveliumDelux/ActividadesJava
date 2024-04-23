package Reformulacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Operacion> operaciones = new ArrayList<>();

        while (true) {
            System.out.println("\tBienvenido a la Calculadora de área, perímetro y potencia");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Potencia");
            System.out.println("7. Mostrar resultados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción (0-7): ");

            int opcion = obtenerEntero(scanner);

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el radio del círculo: ");
                    double radioCirculo = obtenerDouble(scanner);
                    Circulo circulo = new Circulo(radioCirculo);
                    operaciones.add(circulo);
                    break;
                case 2:
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double ladoCuadrado = obtenerDouble(scanner);
                    Cuadrado cuadrado = new Cuadrado(ladoCuadrado);
                    operaciones.add(cuadrado);
                    break;
                case 3:
                    System.out.print("Ingrese la base del triángulo: ");
                    double baseTriangulo = obtenerDouble(scanner);
                    System.out.print("Ingrese la altura del triángulo: ");
                    double alturaTriangulo = obtenerDouble(scanner);
                    Triangulo triangulo = new Triangulo(baseTriangulo, alturaTriangulo);
                    operaciones.add(triangulo);
                    break;
                case 4:
                    System.out.print("Ingrese la base del rectángulo: ");
                    double baseRectangulo = obtenerDouble(scanner);
                    System.out.print("Ingrese la altura del rectángulo: ");
                    double alturaRectangulo = obtenerDouble(scanner);
                    Rectangulo rectangulo = new Rectangulo(baseRectangulo, alturaRectangulo);
                    operaciones.add(rectangulo);
                    break;
                case 5:
                    System.out.print("Ingrese la longitud del lado del pentágono: ");
                    double ladoPentagono = obtenerDouble(scanner);
                    Pentagono pentagono = new Pentagono(ladoPentagono);
                    operaciones.add(pentagono);
                    break;
                case 6:
                    System.out.print("Ingrese la base: ");
                    double basePotencia = obtenerDouble(scanner);
                    System.out.print("Ingrese el exponente: ");
                    int exponentePotencia = obtenerEntero(scanner);
                    Potencia potencia = new Potencia(basePotencia, exponentePotencia);
                    operaciones.add(potencia);
                    break;
                case 7:
                    mostrarResultados(operaciones);
                    break;
                case 0:
                    System.out.println("\t---- Gracias por utilizar la Calculadora de área, perímetro y potencia. ----");
                    scanner.close();
                    return;
                default:
                    System.out.println("\t---- inválido. Seleccione una opción válida. ----");
            }
        }
    }
    private static void mostrarResultados(List<Operacion> operaciones) {
        if (operaciones.isEmpty()) {
            System.out.println("\tNo hay operaciones realizadas.");
        } else {
            System.out.println("\n\tResultados:");
            for (Operacion operacion : operaciones) {
                operacion.mostrarResultado();
            }
        }
    }
    private static double obtenerDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        }
    }
    private static int obtenerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next();
            }
        }
    }
}