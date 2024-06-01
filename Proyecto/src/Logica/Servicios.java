package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class Servicios 
{
    public static boolean verificarLoginRepetido(Galeria galeria, String login)
    {
        ArrayList<Usuario> listaUsuarios = galeria.getUsuarios();
        int cont = 0 ;
        while ( cont < listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getLogin().equals(login))
            {
                return true;
            }
            else
            {
                cont ++ ;
            }

            
        }

        return false ;
    }

    public static JSONObject leerBaseDeDatosUsuarios() 
    {
        try {
            Scanner scanner = new Scanner(new File("Archivos/base_de_datos_usuarios.json"));
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

    public static Usuario inicioLogin(Galeria galeria, String login, String password)
    {
        ArrayList<Usuario> listaUsuarios = galeria.getUsuarios();
        int cont = 0 ;
        while (cont < listaUsuarios.size()) 
         {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getLogin().equals(login)&&usuario.getPassword().equals(password))
            {
                return usuario;
            }
            else
            {
                cont ++ ;
            }

         }

        return null;
    }

    public static Propietario buscarPropietario(Galeria galeria, String login)
    {

        int cont = 0 ;

        ArrayList<Usuario>listaUsuarios = galeria.getUsuarios();
        Propietario propietario;
        while (cont < listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getRol().equals("propietario")&&usuario.getLogin().equals(login))
            {
                propietario = (Propietario) usuario;
                return propietario;

            }
            else
            {
                cont ++ ;

            }

        }


        return null;

    }

    public static Pieza buscarPieza(Galeria galeria, String nombrePieza)
    {

        int cont1 = 0 ;
        int cont2 = 0 ;
        Inventario inventario= galeria.getInventario();

        ArrayList<Pieza> listaPiezasExhibidas = inventario.getPiezasExhibidad();
        ArrayList<Pieza> listaPiezasBodega = inventario.getPiezasBodega();

     
        while (cont1 < listaPiezasExhibidas.size()) 
        {
            Pieza pieza = listaPiezasExhibidas.get(cont1);
            if (pieza.getTitulo().equals(nombrePieza))
            {
               Pieza piezaSubastada = pieza;
                return piezaSubastada;

            }
            else
            {
                cont1 ++ ;

            }

        }

         
        while (cont2 <  listaPiezasBodega.size()) 
        {
            Pieza pieza =  listaPiezasBodega.get(cont2);
            if (pieza.getTitulo().equals(nombrePieza))
            {
               Pieza piezaSubastada = pieza;
                return piezaSubastada;

            }
            else
            {
                cont2 ++ ;

            }

        }



        return null;

    }


    public static Operador buscarOperador(Galeria galeria, String login)
    {

        int cont = 0 ;

        ArrayList<Usuario>listaUsuarios = galeria.getUsuarios();
        Operador operador;
        while (cont < listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getRol().equals("operador")&&usuario.getLogin().equals(login))
            {
                operador = (Operador) usuario;

                return operador;

            }
            else
            {
                cont ++ ;

            }

        }


        return null;

    }

    public static Comprador buscarComprador(Galeria galeria, String login)
    {


        int cont = 0 ;

        ArrayList<Usuario>listaUsuarios = galeria.getUsuarios();
        Comprador comprador;
        while ( cont < listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getRol().equals("comprador")&& usuario.getLogin().equals(login))
            {
                comprador = (Comprador) usuario;

                return comprador;

            }
            else
            {
                cont ++ ;

            }

        }


        return null;

    }

    public static Tarjeta buscarTarjeta(Galeria galeria, int numeroTarjeta)
    {

        int cont = 0 ;
        ArrayList<Tarjeta>listaTarjetas = galeria.getTarjetas();
        while ( cont < listaTarjetas.size()) 
        {
            Tarjeta tarjeta = listaTarjetas.get(cont);

            if (numeroTarjeta== tarjeta.getNumero())
            
            {

                return tarjeta;

            }
            else
            {
                cont ++ ;

            }

        }


        return null;

    }





    public static void imprimirPiezas(Galeria galeria,boolean subasta)
    {
        int ward = 0;
        ArrayList<Pieza> piezasArray = galeria.getInventario().getPiezasBodega();
        for (Pieza pieza : piezasArray) 
        {
            if (subasta)
            {
                imprimirPieza(pieza,ward);
                
            }
            else
            {
                imprimirPieza(pieza, ward);
            }
            
        ward++;
        }

    }
    
    public static void imprimirPieza(Pieza pieza,int ward)
    {
        
        System.out.println("Pieza " + (ward + 1) + ":");
        System.out.println("  Título: " + pieza.getTitulo());
        System.out.println("  Año de creación: " + pieza.getAnioCreacion());
        System.out.println("  Lugar de creación: " + pieza.getAnioCreacion());
        System.out.println("  Autor/es: " + pieza.getAutor().toString());
        System.out.println("  Disponible: " + pieza.isDisponible());
        System.out.println("  Tiempo de consignación: " + pieza.getTiempoConsignacion());
        System.out.println("  En subasta: " + pieza.isSubasta());
        System.out.println("  Valores: " + pieza.getValores().toString());
        System.out.println("  Propietario: " + pieza.getLoginPropietarioActual());
        System.out.println("  En bodega: " + pieza.isBodega());
        System.out.println("  Tipo: " + pieza.getTipo());
        switch (pieza.getTipo()) 
        {
            case "pintura":
                Pintura pintura = (Pintura) pieza;
                System.out.println("    Alto: " + pintura.getAlto());
                System.out.println("    Ancho: " + pintura.getAncho());
                System.out.println("    Peso: " + pintura.getPeso());
                System.out.println("    Técnica: " + pintura.getTecnica());
                break;
            case "fotografia":
                Fotografia fotografia = (Fotografia) pieza;
                System.out.println("    Resolución: " + fotografia.getResolucion());
                System.out.println("    Tamaño en gigas: " + fotografia.getTamanioGiga());
                break;
            case "escultura":
                Escultura escultura = (Escultura) pieza;
                System.out.println("    Alto: " + escultura.getAlto());
                System.out.println("    Ancho: " + escultura.getAncho());
                System.out.println("    Profundidad: " + escultura.getProfundidad());
                System.out.println("    Peso: " + escultura.getPeso());
                System.out.println("    ¿Necesita electricidad?: " + escultura.isElectricidad());
                break;
            case "video":
                Video video = (Video) pieza;
                System.out.println("    Duración en minutos: " + video.getDuracion());
                System.out.println("    Tamaño en gigas: " + video.getTamanioGiga());
                System.out.println("    Resolución: " + video.getResolucion());
                break;
            default:
                System.out.println("  Valores especiales no reconocidos.");
        }

    }

    public static Tarjeta metodoPagoTarjeta(String nombre , String login_comprador, int numero, int pin, int csv, int  monto )
    {
        Tarjeta tarjeta = new Tarjeta(nombre, monto, login_comprador, numero, pin, csv);

        return tarjeta ;

    }

    public static Efectivo metodoPagoEfectivo(String nombre, int monto )
    {
        Efectivo efectivo = new Efectivo(nombre, monto);
        return efectivo;
    }

    public static Transferencia metodoPagoEfectivo(String nombre, int monto, String id)
    {
        Transferencia transferencia  = new Transferencia(nombre, monto, nombre, id);
        return transferencia;
    }



    


}

