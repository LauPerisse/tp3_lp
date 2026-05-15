package Ejercicio3;

public abstract class Gasto {
    protected int monto;

    public Gasto(int monto) {
        this.monto = monto;
    }

    public int monto() {
        return monto;
    }

    public abstract String nombre();
    public abstract boolean esComida();
    public abstract boolean tieneExceso();
}






