
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private List<Articulo> articulos;
    private double totalVenta;
    private double pagoCliente;
    private double cambio;

    public Ticket() {
        this.articulos = new ArrayList<>();
        this.totalVenta = 0.0;
        this.pagoCliente = 0.0;
        this.cambio = 0.0;
    }

    public void agregarProducto(Articulo articulo, int cantidad) {
        if (articulo.getExistencia() >= cantidad) {
            articulo.setExistencia(articulo.getExistencia() - cantidad);
            for (int i = 0; i < cantidad; i++) {
                articulos.add(articulo);
            }
            totalVenta += articulo.getPrecio() * cantidad;
        } else {
            System.out.println("No hay suficiente existencia para el artículo: " + articulo.getNombre());
        }
    }

    public void pagar(double pagoCliente) {
        this.pagoCliente = pagoCliente;
        this.cambio = pagoCliente - totalVenta;
    }

    public void imprimirTicket() {
        System.out.println("Ticket de compra:");
        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
        System.out.println("Total de venta: " + totalVenta);
        System.out.println("Pago del cliente: " + pagoCliente);
        System.out.println("Cambio: " + cambio);
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public double getPagoCliente() {
        return pagoCliente;
    }

    public double getCambio() {
        return cambio;
    }
}
