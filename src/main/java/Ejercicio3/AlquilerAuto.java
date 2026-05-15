package Ejercicio3;

public class AlquilerAuto extends Gasto {
    public AlquilerAuto(int monto) { super(monto); }
    public String nombre() { return "Alquiler de Autos"; }
    public boolean esComida() { return false; }
    public boolean tieneExceso() { return false; }
}