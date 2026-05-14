package Ejercicio2;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Recaudacion {

    private static final String DATA_PATH = "src/main/resources/data.csv";

    // Filtra los aportes de capital de forma dinámica basándose en el mapa de opciones
    // para que no haya una serie de if consecutivos
    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<AporteCapital> todosLosAportes = cargarAportesDesdeCsv(DATA_PATH);

        return todosLosAportes.stream()
                .map(AporteCapital::toMap)
                .filter(datosAporte -> options.entrySet().stream()
                        .allMatch(filtro ->
                                datosAporte.containsKey(filtro.getKey()) &&
                                        datosAporte.get(filtro.getKey()).equals(filtro.getValue())
                        )
                )
                .collect(Collectors.toList());
    }

    private static List<AporteCapital> cargarAportesDesdeCsv(String ruta) throws IOException {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(ruta)).build()) {
            List<String[]> rows = reader.readAll();
            if (rows.isEmpty()) {
                return Collections.emptyList();
            }

            return rows.stream()
                    .skip(1)
                    .map(AporteCapital::fromArray)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IOException("Error procesando el archivo de datos: " + e.getMessage(), e);
        }
    }
}