package Ejercicio3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReporteDeGastosTest {
    @Test
    public void testReporte() {
        Gasto g1 = new Gasto();
        g1.tipoGasto = TipoDeGasto.DESAYUNO;
        g1.monto = 1100;

        ReporteDeGastos reporte = new ReporteDeGastos();
        String resultado = reporte.imprimir(List.of(g1));

        assertTrue(resultado.contains("Desayuno\t1100\tX"));
        assertTrue(resultado.contains("Gastos de comida: 1100"));
        assertTrue(resultado.contains("Total de gastos: 1100"));
    }
}