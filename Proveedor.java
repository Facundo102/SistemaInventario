package inventario;

public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String contacto;

    public Proveedor(int idProveedor, String nombre, String contacto) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void mostrarDetalles() {
        System.out.println("ID Proveedor: " + idProveedor + ", Nombre: " + nombre + ", Contacto: " + contacto);
    }
}
