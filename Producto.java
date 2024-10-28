package inventario;

public class Producto {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private int umbralMinimo;

    public Producto(int idProducto, String nombre, int cantidad, int umbralMinimo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.umbralMinimo = umbralMinimo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getUmbralMinimo() {
        return umbralMinimo;
    }

    public boolean esBajoStock() {
        return this.cantidad < this.umbralMinimo;
    }

    public void mostrarDetalles() {
        System.out.println("ID: " + idProducto + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Umbral: " + umbralMinimo);
    }
}
