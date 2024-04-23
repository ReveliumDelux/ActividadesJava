package Reformulacion;

public class Potencia {
    private double base;
    private int exponente;

    public Potencia(double base, int exponente) {
        this.base = base;
        this.exponente = exponente;
    }

    @Override
    public double calcular() {
        return Math.pow(base, exponente);
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Potencia - Resultado: " + calcular());
    }
}