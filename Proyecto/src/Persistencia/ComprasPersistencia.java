package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Compra;
import Logica.Historia;

public class ComprasPersistencia 
{

    private static final String NOMBRE_ARCHIVO = "Proyecto/Archivos/base_de_datos_compras.json";
    private static JSONObject baseDeDatosJSON = leerBaseDeDatos();
    private static JSONArray historialArray = baseDeDatosJSON.getJSONArray("compras");

    public static void registrarCompra(Compra compra) 
    {
        JSONObject historiaJson = new JSONObject();
        historiaJson.put("compradorLogin",compra.getCompradorLogin());
        historiaJson.put("nombrePieza", compra.getNombrepieza());
        historiaJson.put("precio", Integer.toString(compra.getPrecio()));
        historiaJson.put("metodoPago", compra.getMetodoPago());
        historiaJson.put("fecha", compra.getFecha());

        // Añadir la nueva historia al array
        historialArray.put(historiaJson);

        // Guardar la base de datos actualizada
        guardarBaseDeDatos(baseDeDatosJSON);
    }

    private static JSONObject leerBaseDeDatos() {
        try {
            File archivo = new File(NOMBRE_ARCHIVO);
            Scanner scanner = new Scanner(archivo);
            StringBuilder jsonText = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonText.append(scanner.nextLine());
            }
            scanner.close();
            return new JSONObject(jsonText.toString());
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, crear un nuevo JSON con el array de historias vacío
            return new JSONObject().put("historias", new JSONArray());
        }
    }

    private static void guardarBaseDeDatos(JSONObject baseDeDatosJSON) {
        try (FileWriter file = new FileWriter(NOMBRE_ARCHIVO)) {
            file.write(baseDeDatosJSON.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


