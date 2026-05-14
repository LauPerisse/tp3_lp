package Ejercicio1;

public class Alquiler {
    private CopiaLibro copia;
    private int diasAlquilados;

    public Alquiler(CopiaLibro copia, int diasAlquilados) {
        this.copia = copia;
        this.diasAlquilados = diasAlquilados;
    }

    public int diasAlquilados() {
        return this.diasAlquilados;
    }

    public CopiaLibro copia() {
        return this.copia;
    }

    public int obtnerCodigoLibro () {
        return this.copia.libro().codigoPrecio();
    }

    public double calcularMonto () {
        return this.copia.libro().calcularPrecio(this.diasAlquilados);
    }
}
