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
        String ward = "a" ;
        int cont = 0 ;
        while (ward.equals("a") && cont != listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getLogin().equals(login))
            {
                ward = "b";
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
        String ward = "a" ;
        int cont = 0 ;
        while (ward.equals("a") && cont != listaUsuarios.size()) 
         {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getLogin().equals(login)&&usuario.getPassword().equals(password))
            {
                ward = "b";
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

        String ward = "a" ;
        int cont = 0 ;

        ArrayList<Usuario>listaUsuarios = galeria.getUsuarios();
        Propietario propietario;
        while (ward.equals("a") && cont != listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getRol().equals("propietario")&&usuario.getLogin().equals(login))
            {
                propietario = (Propietario) usuario;
                ward = "b";
                return propietario;

            }
            else
            {
                cont ++ ;

            }

        }


        return null;

    }

    public static Pieza buscarPiezaSubasta(Galeria galeria, String nombrePieza)
    {

        String ward = "a" ;
        int cont = 0 ;
        Inventario inventario= galeria.getInventario();

        ArrayList<Pieza> listaPiezasExhibidas = inventario.getPiezasExhibidad();
        ArrayList<Pieza> listaPiezasBodega = inventario.getPiezasExhibidad();

     
        while (ward.equals("a") && cont != listaPiezasExhibidas.size()) 
        {
            Pieza pieza = listaPiezasExhibidas.get(cont);
            if (pieza.getTitulo().equals(nombrePieza))
            {
               Pieza piezaSubastada = pieza;
                ward = "b";
                return piezaSubastada;

            }
            else
            {
                cont ++ ;

            }

        }

        
        while (ward.equals("a") && cont != listaPiezasExhibidas.size()) 
        {
            Pieza pieza = listaPiezasExhibidas.get(cont);
            if (pieza.getTitulo().equals(nombrePieza))
            {
               Pieza piezaSubastada = pieza;
                ward = "b";
                return piezaSubastada;

            }
            else
            {
                cont ++ ;

            }

        }

         
        while (ward.equals("a") && cont !=  listaPiezasBodega.size()) 
        {
            Pieza pieza =  listaPiezasBodega.get(cont);
            if (pieza.getTitulo().equals(nombrePieza))
            {
               Pieza piezaSubastada = pieza;
                ward = "b";
                return piezaSubastada;

            }
            else
            {
                cont ++ ;

            }

        }



        return null;

    }


    public static Operador buscarOperador(Galeria galeria, String login)
    {

        String ward = "a" ;
        int cont = 0 ;

        ArrayList<Usuario>listaUsuarios = galeria.getUsuarios();
        Operador operador;
        while (ward.equals("a") && cont != listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getRol().equals("operador")&&usuario.getLogin().equals(login))
            {
                operador = (Operador) usuario;
                ward = "b";
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

        String ward = "a" ;
        int cont = 0 ;

        ArrayList<Usuario>listaUsuarios = galeria.getUsuarios();
        Comprador comprador;
        while (ward.equals("a") && cont != listaUsuarios.size()) 
        {
            Usuario usuario = listaUsuarios.get(cont);
            if (usuario.getRol().equals("comprador")&& usuario.getLogin().equals(login))
            {
                comprador = (Comprador) usuario;
                ward = "b";
                return comprador;

            }
            else
            {
                cont ++ ;

            }

        }


        return null;

    }
    
}

