package Persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Escultura;
import Logica.Fotografia;
import Logica.Galeria;
import Logica.Pieza;
import Logica.Pintura;
import Logica.Video;

public class PiezasPersistencia {
    
    private static final String NOMBRE_ARCHIVO = "Proyecto/Archivos/base_de_datos_piezas.json";
    private static JSONObject baseDeDatosJSON = leerBaseDeDatos();
    private static JSONArray piezasArray = baseDeDatosJSON.getJSONArray("piezas");
    private static List<JSONObject> piezas = obtenerPiezasDesdeJSON(piezasArray);

    public static void registrarPieza(Galeria galeria, Pieza pieza) {
        // Crear el objeto JSON para la nueva pieza
        JSONObject piezaJSON = new JSONObject();
        piezaJSON.put("titulo", pieza.getTitulo());
        piezaJSON.put("anioCreacion", pieza.getAnioCreacion());
        piezaJSON.put("loginPropietarioActual", pieza.getLoginPropietarioActual());
        piezaJSON.put("lugarCreacion", pieza.getLugarCreacion());
        piezaJSON.put("autores", new JSONArray(pieza.getAutor()));
        piezaJSON.put("disponible", pieza.isDisponible());
        piezaJSON.put("tiempoConsignacion", pieza.getTiempoConsignacion());
        piezaJSON.put("subasta", pieza.isSubasta());
        piezaJSON.put("valores", new JSONArray(pieza.getValores()));
        piezaJSON.put("historialPropietarios", new JSONArray(pieza.getHistorialPropietarios()));
        piezaJSON.put("bodega", pieza.isBodega());
        piezaJSON.put("tipo", pieza.getTipo());

        // Crear el objeto JSON para los valores especiales según el tipo
        JSONObject valoresEspecialesJSON = new JSONObject();
        switch (pieza.getTipo()) {
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
        baseDeDatosJSON.put("piezas", new JSONArray(piezas));
        guardarBaseDeDatos(baseDeDatosJSON);
    }

    private static List<JSONObject> obtenerPiezasDesdeJSON(JSONArray piezasArray) {
        List<JSONObject> listaPiezas = new ArrayList<>();
        for (int i = 0; i < piezasArray.length(); i++) {
            listaPiezas.add(piezasArray.getJSONObject(i));
        }
        return listaPiezas;
    }

    public static JSONObject leerBaseDeDatos() {
        try {
            File archivo = new File(NOMBRE_ARCHIVO);
            Scanner scanner = new Scanner(archivo);
            StringBuilder jsonText = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonText.append(scanner.nextLine());
            }
            scanner.close();
            return new JSONObject(jsonText.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONObject().put("piezas", new JSONArray());
        }
    }

    private static void guardarBaseDeDatos(JSONObject baseDeDatosJSON) {
        try (FileWriter file = new FileWriter(NOMBRE_ARCHIVO)) {
            file.write(baseDeDatosJSON.toString(4));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void actualizarPropietarioPieza(Galeria galeria, Pieza pieza) 
    {
        for (int i = 0; i < piezas.size(); i++) {
            JSONObject objPieza = piezas.get(i);
            if (objPieza.getString("titulo").equals(pieza.getTitulo())) {
                // Actualiza el propietario actual y el historial de propietarios
                objPieza.put("loginPropietarioActual", pieza.getLoginPropietarioActual());
                objPieza.put("historialPropietarios", new JSONArray(pieza.getHistorialPropietarios()));
                objPieza.put("disponible", pieza.isDisponible());
                
                // Remueve y añade nuevamente para garantizar que se registre como un cambio
                piezas.remove(i);
                piezas.add(i, objPieza);

                // Guarda los cambios en el archivo JSON
                baseDeDatosJSON.put("piezas", new JSONArray(piezas));
                guardarBaseDeDatos(baseDeDatosJSON);
                break;
            }
        }
    }
}
