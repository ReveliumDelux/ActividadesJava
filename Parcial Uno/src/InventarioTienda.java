import java.util.ArrayList;
import java.util.List;

public class InventarioTienda {
    private List<Producto> inventario;

    public InventarioTienda() {
        this.inventario = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
        System.out.println("Producto agregado al inventario: " + producto.getNombre());
    }

    public void venderProducto(String nombre, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.venderProducto(cantidad);
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario: " + nombre);
    }

    public void duplicarInventario(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.duplicarInventario();
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario: " + nombre);
    }

    public void mostrarInventario() {
        System.out.println("=== Inventario de la Tienda ===");
        for (Producto producto : inventario) {
            System.out.println(producto);
        }
    }
}