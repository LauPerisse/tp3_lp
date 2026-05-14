package Ejercicio2;

import java.util.HashMap;
import java.util.Map;

public record AporteCapital(
        String permalink, String companyName, String numberEmployees,
        String category, String city, String state,
        String fundedDate, String raisedAmount, String raisedCurrency, String round
) {
    private static final int COL_PERMALINK = 0;
    private static final int COL_COMPANY = 1;
    private static final int COL_EMPLOYEES = 2;
    private static final int COL_CATEGORY = 3;
    private static final int COL_CITY = 4;
    private static final int COL_STATE = 5;
    private static final int COL_DATE = 6;
    private static final int COL_AMOUNT = 7;
    private static final int COL_CURRENCY = 8;
    private static final int COL_ROUND = 9;

    public static AporteCapital fromArray(String[] row) {
        return new AporteCapital(
                row[COL_PERMALINK], row[COL_COMPANY], row[COL_EMPLOYEES],
                row[COL_CATEGORY], row[COL_CITY], row[COL_STATE],
                row[COL_DATE], row[COL_AMOUNT], row[COL_CURRENCY], row[COL_ROUND]
        );
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("permalink", permalink);
        map.put("company_name", companyName);
        map.put("number_employees", numberEmployees);
        map.put("category", category);
        map.put("city", city);
        map.put("state", state);
        map.put("funded_date", fundedDate);
        map.put("raised_amount", raisedAmount);
        map.put("raised_currency", raisedCurrency);
        map.put("round", round);
        return map;
    }
}