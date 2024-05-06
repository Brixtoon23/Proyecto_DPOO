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


public class SubastaPersistencia
{
	
	private static JSONObject baseDeDatosJSON = leerBaseDeDatos();

	private static List<JSONObject> subastas = obtenerSubastasDesdeJSON(baseDeDatosJSON.getJSONArray("subastas"));
	
	
	public static void registrarSubasta(Galeria galeria , Subasta subasta) 
    {   
        // Crear el objeto JSON para la nueva pieza
        JSONObject subastaJSON = new JSONObject();
        subastaJSON.put("id", subasta.getId());
        subastaJSON.put("listaCompradores", subasta.getListaCompradores());
        subastaJSON.put("listaPiezas", subasta.getListaPiezasSubasta());
        subastaJSON.put("listaOfertas", subasta.getListaOfertas());

        
        subastas.add(subastaJSON);

        // Guardar la base de datos actualizada
        baseDeDatosJSON.put("subastas", new JSONArray(subastas)); // Actualizar el arreglo de piezas en el JSON
        guardarBaseDeDatos(baseDeDatosJSON);

        System.out.println("Registro exitoso.");
        
    }

    private static List<JSONObject> obtenerSubastasDesdeJSON(JSONArray subastaArray) 
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
            File archivo = new File("Proyecto/Archivos/base_de_datos_subastas.json");
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
        try (FileWriter file = new FileWriter("Proyecto/Archivos/base_de_datos_subastas.json")) 
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