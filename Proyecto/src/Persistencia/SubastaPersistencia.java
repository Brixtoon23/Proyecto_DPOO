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
    private static JSONObject baseDeDatosJSON = leerBaseDeDatos();
    private static JSONArray subastasArray = baseDeDatosJSON.getJSONArray("subastas");

    public static void registrarSubasta(Subasta subasta) 
    {
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

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void registrarOferta(Subasta subasta) 
    {
        for (int i = 0; i < subastasArray.length(); i++) 
        {
            JSONObject objSubasta = subastasArray.getJSONObject(i);
            // Verifica si el objeto tiene la clave que quieres eliminar
            if (objSubasta.getString("id").equals(subasta.getId()))
            {            
                subastasArray.remove(i);
                registrarSubasta(subasta);
                break; 
            }

        }
    }

    
}
