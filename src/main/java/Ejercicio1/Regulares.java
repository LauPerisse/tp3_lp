package Ejercicio1;

public class Regulares extends Libro{
    public Regulares(String nombre, int codigoPreico) {
        super(nombre, codigoPreico);
    }

    @Override
    public double calcularPrecio(int diasAlquilados) {
        monto += 2;
        if (diasAlquilados > 2)
            monto += (diasAlquilados - 2) * 1.5; // Precio por día adicional
        return monto;
    }
}
