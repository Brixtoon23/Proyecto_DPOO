package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Subasta;




public class SubastaPersistencia
{

    private static final String NOMBRE_ARCHIVO = "Proyecto/Archivos/base_de_datos_subastas.json";

    public static void registrarSubasta(Subasta subasta) 
    {
        JSONObject baseDeDatosJSON = leerBaseDeDatos();

        JSONArray subastasArray = baseDeDatosJSON.getJSONArray("subastas");
        JSONObject subastaJson = new JSONObject();
        subastaJson.put("id", subasta.getId());
        subastaJson.put("idListaPiezasSubasta", subasta.getIdListaPiezasSubasta());
        subastaJson.put("listaOfertas", subasta.getListaOfertas());
        subastasArray.put(subastaJson);


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

            return new JSONObject().put("subastas", new JSONArray());
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
