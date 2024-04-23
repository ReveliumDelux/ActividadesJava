import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class ArregloDeCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> resultados = new ArrayList<>();

        while (true) {
            System.out.println("\tBienvenido a la Calculadora de área y de perímetro");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Mostrar resultados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una figura (0-6): ");

            int figura = obtenerEntero(scanner);

            if (figura == 0) {
                System.out.println("Gracias por utilizar la Calculadora de área y de perímetro");
                break;
            }

            switch (figura) {
                case 1:
                    calcularCirculo(scanner, resultados);
                    break;
                case 2:
                    calcularCuadrado(scanner, resultados);
                    break;
                case 3:
                    calcularTriangulo(scanner, resultados);
                    break;
                case 4:
                    calcularRectangulo(scanner, resultados);
                    break;
                case 5:
                    calcularPentagono(scanner, resultados);
                    break;
                case 6:
                    mostrarResultados(resultados);
                    break;
                default:
                    System.out.println("Escriba correctamente el Número de la figura a Calcular");
            }
        }

        scanner.close();
    }

    private static void calcularCirculo(Scanner scanner, List<String> resultados) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = obtenerDouble(scanner);
        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;
        resultados.add("Círculo - Área: " + area + ", Perímetro: " + perimetro);
        System.out.println("Cálculos para Círculo almacenados.");
    }

    private static void calcularCuadrado(Scanner scanner, List<String> resultados) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = obtenerDouble(scanner);
        double area = lado * lado;
        double perimetro = 4 * lado;
        resultados.add("Cuadrado - Área: " + area + ", Perímetro: " + perimetro);
        System.out.println("Cálculos para Cuadrado almacenados.");
    }

    private static void calcularTriangulo(Scanner scanner, List<String> resultados) {
        System.out.print("Ingrese la base del triángulo: ");
        double base = obtenerDouble(scanner);
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = obtenerDouble(scanner);
        double area = (base * altura) / 2;
        double perimetro = base * 3;
        resultados.add("Triángulo - Área: " + area + ", Perímetro: " + perimetro);
        System.out.println("Cálculos para Triángulo almacenados.");
    }

    private static void calcularRectangulo(Scanner scanner, List<String> resultados) {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = obtenerDouble(scanner);
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = obtenerDouble(scanner);
        double area = base * altura;
        double perimetro = 2 * (base + altura);
        resultados.add("Rectángulo - Área: " + area + ", Perímetro: " + perimetro);
        System.out.println("Cálculos para Rectángulo almacenados.");
    }

    private static void calcularPentagono(Scanner scanner, List<String> resultados) {
        System.out.print("Ingrese la longitud del lado del pentágono: ");
        double lado = obtenerDouble(scanner);
        double apotema = lado / (2 * Math.tan(Math.PI / 5));
        double area = (5 * lado * apotema) / 2;
        double perimetro = 5 * lado;
        resultados.add("Pentágono - Área: " + area + ", Perímetro: " + perimetro);
        System.out.println("Cálculos para Pentágono almacenados.");
    }

    private static void mostrarResultados(List<String> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No hay resultados para mostrar.");
        } else {
            System.out.println("\nResultados almacenados:");
            for (String resultado : resultados) {
                System.out.println(resultado);
            }
            System.out.println();
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