package Persistencia;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import Logica.Compra;
import Logica.Comprador;
import Logica.Galeria;
import Logica.Mensaje;
import Logica.Usuario;
import Logica.Propietario;
import Logica.Tarjeta;



public class TarjetasPersistencia 
{


    private static JSONObject baseDatos = leerBaseDeDatos();
    private static JSONArray tarjetasJSON = baseDatos.getJSONArray("tarjetas");
    

    public static void registrarTarjetas(Tarjeta tarjeta) 

    {
        JSONObject tarjetaJSON = new JSONObject();

        tarjetaJSON.put("nombre", tarjeta.getNombre());
        tarjetaJSON.put("loginComprador", tarjeta.getLoginComprador());
        tarjetaJSON.put("csv", tarjeta.getCsv());
        tarjetaJSON.put("monto", tarjeta.getMonto());
        tarjetaJSON.put("numero", tarjeta.getNumero());
        tarjetaJSON.put("pin", tarjeta.getPin());
        tarjetasJSON.put(tarjetaJSON);
        guardarBaseDeDatos(baseDatos);
        System.out.println("Registro exitoso.");
    }
      
      

    public static JSONObject leerBaseDeDatos()
     {
        try {
            Scanner scanner = new Scanner(new File("Proyecto/Archivos/base_de_datos_tarjetas.json"));
            StringBuilder jsonText = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonText.append(scanner.nextLine());
            }
            scanner.close();
            return new JSONObject(jsonText.toString());
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, se devuelve un JSON vacío
            return new JSONObject().put("usuarios", new JSONArray());
        }
    }

    
    private static void guardarBaseDeDatos(JSONObject baseDeDatosJSON) 
    {
        try (FileWriter file = new FileWriter("Proyecto/Archivos/base_de_datos_tarjetas.json")) 
        {
            file.write(baseDeDatosJSON.toString(4));
            System.out.println("Base de datos actualizada y guardada.");
        } catch (IOException e) {
            System.out.println("Error al guardar la base de datos.");
            e.printStackTrace();
        }
    }

}


