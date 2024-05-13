package Persistencia;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImprimirJSON 
{
    public static void ImprimirPiezas(int opcion) 
    {
        // Especifica la ruta del archivo JSON con la carpeta "Archivos"
        String rutaArchivo = "Archivos/base_de_datos_piezas.json";

        try {
            // Crea un objeto File con la ruta del archivo
            File archivo = new File(rutaArchivo);

            // Crea un Scanner para leer el contenido del archivo JSON
            Scanner scanner = new Scanner(archivo);

            // Lee todo el contenido del archivo y lo almacena en un StringBuilder
            StringBuilder jsonStringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonStringBuilder.append(scanner.nextLine());
            }

            // Cierra el scanner
            scanner.close();

            // Convierte el contenido del StringBuilder a String
            String jsonString = jsonStringBuilder.toString();

            // Convierte el String JSON en un objeto JSONObject
            JSONObject jsonObject = new JSONObject(jsonString);

            // Obtiene el array "piezas" del JSON
            JSONArray piezasArray = jsonObject.getJSONArray("piezas");

            // Imprime las piezas en sibasta o por pecio fijo 
            if (opcion == 1) {
            	System.out.println("Piezas en subasta:");
                imprimirPiezas(piezasArray, true); // Imprime las piezas en bodega
            	
            }
            else 
            {
            	System.out.println("\nPiezas PrecioFijo:");
                imprimirPiezas(piezasArray, false); // Imprime las piezas en exhibición
            }
            

        } catch (FileNotFoundException e) {
            // Maneja la excepción si el archivo no se encuentra
            System.out.println("El archivo no se encontró: " + e.getMessage());
        } catch (Exception e) {
            // Maneja otras excepciones que puedan ocurrir
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    // Método para imprimir las piezas según su ubicación (bodega o exhibición)
    private static void imprimirPiezas(JSONArray piezasArray, boolean enSubasta) {
        for (int i = 0; i < piezasArray.length(); i++) {
            JSONObject pieza = piezasArray.getJSONObject(i);
            boolean estaEnSubasta = pieza.getBoolean("subasta");
            if (estaEnSubasta == enSubasta) {
                System.out.println("Pieza " + (i + 1) + ":");
                System.out.println("  Título: " + pieza.getString("titulo"));
                System.out.println("  Año de creación: " + pieza.getInt("anioCreacion"));
                System.out.println("  Lugar de creación: " + pieza.getString("lugarCreacion"));
                System.out.println("  Autor/es: " + pieza.getJSONArray("autores"));
                System.out.println("  Disponible: " + pieza.getBoolean("disponible"));
                System.out.println("  Tiempo de consignación: " + pieza.getInt("tiempoConsignacion"));
                System.out.println("  En subasta: " + pieza.getBoolean("subasta"));
                System.out.println("  Valores: " + pieza.getJSONArray("valores"));
                System.out.println("  Propietario: " + pieza.getString("propietario"));
                System.out.println("  En bodega: " + pieza.getBoolean("bodega"));
                System.out.println("  Tipo: " + pieza.getString("tipo"));
                JSONObject valoresEspeciales = pieza.getJSONObject("valoresEspeciales");
                switch (pieza.getString("tipo")) {
                    case "pintura":
                        System.out.println("    Alto: " + valoresEspeciales.getInt("alto"));
                        System.out.println("    Ancho: " + valoresEspeciales.getInt("ancho"));
                        System.out.println("    Peso: " + valoresEspeciales.getInt("peso"));
                        System.out.println("    Técnica: " + valoresEspeciales.getString("tecnica"));
                        break;
                    case "fotografia":
                        System.out.println("    Resolución: " + valoresEspeciales.getString("resolucion"));
                        System.out.println("    Tamaño en gigas: " + valoresEspeciales.getString("tamanioGiga"));
                        break;
                    case "escultura":
                        System.out.println("    Alto: " + valoresEspeciales.getInt("alto"));
                        System.out.println("    Ancho: " + valoresEspeciales.getInt("ancho"));
                        System.out.println("    Profundidad: " + valoresEspeciales.getInt("profundidad"));
                        System.out.println("    Peso: " + valoresEspeciales.getInt("peso"));
                        System.out.println("    ¿Necesita electricidad?: " + valoresEspeciales.getBoolean("electricidad"));
                        break;
                    case "video":
                        System.out.println("    Duración en minutos: " + valoresEspeciales.getInt("duracion"));
                        System.out.println("    Tamaño en gigas: " + valoresEspeciales.getInt("tamanioGiga"));
                        System.out.println("    Resolución: " + valoresEspeciales.getString("resolucion"));
                        break;
                    default:
                        System.out.println("  Valores especiales no reconocidos.");
                }
                System.out.println();
            }
        }
    }
}
