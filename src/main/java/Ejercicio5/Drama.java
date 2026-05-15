package Ejercicio5;

public class Drama extends Evento {
    public Drama(String nombre) {
        super(nombre);
    }

    @Override
    public float montoPara(int espectadores) {
        float monto = 40000;
        if (espectadores > 30) {
            monto += 1000 * (espectadores - 30);
        }
        return monto;
    }
}