package Ejercicio1;

public class Alquiler {
    private CopiaLibro copia;
    private int diasAlquilados;

    public Alquiler(CopiaLibro copia, int diasAlquilados) {
        this.copia = copia;
        this.diasAlquilados = diasAlquilados;
    }

    public double montoAlquiler() {
        return copia.libro().montoAlquiler(diasAlquilados);
    }

    public int puntosAlquiler() {
        return copia.libro().puntosAlquiler(diasAlquilados);
    }
}