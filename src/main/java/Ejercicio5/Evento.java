package Ejercicio5;


public abstract class Evento {
    private final String nombre;

    protected Evento(String nombre) {
        this.nombre = nombre;
    }

    public String nombreEvento() {
        return nombre;
    }

    public abstract float montoPara(int espectadores);

    public float creditosPara(int espectadores) {
        return Math.max(espectadores - 30, 0);
    }
}
