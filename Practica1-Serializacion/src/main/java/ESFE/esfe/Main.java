package ESFE.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Producto producto = new Producto();
            producto.id = 101;
            producto.nombre = "Panel Solar Fotovoltaico";
            producto.categorias = Arrays.asList("Energía", "Renovable", "Tecnología");
            producto.precio = 299.99;

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(producto);
            System.out.println("JSON generado:");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }
    }
}
