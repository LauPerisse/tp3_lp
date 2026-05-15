package Ejercicio3;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReporteDeGastosTest {

    @Test
    public void testReporteConDiferentesTiposDeGastos() {
        LocalDate fechaFija = LocalDate.of(2024, 5, 10);
        ProveedorDeFecha proveedor = new ProveedorDeFechaFija(fechaFija);

        Gasto desayunoConExceso = new Desayuno(1100);
        Gasto cenaSinExceso = new Cena(4500);
        Gasto alquilerAuto = new AlquilerAuto(2500);

        ReporteDeGastos reporte = new ReporteDeGastos();

        String resultado = reporte.imprimir(List.of(desayunoConExceso, cenaSinExceso, alquilerAuto), proveedor);

        assertTrue(resultado.contains("Expensas 2024-05-10"));
        assertTrue(resultado.contains("Desayuno\t1100\tX"));
        assertTrue(resultado.contains("Cena\t4500\t "));
        assertTrue(resultado.contains("Alquiler de Autos\t2500\t "));

        assertTrue(resultado.contains("Gastos de comida: 5600"));
        assertTrue(resultado.contains("Total de gastos: 8100"));
    }
}