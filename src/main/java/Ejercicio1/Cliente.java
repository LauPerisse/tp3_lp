package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<>();
    private String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public ResumenAlquiler calcularResumen() {
        double total = 0;
        int puntosAlquilerFrecuente = 0;

        for (Alquiler alquiler : alquileres) {
            total += alquiler.montoAlquiler();
            puntosAlquilerFrecuente += alquiler.puntosAlquiler();
        }

        return new ResumenAlquiler(total, puntosAlquilerFrecuente);
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }

    public String nombre() {
        return name;
    }
}