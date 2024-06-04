package Pasarelas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import Logica.Historia;

public class menuBancolombia {
    private static final String NOMBRE_ARCHIVO = "Proyecto/Pasarelas/ArchivosBancos/Bancolombia.json";
    private static JSONObject baseDeDatosJSON = leerBaseDeDatos();
    private static JSONArray cuentasArray = baseDeDatosJSON.getJSONArray("cuentas");

    public static String menu(Historia historia, String csv, String clave) {
        for (int i = 0; i < cuentasArray.length(); i++) {
            JSONObject cuenta = cuentasArray.getJSONObject(i);
            if (cuenta.getString("csv").equals(csv) && cuenta.getString("clave").equals(clave)) {
                int valor = Integer.parseInt(cuenta.getString("dinero"));
                if (valor >= historia.getMonto()) {
                    valor -= historia.getMonto();
                    cuenta.put("dinero", Integer.toString(valor));
                    guardarBaseDeDatos(baseDeDatosJSON);
                    return "Pago realizado con éxito";
                }
                return "El pago no pudo ser realizado por falta de dinero";
            }
        }
        return "Usuario, CSV o Clave incorrecto";
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
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONObject().put("cuentas", new JSONArray());
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

    


