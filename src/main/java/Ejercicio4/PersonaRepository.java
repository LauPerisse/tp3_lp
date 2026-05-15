package Ejercicio4;

import org.jdbi.v3.core.Jdbi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional; // Importar Optional

public class PersonaRepository {

    private Jdbi jdbi;

    public PersonaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    /**
     * Busca por nombre o parte.
     * Retorna una lista vacía si no encuentra resultados (en lugar de null).
     */
    public List<Persona> buscarPorNombre(String nombreOParte) {
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where nombre like ?")
                    .bind(0, "%" + nombreOParte + "%").mapToMap(String.class).list();

            var personas = new ArrayList<Persona>();

            // Ya no retornamos null. Si rs está vacío, el bucle no se ejecuta
            // y se retorna la lista 'personas' vacía.
            for (Map<String, String> map : rs) {
                personas.add(new Persona(map.get("nombre"), map.get("apellido")));
            }

            return personas;
        });
    }

    /**
     * Dado un id, retorna un Optional con la Persona o un Optional vacío.
     */
    public Optional<Persona> buscarId(Long id) {
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where id_persona = ?")
                    .bind(0, id).mapToMap(String.class).list();

            if (rs.isEmpty()) {
                return Optional.empty(); // Retornar Optional vacío en lugar de null
            }

            Map<String, String> map = rs.get(0);
            return Optional.of(new Persona(map.get("nombre"), map.get("apellido")));
        });
    }
}