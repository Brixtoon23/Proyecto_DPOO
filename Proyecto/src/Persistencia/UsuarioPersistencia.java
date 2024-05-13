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
import Logica.Mensaje;
import Logica.Usuario;
import Logica.Propietario;



public class UsuarioPersistencia 
{

    

    public static void registrarUsuario(Usuario usuario) 

    {
        JSONObject baseDatos = leerBaseDeDatos();
        JSONArray usuariosJSON = baseDatos.getJSONArray("usuarios");
        JSONObject usuarioJSON = new JSONObject();

        usuarioJSON.put("login", usuario.getLogin());
        usuarioJSON.put("nombre", usuario.getNombre());
        usuarioJSON.put("password", usuario.getPassword());
        usuarioJSON.put("rol", usuario.getRol());
        usuarioJSON.put("telefono", usuario.getTelefono());
        usuarioJSON.put("verificado", usuario.isVerificado());

        JSONObject valoresEspecialesJSON = new JSONObject();

        switch (usuario.getRol()) 
        {
            case "cajero":
            	
                valoresEspecialesJSON.put("comprasRegistradas", new ArrayList<Compra>()); 

              
                break;
            case "operador" :
                
                valoresEspecialesJSON.put("idSubastas",new ArrayList<String>());
               
            case "administrador":

                valoresEspecialesJSON.put("soyAdmin", true);
               
                break;
            case "comprador":
            
                Comprador comprador = (Comprador) usuario;
                valoresEspecialesJSON.put("estadoCuenta", comprador.getEstadoCuenta());
                valoresEspecialesJSON.put("maxCompras", comprador.getMaxCompras());
                valoresEspecialesJSON.put("mora", comprador.isMora());
                valoresEspecialesJSON.put("historialCompras", new ArrayList<Compra>());
                valoresEspecialesJSON.put("mensajesSubasta", new ArrayList<Mensaje>());
                valoresEspecialesJSON.put("idPiezasCompradas", new ArrayList<String>());

                break;

            case "propietario" :

                valoresEspecialesJSON.put("idPiezasActuales", new ArrayList<String>());
                valoresEspecialesJSON.put("historialPiezas", new ArrayList<String>());

                break;
            default:
                System.out.println("Rol no reconocido. Los valores especiales no se guardarán.");
        }

        usuarioJSON.put("valores_especiales", valoresEspecialesJSON);
        usuariosJSON.put(usuarioJSON);
        guardarBaseDeDatos(baseDatos);
        System.out.println("Registro exitoso.");
    }
      
      

    public static JSONObject leerBaseDeDatos()
     {
        try {
            Scanner scanner = new Scanner(new File("Proyecto/Archivos/base_de_datos_usuarios.json"));
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
        try (FileWriter file = new FileWriter("Proyecto/Archivos/base_de_datos_usuarios.json")) 
        {
            file.write(baseDeDatosJSON.toString(4));
            System.out.println("Base de datos actualizada y guardada.");
        } catch (IOException e) {
            System.out.println("Error al guardar la base de datos.");
            e.printStackTrace();
        }
    }


    public static void actualizarPropietario(Propietario propietario)
    {

    }
























    public static void iniciarSesion() 
    {
        
    }
    
}


