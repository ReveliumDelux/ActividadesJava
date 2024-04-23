//El codigo tiene un poquito de Chat GPT

public class Producto {
    private String nombre;
    private int cantidadInicial;
    private int cantidadVendida;

    public Producto(String nombre, int cantidadInicial) {
        this.nombre = nombre;
        this.cantidadInicial = cantidadInicial;
        this.cantidadVendida = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public int getCantidadInicial() {
        return cantidadInicial;
    }
    public int getCantidadVendida() {
        return cantidadVendida;
    }
    public void venderProducto(int cantidad) {
        if (cantidad <= cantidadInicial - cantidadVendida) {
            cantidadVendida += cantidad;
            System.out.println("Venta realizada: Se vendieron " + cantidad + " unidades de " + nombre + ".");
        } else {
            System.out.println("No hay suficiente stock para vender " + cantidad + " unidades de " + nombre + ".");
        }
    }

    public void duplicarInventario() {
        cantidadInicial += cantidadInicial - cantidadVendida;
        cantidadVendida = 0;
        System.out.println("Inventario de " + nombre + " duplicado.");
    }

    public int obtenerDisponibilidad() {
        return cantidadInicial - cantidadVendida;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Inventario: " + cantidadInicial + ", Vendido: " + cantidadVendida +
                ", Disponible: " + obtenerDisponibilidad();
    }
}