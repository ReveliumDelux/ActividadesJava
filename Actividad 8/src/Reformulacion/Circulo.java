package Reformulacion;

public class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcular() {
        return Math.PI * radio * radio;
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Círculo - Área: " + calcular());
    }
}
