package Ejercicio1;

public class Libro {
    private String nombre;
    private Precio precio;

    public Libro(String nombre, Precio precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double montoAlquiler(int diasAlquilados) {
        return precio.montoAlquiler(diasAlquilados);
    }

    public int puntosAlquiler(int diasAlquilados) {
        return precio.puntosAlquiler(diasAlquilados);
    }
}