import java.util.ArrayList;
import java.util.Scanner;
import java.util List;
import java.util ArrayList;

public class Perimetros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\tBienvenido a la Calculadora de área y de perímetro");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("0. Salir");
            System.out.print("Seleccione una figura (0-5): ");
            int figura = scanner.nextInt();

            if (figura == 0) {
                System.out.println("Gracias por utilizar la Calculadora de de área y de perímetro ");
                break;
            }

            switch (figura) {
                case 1:
                    calcularCirculo(scanner);
                    break;
                case 2:
                    calcularCuadrado(scanner);
                    break;
                case 3:
                    calcularTriangulo(scanner);
                    break;
                case 4:
                    calcularRectangulo(scanner);
                    break;
                case 5:
                    calcularPentagono(scanner);
                    break;
                default:
                    System.out.println("Escriba correctamente el Número de la figura a Calcular");
            }
        }

        scanner.close();
    }

    private static void calcularCirculo(Scanner scanner) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();
        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;
        mostrarResultados("Círculo", area, perimetro);
    }

    private static void calcularCuadrado(Scanner scanner) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        double area = lado * lado;
        double perimetro = 4 * lado;
        mostrarResultados("Cuadrado", area, perimetro);
    }

    private static void calcularTriangulo(Scanner scanner) {
        System.out.print("Ingrese la base del triángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = scanner.nextDouble();
        double area = (base * altura) / 2;
        double perimetro = base * 3;
        mostrarResultados("Triángulo", area, perimetro);
    }

    private static void calcularRectangulo(Scanner scanner) {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = scanner.nextDouble();
        double area = base * altura;
        double perimetro = 2 * (base + altura);
        mostrarResultados("Rectángulo", area, perimetro);
    }

    private static void calcularPentagono(Scanner scanner) {
        System.out.print("Ingrese la longitud del lado del pentágono: ");
        double lado = scanner.nextDouble();
        double apotema = lado / (2 * Math.tan(Math.PI / 5));
        double area = (5 * lado * apotema) / 2;
        double perimetro = 5 * lado;
        mostrarResultados("Pentágono", area, perimetro);
    }

    private static void mostrarResultados(String figura, double area, double perimetro) {
        System.out.println("\nEl resultados para " + figura + ":");
        System.out.println("Área: " + area);
        System.out.println("Perímetro: " + perimetro + "\n");
    }
}