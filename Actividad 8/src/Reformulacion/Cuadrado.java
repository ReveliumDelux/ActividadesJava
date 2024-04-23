package Reformulacion;

public class Cuadrado {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcular() {
        return lado * lado;
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Cuadrado - Área: " + calcular());
    }
}
