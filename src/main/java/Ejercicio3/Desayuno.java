package Ejercicio3;

public class Desayuno extends Gasto {
    public Desayuno(int monto) { super(monto); }
    public String nombre() { return "Desayuno"; }
    public boolean esComida() { return true; }
    public boolean tieneExceso() { return monto > 1000; }
}