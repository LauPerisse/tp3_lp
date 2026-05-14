package Ejercicio1;

public class Main {
    public static void main(String args[]) {
        Libro elTunel = new Libro("El Túnel", new PrecioRegular());
        Libro antesDelFin = new Libro("Antes del Fin", new PrecioRegular());

        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);

        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);

        Cliente cliente = new Cliente("Javier");
        cliente.alquilar(alquilerElTunel);
        cliente.alquilar(alquilerAntesDelFin);

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        System.out.println("Estado de cuenta para: " + cliente.nombre());
        System.out.println("Monto total adeudado: $" + resultado[0]);
        System.out.println("Puntos de alquiler frecuente obtenidos: " + resultado[1]);
    }
}
