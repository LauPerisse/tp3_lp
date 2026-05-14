package Ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testCalcularDeudaYPuntos() {
        Libro elTunel = new Libro("El Túnel", new PrecioRegular());
        Libro antesDelFin = new Libro("Antes del Fin", new PrecioRegular());
        Libro spiderMan = new Libro("Spider-Man", new PrecioNuevoLanzamiento());
        Libro bambi = new Libro("Bambi", new PrecioInfantil());

        Cliente cliente = new Cliente("Javier");

        cliente.alquilar(new Alquiler(new CopiaLibro(elTunel), 5));
        cliente.alquilar(new Alquiler(new CopiaLibro(antesDelFin), 3));
        cliente.alquilar(new Alquiler(new CopiaLibro(spiderMan), 2));
        cliente.alquilar(new Alquiler(new CopiaLibro(bambi), 2));

        ResumenAlquiler resumen = cliente.calcularResumen();

        assertEquals(17.5, resumen.deudaTotal(), "La deuda total calculada es incorrecta");
        assertEquals(5, resumen.puntosObtenidos(), "Los puntos acumulados son incorrectos");
    }
}