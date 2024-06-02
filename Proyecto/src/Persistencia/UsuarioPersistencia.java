package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Compra;
import Logica.Comprador;

import Logica.Propietario;
import Logica.Usuario;

public class UsuarioPersistencia {

    private static final String NOMBRE_ARCHIVO = "Proyecto/Archivos/base_de_datos_usuarios.json";
    private static JSONObject baseDatos = leerBaseDeDatos();
    private static JSONArray usuariosJSON = baseDatos.getJSONArray("usuarios");

    public static void registrarUsuario(Usuario usuario) {
        JSONObject usuarioJSON = new JSONObject();
        usuarioJSON.put("login", usuario.getLogin());
        usuarioJSON.put("nombre", usuario.getNombre());
        usuarioJSON.put("password", usuario.getPassword());
        usuarioJSON.put("rol", usuario.getRol());
        usuarioJSON.put("telefono", usuario.getTelefono());
        usuarioJSON.put("verificado", usuario.isVerificado());

        JSONObject valoresEspecialesJSON = new JSONObject();
        switch (usuario.getRol()) {
            case "cajero":
                valoresEspecialesJSON.put("comprasRegistradas", new JSONArray());
                break;
            case "operador":
                valoresEspecialesJSON.put("idSubastas", new JSONArray());
                break;
            case "administrador":
                valoresEspecialesJSON.put("soyAdmin", true);
                break;
            case "comprador":
                Comprador comprador = (Comprador) usuario;
                valoresEspecialesJSON.put("estadoCuenta", comprador.getEstadoCuenta());
                valoresEspecialesJSON.put("maxCompras", comprador.getMaxCompras());
                valoresEspecialesJSON.put("mora", comprador.isMora());
                valoresEspecialesJSON.put("historialCompras", new JSONArray());
                valoresEspecialesJSON.put("mensajesSubasta", new JSONArray());
                valoresEspecialesJSON.put("idPiezasCompradas", new JSONArray());
                break;
            case "propietario":
                valoresEspecialesJSON.put("idPiezasActuales", new JSONArray());
                valoresEspecialesJSON.put("historialPiezas", new JSONArray());
                break;
            default:
                System.out.println("Rol no reconocido. Los valores especiales no se guardarán.");
        }

        usuarioJSON.put("valores_especiales", valoresEspecialesJSON);
        usuariosJSON.put(usuarioJSON);
        guardarBaseDeDatos(baseDatos);

    }

    public static JSONObject leerBaseDeDatos() {
        try {
            Scanner scanner = new Scanner(new File(NOMBRE_ARCHIVO));
            StringBuilder jsonText = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonText.append(scanner.nextLine());
            }
            scanner.close();
            return new JSONObject(jsonText.toString());
        } catch (FileNotFoundException e) {
            return new JSONObject().put("usuarios", new JSONArray());
        }
    }

    private static void guardarBaseDeDatos(JSONObject baseDeDatosJSON) {
        try (FileWriter file = new FileWriter(NOMBRE_ARCHIVO)) {
            file.write(baseDeDatosJSON.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarUsuario(Usuario usuario) 
    {
        for (int i = 0; i < usuariosJSON.length(); i++) {
            JSONObject objUsuario = usuariosJSON.getJSONObject(i);
            if (objUsuario.getString("login").equals(usuario.getLogin())) {
                usuariosJSON.remove(i);
                registrarUsuario(usuario);
                break;
            }
        }
    }

    public static void actualizarPropietario(Propietario propietario) {
        actualizarUsuario(propietario);
    }

    public static void actualizarCompradorCompra(Comprador comprador) 
    {
        actualizarUsuario(comprador);
        JSONObject compradorJson = usuariosJSON.getJSONObject(usuariosJSON.length()-1);
        JSONObject valoresEspeciales = compradorJson.getJSONObject("valores_especiales");
        valoresEspeciales.put("historialCompras", comprador.getHistorialCompras());
        valoresEspeciales.put("mensajesSubasta", comprador.getMensajesSubasta());
        valoresEspeciales.put("idPiezasCoompradas", comprador.getIdpiezasCompradas());

    }

    public static void actualizarPropietarioCompra(Propietario propietarioAnterior, Propietario nuevoPropietario) {
        actualizarUsuario(propietarioAnterior);
        actualizarUsuario(nuevoPropietario);
        JSONObject propietarioAnteriorJson = usuariosJSON.getJSONObject(usuariosJSON.length()-2);
        JSONObject nuevoPropietarioJson = usuariosJSON.getJSONObject(usuariosJSON.length()-1);
        JSONObject valoresEspeciales1 = propietarioAnteriorJson.getJSONObject("valores_especiales");
        JSONObject valoresEspeciales2 = nuevoPropietarioJson.getJSONObject("valores_especiales");
        valoresEspeciales1.put("idPiezasActuales", propietarioAnterior.getIdPiezasActuales());
        valoresEspeciales1.put("historialPiezas", nuevoPropietario.getHistorialPiezas());
        valoresEspeciales2.put("idPiezasActuales", propietarioAnterior.getIdPiezasActuales());
        valoresEspeciales2.put("historialPiezas", nuevoPropietario.getHistorialPiezas());

    }
    
    public static void iniciarSesion() 
    {
        // Implementar lógica de inicio de sesión si es necesario
    }

    public static void actualizarRegistroCompraSubasta(String loginPropietarioAnterior, String loginPropietarioNuevo, String loginComprador) {
        // Implementar lógica de actualización de registros de compra/subasta si es necesario
    }
}
