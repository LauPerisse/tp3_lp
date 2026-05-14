package Ejercicio1;

public class Infantil extends Libro{
    public Infantil(String nombre, int codigoLibro) {
        super(nombre, codigoLibro);
    }


    @Override
    public double calcularPrecio(int diasAlquilados) {
        monto += 1.5;
        if (diasAlquilados > 3) {
            monto += (diasAlquilados - 3) * 1.5;
        }
        return monto;
    }
}
