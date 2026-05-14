package Ejercicio2;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recaudacion {

    private static final String DATA_PATH = "src/main/resources/data.csv";

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<AporteCapital> todosLosAportes = cargarAportesDesdeCsv(DATA_PATH);

        Stream<AporteCapital> streamAportes = todosLosAportes.stream();

        if (options.containsKey("company_name")) {
            streamAportes = streamAportes.filter(a -> a.companyName().equals(options.get("company_name")));
        }
        if (options.containsKey("city")) {
            streamAportes = streamAportes.filter(a -> a.city().equals(options.get("city")));
        }
        if (options.containsKey("state")) {
            streamAportes = streamAportes.filter(a -> a.state().equals(options.get("state")));
        }
        if (options.containsKey("round")) {
            streamAportes = streamAportes.filter(a -> a.round().equals(options.get("round")));
        }

        return streamAportes
                .map(AporteCapital::toMap)
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