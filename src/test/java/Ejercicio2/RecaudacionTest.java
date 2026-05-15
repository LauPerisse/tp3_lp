package Ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecaudacionTest {

    private Map<String, String> options;

    @BeforeEach
    void setUp() {
        options = new HashMap<>();
    }

    @Test
    public void testWhereGivenCompany() throws IOException {
        options.put("company_name", "Facebook");
        assertEquals(7, Recaudacion.where(options).size());
    }

    @Test
    public void testWhereCorrectKeys() throws IOException {
        options.put("company_name", "Facebook");
        Map<String, String> row = Recaudacion.where(options).get(0);

        assertEquals("facebook", row.get("permalink"));
        assertEquals("Facebook", row.get("company_name"));
        assertEquals("a", row.get("round"));
    }
}