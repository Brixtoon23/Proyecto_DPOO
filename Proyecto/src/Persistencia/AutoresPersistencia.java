package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Galeria;

import Logica.Subasta;

public class AutoresPersistencia 
{
	
	private static JSONObject baseDeDatosJSON = leerBaseDeDatos();

	private static List<JSONObject> autores = obtenerAutoresDesdeJSON(baseDeDatosJSON.getJSONArray("autores"));
	
	
	public static void registrarPieza(Galeria galeria , String autor) 
    {   
        if (autores.contains(autor))
        {
            autores.get(autores.indexOf(autor));
        }


        // Crear el objeto JSON para la nueva pieza
        JSONObject autorJSON = new JSONObject();
        
        autorJSON.put(autor, autorJSON)

        
        autores.add(subastaJSON);

        // Guardar la base de datos actualizada
        baseDeDatosJSON.put("autores", new JSONArray(subastas)); // Actualizar el arreglo de piezas en el JSON
        guardarBaseDeDatos(baseDeDatosJSON);

        System.out.println("Registro exitoso.");
        
    }

    private static List<JSONObject> obtenerAutoresDesdeJSON(JSONArray subastaArray) 
    {
        List<JSONObject> listaSubastas = new ArrayList<>();
        for (int i = 0; i < subastaArray.length(); i++) 
        {
            listaSubastas.add(subastaArray.getJSONObject(i));
        }
        return listaSubastas;
    }

    public static JSONObject leerBaseDeDatos() 
    {
        try {
            // Utilizamos la misma ruta relativa que en guardarBaseDeDatos
            File archivo = new File("Proyecto/Archivos/base_de_datos_autores.json");
            Scanner scanner = new Scanner(archivo);
            StringBuilder jsonText = new StringBuilder();
            while (scanner.hasNextLine()) 
            {
                jsonText.append(scanner.nextLine());
            }
            scanner.close();
            return new JSONObject(jsonText.toString());
        } 
        catch (FileNotFoundException e) 
        {
            // Si el archivo no existe, se devuelve un JSON con un arreglo de piezas vacío
            return new JSONObject().put("piezas", new JSONArray());
        }
    }

    private static void guardarBaseDeDatos(JSONObject baseDeDatosJSON) 
    {
        try (FileWriter file = new FileWriter("Proyecto/Archivos/base_de_datos_autores.json")) 
        {
            file.write(baseDeDatosJSON.toString(4));
            System.out.println("Base de datos actualizada y guardada.");
        } 
        catch (IOException e) 
        {
            System.out.println("Error al guardar la base de datos.");
            e.printStackTrace();
        }
    }

    // Método para obtener la lista de piezas desde un JSONArray
}
