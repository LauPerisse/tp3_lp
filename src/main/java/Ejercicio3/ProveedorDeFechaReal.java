package Ejercicio3;

import java.time.LocalDate;

public class ProveedorDeFechaReal implements ProveedorDeFecha {
    @Override
    public LocalDate hoy() {
        return LocalDate.now();
    }
}