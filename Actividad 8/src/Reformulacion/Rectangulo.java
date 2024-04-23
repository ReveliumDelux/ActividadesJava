package Reformulacion;

public class Rectangulo {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcular() {
        return base * altura;
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Rectángulo - Área: " + calcular());
    }
}