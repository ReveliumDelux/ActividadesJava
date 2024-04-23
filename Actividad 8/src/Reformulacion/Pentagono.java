package Reformulacion;

public class Pentagono {
    private double lado;

    public Pentagono(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcular() {
        double apotema = lado / (2 * Math.tan(Math.PI / 5));
        return (5 * lado * apotema) / 2;
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Pentágono - Área: " + calcular());
    }
}