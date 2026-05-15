package Ejercicio3;

import java.time.LocalDate;

public class ProveedorDeFechaFija implements ProveedorDeFecha {
    private LocalDate fechaFija;

    public ProveedorDeFechaFija(LocalDate fecha) {
        this.fechaFija = fecha;
    }

    @Override
    public LocalDate hoy() {
        return fechaFija;
    }
}