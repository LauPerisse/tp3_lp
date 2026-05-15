package Ejercicio3;

public class Cena extends Gasto {
    public Cena(int monto) { super(monto); }
    public String nombre() { return "Cena"; }
    public boolean esComida() { return true; }
    public boolean tieneExceso() { return monto > 5000; }
}