package inventario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SistemaInventario {
    private static Inventario inventario = new Inventario();
    private static ArrayList<Proveedor> proveedores = new ArrayList<>();
    private static ArrayList<OrdenDeCompra> ordenesDeCompra = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Agregar proveedores de ejemplo
        proveedores.add(new Proveedor(1, "Matias Castro", "matiascastro@gmail.com"));
        proveedores.add(new Proveedor(2, "Julieta Romero", "julietaromero@gmail.com"));
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Consultar Inventario");
            System.out.println("2. Registrar Entrada de Producto");
            System.out.println("3. Registrar Salida de Producto");
            System.out.println("4. Generar Reporte de Bajo Stock");
            System.out.println("5. Ver Proveedores");
            System.out.println("6. Crear Orden de Compra");
            System.out.println("7. Ver Órdenes de Compra");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    consultarInventario();
                    break;
                case 2:
                    registrarEntradaProducto();
                    break;
                case 3:
                    registrarSalidaProducto();
                    break;
                case 4:
                    generarReporteBajoStock();
                    break;
                case 5:
                    verProveedores();
                    break;
                case 6:
                    crearOrdenDeCompra();
                    break;
                case 7:
                    verOrdenesDeCompra();
                    break;
                case 8:
                    continuar = false;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void consultarInventario() {
        System.out.println("\n=== Consultar Inventario ===");
        inventario.mostrarInventario();
    }

    public static void registrarEntradaProducto() {
        System.out.println("\n=== Registrar Entrada de Producto ===");
        System.out.print("Ingrese el ID del producto: ");
        int idProducto = scanner.nextInt();
        System.out.print("Ingrese la cantidad a añadir: ");
        int cantidad = scanner.nextInt();
        
        if (inventario.registrarEntrada(idProducto, cantidad)) {
            System.out.println("Entrada registrada correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void registrarSalidaProducto() {
        System.out.println("\n=== Registrar Salida de Producto ===");
        System.out.print("Ingrese el ID del producto: ");
        int idProducto = scanner.nextInt();
        System.out.print("Ingrese la cantidad a retirar: ");
        int cantidad = scanner.nextInt();
        
        if (inventario.registrarSalida(idProducto, cantidad)) {
            System.out.println("Salida registrada correctamente.");
        } else {
            System.out.println("Producto no encontrado o cantidad insuficiente.");
        }
    }

    public static void generarReporteBajoStock() {
        System.out.println("\n=== Reporte de Productos con Bajo Stock ===");
        inventario.generarReporteBajoStock();
    }

    public static void verProveedores() {
        System.out.println("\n=== Lista de Proveedores ===");
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Proveedor proveedor : proveedores) {
                proveedor.mostrarDetalles();
            }
        }
    }

    public static void crearOrdenDeCompra() {
        System.out.println("\n=== Crear Orden de Compra ===");
        System.out.print("Ingrese el ID del producto para la orden de compra: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto producto = inventario.buscarProducto(idProducto);
        
        if (producto != null) {
            System.out.print("Ingrese la cantidad solicitada: ");
            int cantidadSolicitada = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            OrdenDeCompra nuevaOrden = new OrdenDeCompra(ordenesDeCompra.size() + 1, new Date(), cantidadSolicitada, "Pendiente", producto);
            ordenesDeCompra.add(nuevaOrden);
            
            System.out.println("Orden de compra creada exitosamente para el producto: " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void verOrdenesDeCompra() {
        System.out.println("\n=== Lista de Órdenes de Compra ===");
        if (ordenesDeCompra.isEmpty()) {
            System.out.println("No hay órdenes de compra registradas.");
        } else {
            for (OrdenDeCompra orden : ordenesDeCompra) {
                orden.mostrarDetalles();
            }
        }
    }
}
