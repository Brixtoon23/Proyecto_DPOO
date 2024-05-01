package Persistencia;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Administrador;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Galeria;
import Logica.Pieza;
import Logica.Pintura;

import Logica.Video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PiezasPersistencia {
	
	static JSONObject baseDeDatosJSON = leerBaseDeDatos();

	static List<JSONObject> piezas = obtenerPiezasDesdeJSON(baseDeDatosJSON.getJSONArray("piezas"));
	
	
	public static void registrarPieza(Galeria galeria , Pieza pieza) 
    {   


        
        // Crear el objeto JSON para la nueva pieza
        JSONObject piezaJSON = new JSONObject();
        piezaJSON.put("titulo", pieza.getTitulo());
        piezaJSON.put("anioCreacion", pieza.getAnioCreacion());
        piezaJSON.put("lugarCreacion", pieza.getLugarCreacion());
        piezaJSON.put("autores", pieza.getAutor()); // Usar un JSONArray para los autores
        piezaJSON.put("disponible", pieza.isDisponible());
        piezaJSON.put("tiempoConsignacion", pieza.getTiempoConsignacion());
        piezaJSON.put("subasta", pieza.isSubasta());
        piezaJSON.put("valores", pieza.getValores()); // Usar un JSONArray para los valores
        piezaJSON.put("loginPropietario", pieza.getLoginPropietario());
        piezaJSON.put("bodega", pieza.isBodega());
        piezaJSON.put("tipo", pieza.getTipo());

        // Crear el objeto JSON para los valores especiales según el tip
        JSONObject valoresEspecialesJSON = new JSONObject();

        switch (pieza.getTipo()) 
        {
            case "pintura":
                Pintura pintura = (Pintura) pieza; 

                valoresEspecialesJSON.put("alto", pintura.getAlto());
                
                valoresEspecialesJSON.put("ancho", pintura.getAncho());
                

                valoresEspecialesJSON.put("peso", pintura.getPeso());

                valoresEspecialesJSON.put("tecnica", pintura.getTecnica());

                break;
                
            case "fotografia":
                Fotografia fotografia = (Fotografia) pieza;


                valoresEspecialesJSON.put("resolucion", fotografia.getResolucion());
                

                valoresEspecialesJSON.put("tamanioGiga", fotografia.getTamanioGiga());
                
                break;
                
            case "escultura":
                Escultura escultura = (Escultura) pieza;

                valoresEspecialesJSON.put("alto", escultura.getAlto());
                
                valoresEspecialesJSON.put("ancho", escultura.getAncho());
                
                valoresEspecialesJSON.put("profundidad", escultura.getProfundidad());

                valoresEspecialesJSON.put("peso", escultura.getPeso());
                
                valoresEspecialesJSON.put("electricidad", escultura.isElectricidad());

                
                break;
                
            case "video":
                Video video = (Video) pieza;

                valoresEspecialesJSON.put("duracion", video.getDuracion());
                
                valoresEspecialesJSON.put("tamanioGiga", video.getTamanioGiga());
                

                valoresEspecialesJSON.put("resolucion", video.getResolucion());
                break;
                
            default:
                System.out.println("Tipo no reconocido. Los valores especiales no se guardarán.");
        }
        
        piezaJSON.put("valoresEspeciales", valoresEspecialesJSON);

        // Agregar la nueva pieza al arreglo de piezas
        piezas.add(piezaJSON);

        // Guardar la base de datos actualizada
        baseDeDatosJSON.put("piezas", new JSONArray(piezas)); // Actualizar el arreglo de piezas en el JSON
        guardarBaseDeDatos(baseDeDatosJSON);

        System.out.println("Registro exitoso.");
        
    }

    private static List<JSONObject> obtenerPiezasDesdeJSON(JSONArray piezasArray) 
    {
        List<JSONObject> listaPiezas = new ArrayList<>();
        for (int i = 0; i < piezasArray.length(); i++) {
            listaPiezas.add(piezasArray.getJSONObject(i));
        }
        return listaPiezas;
    }

    public static JSONObject leerBaseDeDatos() 
    {
        try {
            // Utilizamos la misma ruta relativa que en guardarBaseDeDatos
            File archivo = new File("Archivos/base_de_datos_piezas.json");
            Scanner scanner = new Scanner(archivo);
            StringBuilder jsonText = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonText.append(scanner.nextLine());
            }
            scanner.close();
            return new JSONObject(jsonText.toString());
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, se devuelve un JSON con un arreglo de piezas vacío
            return new JSONObject().put("piezas", new JSONArray());
        }
    }

    private static void guardarBaseDeDatos(JSONObject baseDeDatosJSON) 
    {
        try (FileWriter file = new FileWriter("Archivos/base_de_datos_piezas.json")) {
            file.write(baseDeDatosJSON.toString(4));
            System.out.println("Base de datos actualizada y guardada.");
        } catch (IOException e) {
            System.out.println("Error al guardar la base de datos.");
            e.printStackTrace();
        }
    }

    // Método para obtener la lista de piezas desde un JSONArray
}