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
                .map(Recaudacion::convertirAMap)
                .collect(Collectors.toList());
    }

    private static boolean cumpleConFiltros(AporteCapital aporte, Map<String, String> options) {
        if (options.containsKey("company_name") && !aporte.companyName().equalsIgnoreCase(options.get("company_name"))) return false;
        if (options.containsKey("city") && !aporte.city().equalsIgnoreCase(options.get("city"))) return false;
        if (options.containsKey("state") && !aporte.state().equalsIgnoreCase(options.get("state"))) return false;
        if (options.containsKey("round") && !aporte.round().equalsIgnoreCase(options.get("round"))) return false;
        return true;
    }

    private static List<AporteCapital> cargarAportesDesdeCsv() throws IOException {
        List<AporteCapital> aportes = new ArrayList<>();
        InputStream is = null;

        is = Recaudacion.class.getResourceAsStream("/data.csv");

        if (is == null) {
            File file = new File("src/main/resources/data.csv");
            if (file.exists()) is = new FileInputStream(file);
        }

        if (is == null) {
            File file = new File("data.csv");
            if (file.exists()) is = new FileInputStream(file);
        }

        if (is == null) {
            throw new IOException("ERROR FATAL: No se encontró 'data.csv'. \n" +
                    "Verifica que el archivo exista en 'src/main/resources/data.csv' \n" +
                    "y que el nombre sea exactamente 'data.csv' en minúsculas.");
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

    private static Map<String, String> convertirAMap(AporteCapital aporte) {
        Map<String, String> output = new HashMap<>();
        output.put("permalink", aporte.permalink());
        output.put("company_name", aporte.companyName());
        output.put("number_employees", aporte.numberEmployees());
        output.put("category", aporte.category());
        output.put("city", aporte.city());
        output.put("state", aporte.state());
        output.put("funded_date", aporte.fundedDate());
        output.put("raised_amount", aporte.raisedAmount());
        output.put("raised_currency", aporte.raisedCurrency());
        output.put("round", aporte.round());
        return output;
    }
}