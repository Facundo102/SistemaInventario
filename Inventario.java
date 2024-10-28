package inventario;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
        // Ejemplo de productos iniciales
        productos.add(new Producto(1, "Tornillos", 50, 20));
        productos.add(new Producto(2, "Martillos", 15, 5));
        productos.add(new Producto(3, "Clavos", 200, 100));
    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : productos) {
                producto.mostrarDetalles();
            }
        }
    }

    public boolean registrarEntrada(int idProducto, int cantidad) {
        Producto producto = buscarProducto(idProducto);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);
            return true;
        }
        return false;
    }

    public boolean registrarSalida(int idProducto, int cantidad) {
        Producto producto = buscarProducto(idProducto);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
            return true;
        }
        return false;
    }

    public void generarReporteBajoStock() {
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.esBajoStock()) {
                producto.mostrarDetalles();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay productos con bajo stock.");
        }
    }

    public Producto buscarProducto(int idProducto) {
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        return null;
    }
}
