package Ejercicio1;

public class PrecioNuevoLanzamiento extends Precio {
    @Override
    public double montoAlquiler(int diasAlquilados) {
        return diasAlquilados * 3;
    }

    @Override
    public int puntosAlquiler(int diasAlquilados) {
        return (diasAlquilados > 1) ? 2 : 1;
    }
}