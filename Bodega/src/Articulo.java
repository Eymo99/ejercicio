package Bodega;

public class Articulo {
    private int id;
    private String nombre;
    private String codigoBarras;
    private double precio;
    private int existencia;

    public Articulo(int id, String nombre, String codigoBarras, double precio, int existencia) {
        this.id = id;
        this.nombre = nombre;
        this.codigoBarras = codigoBarras;
        this.precio = precio;
        this.existencia = existencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", precio=" + precio +
                ", existencia=" + existencia +
                '}';
    }
}
