
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Articulo> inventario = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    editarArticulo();
                    break;
                case 3:
                    buscarArticuloPorCodigoBarras();
                    break;
                case 4:
                    eliminarArticulo();
                    break;
                case 5:
                    buscarArticulosPorNombre();
                    break;
                case 6:
                    mostrarArticulos();
                    break;
                case 7:
                    buscarArticuloPorId();
                    break;
                case 8:
                    crearTicket();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1- Agregar nuevo artículo");
        System.out.println("2- Editar datos de un artículo");
        System.out.println("3- Buscar un artículo por código de barras");
        System.out.println("4- Eliminar un artículo");
        System.out.println("5- Buscar artículos por nombre");
        System.out.println("6- Mostrar una lista de artículos disponibles");
        System.out.println("7- Buscar por id");
        System.out.println("8- Crear ticket");
        System.out.println("0- Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarArticulo() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código de barras: ");
        String codigoBarras = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Existencia: ");
        int existencia = scanner.nextInt();
        Articulo articulo = new Articulo(id, nombre, codigoBarras, precio, existencia);
        inventario.add(articulo);
        System.out.println("Artículo agregado.");
    }

    private static void editarArticulo() {
        System.out.print("Ingrese el ID del artículo a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Articulo articulo = buscarArticuloPorId(id);
        if (articulo != null) {
            System.out.print("Nuevo nombre: ");
            articulo.setNombre(scanner.nextLine());
            System.out.print("Nuevo código de barras: ");
            articulo.setCodigoBarras(scanner.nextLine());
            System.out.print("Nuevo precio: ");
            articulo.setPrecio(scanner.nextDouble());
            System.out.print("Nueva existencia: ");
            articulo.setExistencia(scanner.nextInt());
            System.out.println("Artículo editado.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static void buscarArticuloPorCodigoBarras() {
        System.out.print("Ingrese el código de barras: ");
        String codigoBarras = scanner.nextLine();
        for (Articulo articulo : inventario) {
            if (articulo.getCodigoBarras().equals(codigoBarras)) {
                System.out.println(articulo);
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    private static void eliminarArticulo() {
        System.out.print("Ingrese el ID del artículo a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Articulo articulo = buscarArticuloPorId(id);
        if (articulo != null) {
            inventario.remove(articulo);
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static void buscarArticulosPorNombre() {
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        for (Articulo articulo : inventario) {
            if (articulo.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(articulo);
            }
        }
    }

    private static void mostrarArticulos() {
        if (inventario.isEmpty()) {
            System.out.println("No hay artículos en el inventario.");
        } else {
            for (Articulo articulo : inventario) {
                System.out.println(articulo);
            }
        }
    }

    private static void buscarArticuloPorId() {
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();
        Articulo articulo = buscarArticuloPorId(id);
        if (articulo != null) {
            System.out.println(articulo);
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static Articulo buscarArticuloPorId(int id) {
        for (Articulo articulo : inventario) {
            if (articulo.getId() == id) {
                return articulo;
            }
        }
        return null;
    }

    private static void crearTicket() {
        Ticket ticket = new Ticket();
        while (true) {
            System.out.print("Ingrese el ID del artículo a agregar al ticket (0 para terminar): ");
            int id = scanner.nextInt();
            if (id == 0) break;
            Articulo articulo = buscarArticuloPorId(id);
            if (articulo != null) {
                System.out.print("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                ticket.agregarProducto(articulo, cantidad);
            } else {
                System.out.println("Artículo no encontrado.");
            }
        }
        System.out.print("Ingrese el pago del cliente: ");
        double pagoCliente = scanner.nextDouble();
        ticket.pagar(pagoCliente);
        ticket.imprimirTicket();
    }
}