package Ejercicio5;

import java.util.List;

public class Calculador {

    public String reporte(Factura factura, List<Evento> eventos) {
        float totalAmount = 0;
        float creditos = 0;
        var result = new StringBuilder("Facturación para " + factura.nombreCliente() + "\n");

        for (var actuacion : factura.actuaciones()) {
            var evento = eventos.stream()
                    .filter(e -> e.nombreEvento().equals(actuacion.nombreEvento()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

            float monto = evento.montoPara(actuacion.numeroEspectadores());
            float creditosDeActuacion = evento.creditosPara(actuacion.numeroEspectadores());

            result.append(actuacion.nombreEvento())
                    .append(": ")
                    .append(monto)
                    .append(". Asientos: ")
                    .append(actuacion.numeroEspectadores())
                    .append("\n");

            totalAmount += monto;
            creditos += creditosDeActuacion;
        }

        result.append("Monto ganado: ").append(totalAmount).append("\n");
        result.append("Créditos ganados: ").append(creditos).append("\n");

        return result.toString();
    }
}