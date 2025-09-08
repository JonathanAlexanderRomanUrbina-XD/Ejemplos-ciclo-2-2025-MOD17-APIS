package ESFE.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancia del objeto Producto
            Producto producto = new Producto();
            producto.id = 303;
            producto.nombre = "Controlador de carga solar";
            producto.categorias = Arrays.asList("Energía", "Electrónica", "Sostenibilidad");
            producto.precio = 189.75;
            // Crear instancia de ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            // Guardar el JSON en un archivo físico
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("producto_guardado.json"), producto);
            System.out.println("JSON guardado exitosamente en 'producto_guardado.json'");
        } catch (Exception e) {
            System.out.println("Error al guardar el JSON: " + e.getMessage());
        }
    }
}