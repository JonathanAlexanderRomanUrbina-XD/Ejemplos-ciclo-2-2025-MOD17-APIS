package ESFE.esfe;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
public class Main {
    // Nombre del archivo JSON (ruta relativa al directorio de trabajo)
    private static final String JSON_FILE = "producto.json";
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // 1. Crear y poblar el objeto Producto
            Producto productoOriginal = new Producto();
            productoOriginal.id = 202;
            productoOriginal.nombre = "Inversor Solar";
            productoOriginal.categorias = Arrays.asList("Energía", "Electrónica", "Renovable");
            productoOriginal.precio = 499.50;
            // 2. Serializar el objeto a archivo JSON
            File file = Paths.get(JSON_FILE).toFile();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, productoOriginal);
            System.out.println("Archivo creado: " + file.getAbsolutePath());
            // 3. Leer y deserializar el mismo archivo JSON
            Producto productoLeido = mapper.readValue(file, Producto.class);
            // 4. Mostrar en consola
            System.out.println("\nProducto deserializado:");
            System.out.println("ID:          " + productoLeido.id);
            System.out.println("Nombre:      " + productoLeido.nombre);
            System.out.println("Categorías:  " + productoLeido.categorias);
            System.out.println("Precio:      $" + productoLeido.precio);
        } catch (IOException e) {
            System.err.println("Error en I/O o JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}