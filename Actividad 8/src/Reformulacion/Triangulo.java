package Reformulacion;

public class Triangulo {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcular() {
        return (base * altura) / 2;
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Triángulo - Área: " + calcular());
    }
}