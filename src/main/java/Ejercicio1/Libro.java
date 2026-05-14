package Ejercicio1;

public abstract class Libro {
    private String nombre;
    private int codigoPrecio;

    public Libro(String nombre, int priceCode) {
        this.nombre = nombre;
        this.codigoPrecio = priceCode;
    }

    public int codigoPrecio() {
        return codigoPrecio;
    }

    public String nombre() {
        return nombre;
    }

    public abstract double calcularPrecio (int diasAlquilados);

}
