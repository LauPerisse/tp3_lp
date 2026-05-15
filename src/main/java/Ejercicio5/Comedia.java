package Ejercicio5;

public class Comedia extends Evento {
    public Comedia(String nombre) {
        super(nombre);
    }

    @Override
    public float montoPara(int espectadores) {
        float monto = 30000;
        if (espectadores > 20) {
            monto += 10000 + 500 * (espectadores - 20);
        }
        monto += 300 * espectadores;
        return monto;
    }

    @Override
    public float creditosPara(int espectadores) {
        return super.creditosPara(espectadores) + (float) Math.floor(espectadores / 5);
    }
}