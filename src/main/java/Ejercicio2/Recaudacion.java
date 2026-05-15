package Ejercicio2;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Recaudacion {

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<AporteCapital> todosLosAportes = cargarAportesDesdeCsv();

        return todosLosAportes.stream()
                .filter(aporte -> cumpleConFiltros(aporte, options))
                .map(AporteCapital::toMap)
                .collect(Collectors.toList());
    }

    private static boolean cumpleConFiltros(AporteCapital aporte, Map<String, String> options) {
        Map<String, String> datosAporte = aporte.toMap();

        return options.entrySet().stream()
                .allMatch(entry -> {
                    String valorEnAporte = datosAporte.get(entry.getKey());
                    return valorEnAporte != null && valorEnAporte.equalsIgnoreCase(entry.getValue());
                });
    }

    private static List<AporteCapital> cargarAportesDesdeCsv() throws IOException {
        List<AporteCapital> aportes = new ArrayList<>();
        InputStream is = Recaudacion.class.getResourceAsStream("/data.csv");

        if (is == null) {
            File file = new File("src/main/resources/data.csv");
            if (file.exists()) is = new FileInputStream(file);
        }

        if (is == null) {
            File file = new File("data.csv");
            if (file.exists()) is = new FileInputStream(file);
        }

        if (is == null) {
            throw new IOException("ERROR FATAL: No se encontró 'data.csv'.");
        }

        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(is))
                .withSkipLines(1)
                .build()) {

            List<String[]> csvData = reader.readAll();
            for (String[] row : csvData) {
                if (row.length >= 10) {
                    aportes.add(AporteCapital.fromArray(row));
                }
            }
        } catch (Exception e) {
            throw new IOException("Error procesando los datos del CSV: " + e.getMessage());
        }
        return aportes;
    }
}