package Ejercicio5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var eventos = cargarEventos();
        var factura = crearFactura();

        System.out.println(new Calculador().reporte(factura, eventos));
    }

    private static List<Evento> cargarEventos() {
        return List.of(
                new Comedia("Escuela de Rock"),
                new Drama("Hamlet"),
                new Drama("El Avion"),
                new Comedia("Cantando en la playa"),
                new Drama("El Perfume")
        );
    }

    private static Factura crearFactura() {
        return new Factura("c1", List.of(
                new Actuacion("Escuela de Rock", 158),
                new Actuacion("Hamlet", 103),
                new Actuacion("El Perfume", 8)
        ));
    }
}