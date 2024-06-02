package Pasarelas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Historia;

public class menuBancolombia
 {
    private static final String NOMBRE_ARCHIVO = "Proyecto/Pasarelas/ArchivosBancos/Bancolombia.json";
    private static JSONObject baseDeDatosJSON = leerBaseDeDatos();
    private static JSONArray cuentasArray = baseDeDatosJSON.getJSONArray("cuentas");
    private static Scanner scanner = new Scanner(System.in);

    public static boolean menu(Historia historia) {
        System.out.println("Ingresar usuario");
        String usuario = scanner.nextLine();
        System.out.println("Ingresar Clave");
        String clave = scanner.nextLine();
        System.out.println("Ingresar csv");
        String csv = scanner.nextLine();

        for (int i = 0; i < cuentasArray.length(); i++) {
            JSONObject cuenta = cuentasArray.getJSONObject(i);
            if (cuenta.getString("nombre").equals(usuario) && cuenta.getString("clave").equals(clave) && cuenta.getString("csv").equals(csv)) {
                int valor = Integer.parseInt(cuenta.getString("dinero"));
                if (valor >= historia.getMonto()) 
                {
                    valor -= historia.getMonto();
                    cuenta.put("dinero", (Integer.toString(valor)));
                    
                    guardarBaseDeDatos(baseDeDatosJSON); // Guardar la base de datos completa
                    System.out.println("Pago realizado con exito");
                    return true;
                }
                System.out.println("El pago no pudo ser realizado por falta de dinero");
                return false;
            }
        }
        System.out.println("Usuario, CSV o Clave incorrecto");
        return false;
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

    


