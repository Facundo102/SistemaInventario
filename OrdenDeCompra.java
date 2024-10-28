package inventario;

import java.util.Date;

public class OrdenDeCompra {
    private int idOrden;
    private Date fecha;
    private int cantidadSolicitada;
    private String estadoOrden;
    private Producto producto;

    public OrdenDeCompra(int idOrden, Date fecha, int cantidadSolicitada, String estadoOrden, Producto producto) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.cantidadSolicitada = cantidadSolicitada;
        this.estadoOrden = estadoOrden;
        this.producto = producto;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void mostrarDetalles() {
        System.out.println("ID Orden: " + idOrden + ", Fecha: " + fecha + ", Cantidad Solicitada: " + cantidadSolicitada + 
                           ", Estado: " + estadoOrden + ", Producto: " + producto.getNombre());
    }
}
