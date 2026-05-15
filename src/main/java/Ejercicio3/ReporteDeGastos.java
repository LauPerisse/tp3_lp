package Ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    public String imprimir(List<Gasto> gastos, ProveedorDeFecha proveedor) {
        StringBuilder reporte = new StringBuilder();
        int total = 0;
        int gastosDeComida = 0;

        reporte.append("Expenses ").append(proveedor.hoy()).append("\n");

        for (Gasto gasto : gastos) {
            if (gasto.esComida()) {
                gastosDeComida += gasto.monto();
            }

            String marcaExceso = gasto.tieneExceso() ? "X" : " ";
            reporte.append(gasto.nombre()).append("\t")
                    .append(gasto.monto()).append("\t")
                    .append(marcaExceso).append("\n");
            total += gasto.monto();
        }

        reporte.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        reporte.append("Total de gastos: ").append(total);

        return reporte.toString();
    }
}
