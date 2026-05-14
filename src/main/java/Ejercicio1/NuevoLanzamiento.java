package Ejercicio1;

public class NuevoLanzamiento extends Libro{

    public NuevoLanzamiento(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularPrecio(int diasAlquilados) {
        double monto += diasAlquilados * 3;
        return monto;
    }

}
