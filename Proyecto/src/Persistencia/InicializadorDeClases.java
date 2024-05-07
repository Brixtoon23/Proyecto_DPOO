package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Administrador;
import Logica.Cajero;
import Logica.Comprador;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Galeria;
import Logica.Inventario;
import Logica.Pieza;
import Logica.Pintura;
import Logica.Propietario;
import Logica.Subasta;
import Logica.Usuario;
import Logica.Video;

public class InicializadorDeClases 
{

    public static Galeria cargarGaleria() 
    
    {
        Galeria galeriaRetornada = new Galeria(null, 0, null, null, null);
        try 
        {
        // Especifica la ruta del archivo JSON con la carpeta "Archivos"
        String rutaArchivoPiezas = "Proyecto/Archivos/base_de_datos_piezas.json";
        String rutaArchivoUsuarios = "Proyecto/Archivos/base_de_datos_usuarios.json";
        String rutaArchivoSubastas = "Proyecto/Archivos/base_de_datos_subastas.json";
        String rutaArchivoAutores = "Proyecto/Archivos/base_de_datos_autores.json";



            // Crea un objeto File con la ruta del archivo
            File archivoPiezas = new File(rutaArchivoPiezas);
            File archivoUsuarios = new File(rutaArchivoUsuarios);
            File archivoSubastas = new File(rutaArchivoSubastas);
       

            // Crea un Scanner para leer el contenido del archivo JSON
            Scanner scannerPiezas = new Scanner(archivoPiezas);
            Scanner scannerUsuarios = new Scanner(archivoUsuarios);
            Scanner scannerSubastas = new Scanner(archivoSubastas);

            // Lee todo el contenido del archivo y lo almacena en un StringBuilder
            StringBuilder subastasStringBuilder = new StringBuilder();
            while (scannerSubastas.hasNextLine()) {
                subastasStringBuilder.append(scannerPiezas.nextLine());
            }
            StringBuilder piezasStringBuilder = new StringBuilder();
            while (scannerPiezas.hasNextLine()) {
                piezasStringBuilder.append(scannerPiezas.nextLine());
            }
            StringBuilder usuariosStringBuilder = new StringBuilder();
            while (scannerUsuarios.hasNextLine()) 
            {
                usuariosStringBuilder.append(scannerUsuarios.nextLine());
            }

            // Cierra el scanner
            scannerPiezas.close();
            scannerUsuarios.close();
            scannerSubastas.close();

            // Convierte el contenido del StringBuilder a String
            String piezasString = piezasStringBuilder.toString();
            String usuariosString = usuariosStringBuilder.toString();
            String subastasString = subastasStringBuilder.toString();

            // Convierte el String JSON en un objeto JSONObject
            JSONObject piezasObject = new JSONObject(piezasString);
            JSONObject usuariosObject = new JSONObject(usuariosString);
            JSONObject subastasObject = new JSONObject(subastasString);
            

            // Obtiene el array "piezas" del JSON
            JSONArray piezasArray = piezasObject.getJSONArray("piezas");
            JSONArray usuariosArray = usuariosObject.getJSONArray("usuarios");
            JSONArray subastasArray = subastasObject.getJSONArray("subastas");

            // Inicializa variables necesarias

            //ArrayList<Object> galeria =new ArrayList<Object>();
            //ArrayList<Object> piezasBodega = new ArrayList<Object>();
            ArrayList<Pieza> piezasBodegaObjeto = new ArrayList<Pieza>();  
            //ArrayList<Object> usuariosLista = new ArrayList<Object>(); 
            //ArrayList<Object> piezasExhibida = new ArrayList<Object>();
            ArrayList<Pieza> piezasExhibidasObjeto = new ArrayList<Pieza>();
            
           

            //HashMap<String,Integer> totalObras = new HashMap<String,Integer>();
            //HashMap<String,String> nombreGaleria = new HashMap<String,String>();
            //HashMap<String,ArrayList<Object>> usuarios = new HashMap<String,ArrayList<Object>>();
            //HashMap<String,ArrayList<Object>> inventario = new HashMap<String,ArrayList<Object>>();

            

            // crea las listas para almacenar piezas en bodega o exhibicion
            for (int i = 0; i < piezasArray.length(); i++) 
            
            {
                JSONObject pieza = piezasArray.getJSONObject(i);
                ArrayList<String> autores = new ArrayList<String>();
                ArrayList<Integer> valores = new ArrayList<Integer>();
                ArrayList<String> historialPropietarios = new ArrayList<String>();
                JSONArray autoresJson = pieza.getJSONArray("autores");
                JSONArray propietariosJson = pieza.getJSONArray("historialPropietarios");
                int tamanioAutores = autoresJson.length();
                int tamanioPropietarios = propietariosJson.length();
                JSONArray historialPropietariosJson=pieza.getJSONArray("historialPropietarios");
                int tamanioPropietariosJson= historialPropietariosJson.length();

                for (int e = 0; e < tamanioAutores; e++) 
                {
                    historialPropietarios.add(propietariosJson.getString(e));
                }
                
                for (int e = 0; e < tamanioAutores; e++) 
                {
                    autores.add(autoresJson.getString(e));
                }

                JSONArray valoresJson = pieza.getJSONArray("valores");
                int tamaniovalores = valoresJson.length();
                
                for (int e = 0; e < tamaniovalores; e++) 
                {
                    valores.add(valoresJson.getInt(e));
                }
                Pieza piezaParaAñadir = null;
                String tipo = pieza.getString("tipo");

                ArrayList<Map<String,String>>  historialPropietarios= new ArrayList<>();
                

               

                for (int f=0 ;  f < tamanioPropietariosJson; f++)
                {

                }



               


                

                
                

                if (tipo.equals("pintura")) 
                {
                    piezaParaAñadir = new Pintura(pieza.getString("titulo"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores , pieza.getBoolean("disponible"),
                                                pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores, historialPropietarios,  pieza.getBoolean("bodega"), 
                                                pieza.getString("tipo"),pieza.getJSONObject("valoresEspeciales").getInt("alto"), pieza.getJSONObject("valoresEspeciales").getInt("ancho"),
                                                pieza.getJSONObject("valoresEspeciales").getInt("peso"),pieza.getJSONObject("valoresEspeciales").getString("tecnica"), pieza.getJSONArray("historialDueños"));
                }
                else if (tipo.equals("video")) 
                {
                    piezaParaAñadir = new Video(pieza.getString("titulo"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores , pieza.getBoolean("disponible"),
                                                pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores, historialPropietarios,  pieza.getBoolean("bodega"), pieza.getString("tipo"), 
                                                pieza.getJSONObject("valoresEspeciales").getInt("duracion"), pieza.getJSONObject("valoresEspeciales").getInt("tamanioGiga"), 
                                                pieza.getJSONObject("valoresEspeciales").getString("resolucion"));
                }
                else if (tipo.equals("fotografia")) 
                {
                    piezaParaAñadir = new Fotografia(pieza.getString("titulo"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores , pieza.getBoolean("disponible"),
                                                    pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores, historialPropietarios,  pieza.getBoolean("bodega"), pieza.getString("tipo"), 
                                                    pieza.getJSONObject("valoresEspeciales").getString("resolucion"), pieza.getJSONObject("valoresEspeciales").getInt("tamanioGiga"));
                }
                else if (tipo.equals("escultura")) 
                {
                    piezaParaAñadir = new Escultura(pieza.getString("titulo"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores , pieza.getBoolean("disponible"),
                                                pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores, historialPropietarios,  pieza.getBoolean("bodega"), 
                                                pieza.getString("tipo"), pieza.getJSONObject("valoresEspeciales").getInt("alto"), pieza.getJSONObject("valoresEspeciales").getInt("ancho"), 
                                                pieza.getJSONObject("valoresEspeciales").getInt("profundidad"), pieza.getJSONObject("valoresEspeciales").getInt("peso"),
                                                pieza.getJSONObject("valoresEspeciales").getBoolean("electricidad"));
                }


                if (pieza.getBoolean("bodega") == true)
                {
    
                        //piezasBodega.add(piezasArray.get(i));

                        piezasBodegaObjeto.add(piezaParaAñadir);
                }
                else
                {
                        //piezasExhibida.add(piezasArray.get(i));

                        piezasExhibidasObjeto.add(piezaParaAñadir);
                }         
                                
            }
            

            ArrayList<Usuario> usuariosObjeto = new ArrayList<Usuario>(); 

            for (int i = 0; i < usuariosArray.length(); i++) 
            {

                JSONObject usuario = usuariosArray.getJSONObject(i);

                String rol = usuario.getString("rol");
                Usuario usuarioParaAñadir = null ;

                if (rol.equals("administrador")) 
                {
                    usuarioParaAñadir = new Administrador(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), usuario.getString("telefono"), 
                    usuario.getBoolean("verificado"));

                }
                else if (rol.equals("propietario"))
                {

                    

                    usuarioParaAñadir = new Propietario(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), usuario.getString("telefono"), 
                    usuario.getBoolean("verificado"), piezasExhibidasObjeto, piezasExhibidasObjeto);
                }
                else if (rol.equals("cajero")) 
                {
                    usuarioParaAñadir = new Cajero(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), usuario.getString("telefono"), 
                    usuario.getBoolean("verificado"), null);

                }
                else if (rol.equals("comprador")) 
                {
                    usuarioParaAñadir = new Comprador(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), usuario.getString("telefono"), 
                    usuario.getBoolean("verificado"), i, null, i, false, piezasExhibidasObjeto, null);

                }
                
                usuariosObjeto.add(usuarioParaAñadir);
                
    
                        //piezasBodega.add(piezasArray.get(i));

                        
                 
                            
                                
            }
            ArrayList<Subasta> subastasObjeto = new ArrayList<Subasta>();
            ArrayList<Pieza> listaPiezas = new ArrayList<Pieza>(); 
            for (int i = 0; i < subastasArray.length(); i++) 
            {
                JSONObject subasta = subastasArray.getJSONObject(i);
                JSONArray listaPiezasArray = subasta.getJSONArray("listaPiezas");

                for (int a = 0; a < listaPiezasArray.length(); a++) 
                {
                   listaPiezasArray.get(a);



                }
                


                Subasta subastaParaAñadir = new Subasta(subasta.getString("id"), null, piezasExhibidasObjeto, null);



            }





            int totalObras = piezasBodegaObjeto.size() + piezasExhibidasObjeto.size();

            Inventario inventario = new Inventario(piezasBodegaObjeto,piezasExhibidasObjeto);
            
            //totalObras.put("totalObras", piezasArray.length())  ;
            //usuarios.put("usuarios", usuariosLista);
            //inventario.put("piezasBodega", piezasBodega);
            //inventario.put("piezasExhibicion", piezasExhibida);
            //nombreGaleria.put("nombre", "Galeria God");
            
            //galeria.add(inventario);
            //galeria.add(usuarios);
            //galeria.add(nombreGaleria);
            //galeria.add(totalObras);
            System.out.println(piezasBodegaObjeto);


            galeriaRetornada = new Galeria("GaleriaDakol", totalObras,inventario , usuariosObjeto, null) ;

            
        }catch (FileNotFoundException e) 
        {
            
                e.printStackTrace();
        }

        return galeriaRetornada;
        
    }
    
}
