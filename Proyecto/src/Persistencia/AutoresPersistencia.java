package Persistencia;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutoresPersistencia {

    private static final String NOMBRE_ARCHIVO = "Proyecto/Archivos/base_de_datos_autores.json";

    public static void registrarAutor(String autor, String pieza) {
        JSONObject baseDeDatosJSON = leerBaseDeDatos();


        JSONArray autoresArray = baseDeDatosJSON.getJSONArray("autores");

        boolean autorExistente = false;
        for (int i = 0; i < autoresArray.length(); i++) {
            JSONObject autorJSON = autoresArray.getJSONObject(i);
            if (autorJSON.getString("nombre").equals(autor)) 
            {
                
                JSONArray piezasArray = autorJSON.getJSONArray("piezas");
                piezasArray.put(pieza);
                autorJSON.put("piezas", piezasArray);
                autorExistente = true;
                break;
            }
        }

        if (!autorExistente) {
            JSONObject nuevoAutorJSON = new JSONObject();
            nuevoAutorJSON.put("nombre", autor);
            JSONArray piezasArray = new JSONArray();
            piezasArray.put(pieza);
            nuevoAutorJSON.put("piezas", piezasArray);
            autoresArray.put(nuevoAutorJSON);
        }


        guardarBaseDeDatos(baseDeDatosJSON);

        System.out.println("Registro exitoso.");
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

            return new JSONObject().put("autores", new JSONArray());
        }
    }

    private static void guardarBaseDeDatos(JSONObject baseDeDatosJSON) {
        try (FileWriter file = new FileWriter(NOMBRE_ARCHIVO)) {
            file.write(baseDeDatosJSON.toString(4));
            System.out.println("Base de datos actualizada y guardada.");
        } catch (IOException e) {
            System.out.println("Error al guardar la base de datos.");
            e.printStackTrace();
        }
    }
}
