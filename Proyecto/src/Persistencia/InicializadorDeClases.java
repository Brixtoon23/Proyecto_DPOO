package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Logica.Administrador;
import Logica.Cajero;
import Logica.Compra;
import Logica.Comprador;
import Logica.Efectivo;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Galeria;
import Logica.Inventario;
import Logica.Mensaje;
import Logica.MetodoPago;
import Logica.Oferta;
import Logica.Operador;
import Logica.Pieza;
import Logica.Pintura;
import Logica.Propietario;
import Logica.Subasta;
import Logica.Tarjeta;
import Logica.Transferencia;
import Logica.Usuario;
import Logica.Video;

public class InicializadorDeClases 
{

    public static Galeria cargarGaleria() 
    
    {
        Galeria galeriaRetornada = new Galeria(null, 0, null, null, null,null,null,null);
        try 
        {
        // Especifica la ruta del archivo JSON con la carpeta "Archivos"
        String rutaArchivoPiezas = "Proyecto/Archivos/base_de_datos_piezas.json";
        String rutaArchivoUsuarios = "Proyecto/Archivos/base_de_datos_usuarios.json";
        String rutaArchivoSubastas = "Proyecto/Archivos/base_de_datos_subastas.json";
        String rutaArchivoAutores = "Proyecto/Archivos/base_de_datos_autores.json";
        String rutaArchivoTarjetas = "Proyecto/Archivos/base_de_datos_tarjetas.json";
        String rutaArchivoTransferencias = "Proyecto/Archivos/base_de_datos_transferencias.json";



            // Crea un objeto File con la ruta del archivo
            File archivoPiezas = new File(rutaArchivoPiezas);
            File archivoUsuarios = new File(rutaArchivoUsuarios);
            File archivoSubastas = new File(rutaArchivoSubastas);
            File archivoAutores = new File(rutaArchivoAutores);
            File archivoTarjetas = new File(rutaArchivoTarjetas);
            File archivoTransferencias = new File(rutaArchivoTransferencias);
       

            // Crea un Scanner para leer el contenido del archivo JSON
            Scanner scannerPiezas = new Scanner(archivoPiezas);
            Scanner scannerUsuarios = new Scanner(archivoUsuarios);
            Scanner scannerSubastas = new Scanner(archivoSubastas);
            Scanner scannerAutores = new Scanner(archivoAutores);
            Scanner scannerTrajetas = new Scanner(archivoTarjetas);
            Scanner scannerTransferencias = new Scanner(archivoTransferencias);


            // Lee todo el contenido del archivo y lo almacena en un StringBuilder
            StringBuilder subastasStringBuilder = new StringBuilder();
            while (scannerSubastas.hasNextLine()) {
                subastasStringBuilder.append(scannerSubastas.nextLine());
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
            StringBuilder autoresStringBuilder = new StringBuilder();
            while (scannerAutores.hasNextLine()) 
            {
                autoresStringBuilder.append(scannerAutores.nextLine());
            }
            StringBuilder tarjetasStringBuilder = new StringBuilder();
            while (scannerTrajetas.hasNextLine()) 
            {
                tarjetasStringBuilder.append(scannerTrajetas.nextLine());
            }
            StringBuilder transferenciasStringBuilder = new StringBuilder();
            while (scannerTransferencias.hasNextLine()) 
            {
                transferenciasStringBuilder.append(scannerTransferencias.nextLine());
            }

            // Cierra el scanner
            scannerPiezas.close();
            scannerUsuarios.close();
            scannerSubastas.close();
            scannerAutores.close();
            scannerTrajetas.close();
            scannerTransferencias.close();

            // Convierte el contenido del StringBuilder a String
            String piezasString = piezasStringBuilder.toString();
            String usuariosString = usuariosStringBuilder.toString();
            String subastasString = subastasStringBuilder.toString();
            String autoresString = autoresStringBuilder.toString();
            String tarjetasString = tarjetasStringBuilder.toString();
            String transferenciasString = transferenciasStringBuilder.toString();

            // Convierte el String JSON en un objeto JSONObject
            JSONObject piezasObject = new JSONObject(piezasString);
            JSONObject usuariosObject = new JSONObject(usuariosString);
            JSONObject subastasObject = new JSONObject(subastasString);
            JSONObject autoresObject = new JSONObject(autoresString);
            JSONObject tarjetasObject = new JSONObject(tarjetasString);
            JSONObject transferenciasObject = new JSONObject(transferenciasString);
            

            // Obtiene el array "piezas" del JSON
            JSONArray piezasArray = piezasObject.getJSONArray("piezas");
            JSONArray usuariosArray = usuariosObject.getJSONArray("usuarios");
            JSONArray subastasArray = subastasObject.getJSONArray("subastas");
            JSONArray autoresArray = autoresObject.getJSONArray("autores");
            JSONArray tarjetasArray = tarjetasObject.getJSONArray("tarjetas");
            JSONArray transferenciasArray = transferenciasObject.getJSONArray("transferencias");

            // Inicializa variables necesarias

            ArrayList<Pieza> piezasBodegaObjeto = new ArrayList<Pieza>();  

            ArrayList<Pieza> piezasExhibidasObjeto = new ArrayList<Pieza>();
            
                 

            // crea las listas para almacenar piezas en bodega o exhibicion
            for (int i = 0; i < piezasArray.length(); i++) 
            
            {
                JSONObject pieza = piezasArray.getJSONObject(i);
                ArrayList<String> autores = new ArrayList<String>();
                ArrayList<Integer> valores = new ArrayList<Integer>();
                ArrayList<Map<String,Object>>  historialPropietarios= new ArrayList<Map<String,Object>>();


                JSONArray autoresJson = pieza.getJSONArray("autores");
                int tamanioAutores = autoresJson.length();

                JSONArray historialPropietariosJson=pieza.getJSONArray("historialPropietarios");
                int tamanioPropietariosJson= historialPropietariosJson.length();
                

                for (int e = 0; e < tamanioPropietariosJson; e++) 
                {
                    JSONObject histoProp = historialPropietariosJson.getJSONObject(e);
                    Map<String,Object> mapaPropietarios = new HashMap<String,Object>();
                    mapaPropietarios.put("loginPropietario", histoProp.getString("loginPropietario"));
                    mapaPropietarios.put("fechaVenta", histoProp.getString("fechaVenta"));
                    mapaPropietarios.put("valorCompra", histoProp.getInt("valorCompra"));
                    historialPropietarios.add(mapaPropietarios);
                    

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
                  

                if (tipo.equals("pintura")) 
                {
                    piezaParaAñadir = new Pintura(pieza.getString("titulo"),pieza.getString("loginPropietarioActual"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores 
                                                , pieza.getBoolean("disponible"),pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores,  pieza.getBoolean("bodega"), 
                                                pieza.getString("tipo"),historialPropietarios,pieza.getJSONObject("valoresEspeciales").getInt("alto"), pieza.getJSONObject("valoresEspeciales").getInt("ancho"),
                                                pieza.getJSONObject("valoresEspeciales").getInt("peso"),pieza.getJSONObject("valoresEspeciales").getString("tecnica"),pieza.getString("rutaImagen"));




                }
                else if (tipo.equals("video")) 
                {
                    piezaParaAñadir = new Video(pieza.getString("titulo"),pieza.getString("loginPropietarioActual"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores , 
                                                pieza.getBoolean("disponible"),pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores, pieza.getBoolean("bodega"), 
                                                pieza.getString("tipo"),historialPropietarios,pieza.getJSONObject("valoresEspeciales").getInt("duracion"), 
                                                pieza.getJSONObject("valoresEspeciales").getInt("tamanioGiga"),pieza.getJSONObject("valoresEspeciales").getString("resolucion"),pieza.getString("rutaImagen"));
                }
                else if (tipo.equals("fotografia")) 
                {
                    piezaParaAñadir = new Fotografia(pieza.getString("titulo"),pieza.getString("loginPropietarioActual"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores 
                                                    , pieza.getBoolean("disponible"),pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores,  pieza.getBoolean("bodega"), 
                                                    pieza.getString("tipo"), historialPropietarios,pieza.getJSONObject("valoresEspeciales").getString("resolucion"), 
                                                    pieza.getJSONObject("valoresEspeciales").getInt("tamanioGiga"),pieza.getString("rutaImagen"));
                }
                else if (tipo.equals("escultura")) 
                {
                    piezaParaAñadir = new Escultura(pieza.getString("titulo"),pieza.getString("loginPropietarioActual"), pieza.getInt("anioCreacion"), pieza.getString("lugarCreacion"),autores 
                                                , pieza.getBoolean("disponible"),pieza.getInt("tiempoConsignacion") , pieza.getBoolean("subasta"), valores,  pieza.getBoolean("bodega"),
                                                pieza.getString("tipo"),historialPropietarios, pieza.getJSONObject("valoresEspeciales").getInt("alto"), 
                                                pieza.getJSONObject("valoresEspeciales").getInt("ancho"),pieza.getJSONObject("valoresEspeciales").getInt("profundidad"), 
                                                pieza.getJSONObject("valoresEspeciales").getInt("peso"),pieza.getJSONObject("valoresEspeciales").getBoolean("electricidad"),pieza.getString("rutaImagen"));
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
                    usuarioParaAñadir = new Administrador(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), 
                                            usuario.getString("telefono"), usuario.getBoolean("verificado"));

                }
                else if (rol.equals("propietario"))
                {
                    JSONArray piezasActuales = usuario.getJSONObject("valores_especiales").getJSONArray("idPiezasActuales");
                    ArrayList <String> piezasActualesLista = new ArrayList<String>();

                    for (int a = 0; a < piezasActuales.length(); a++) 
                    {
                        piezasActualesLista.add(piezasActuales.getString(a));
                    }

                    JSONArray piezasHistorial = usuario.getJSONObject("valores_especiales").getJSONArray("historialPiezas");
                    ArrayList <String> piezasHistorialLista  = new ArrayList<String>();;

                    for (int a = 0; a < piezasHistorial.length(); a++) 
                    {
                        piezasHistorialLista.add(piezasHistorial.getString(a));
                    }

                    usuarioParaAñadir = new Propietario(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), 
                                            usuario.getString("telefono"),usuario.getBoolean("verificado"), piezasActualesLista, piezasHistorialLista);
                }
                else if (rol.equals("cajero")) 
                {

                    JSONArray compras = usuario.getJSONObject("valores_especiales").getJSONArray("comprasRegistradas");
                    ArrayList <Compra> comprasLista  = new ArrayList<Compra>();
                    
                    for (int a = 0; a < compras.length(); a++) 
                    {
                        JSONObject compra = compras.getJSONObject(i);
                        JSONObject metodoPago = compra.getJSONObject("metodoPago");
                        MetodoPago metodoPagoObjeto = null;
                        if (metodoPago.getString("nombre").equals("efectivo"))
                        {
                            metodoPagoObjeto = new Efectivo(metodoPago.getString("nombre"), metodoPago.getInt("monto"));

                        }
                        else if(metodoPago.getString("nombre").equals("tarjeta"))
                        {
                            metodoPagoObjeto = new Tarjeta(metodoPago.getString("nombre"), metodoPago.getInt("monto"), metodoPago.getString("loginComprador"), metodoPago.getInt("numero")
                                                                    , metodoPago.getInt("pin"), metodoPago.getInt("csv"));

                        }
                        else if(metodoPago.getString("nombre").equals("transferencia"))
                        {
                            metodoPagoObjeto = new Transferencia(metodoPago.getString("nombre"), metodoPago.getInt("monto"), metodoPago.getString("tipo"), metodoPago.getString("id"));

                        }
                        Compra compraObjeto = new Compra(compra.getString("compradorLogin"), compra.getInt("precio"), compra.getString("nombrePieza"), metodoPagoObjeto, compra.getString("fecha"));
                        comprasLista.add(compraObjeto);
                    }

                    usuarioParaAñadir = new Cajero(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), 
                                            usuario.getString("telefono"),usuario.getBoolean("verificado"), comprasLista);

                }
                else if (rol.equals("comprador")) 
                {
                    JSONArray comprasJson = usuario.getJSONObject("valores_especiales").getJSONArray("historialCompras");
                    JSONArray mensajesJson = usuario.getJSONObject("valores_especiales").getJSONArray("mensajesSubasta");
                    JSONArray idPiezasJson = usuario.getJSONObject("valores_especiales").getJSONArray("idPiezasCompradas");
                    ArrayList<Compra> compras  = new ArrayList<Compra>();
                    ArrayList<Mensaje> mensajes  = new ArrayList<Mensaje>();
                    ArrayList<String> idPiezas  = new ArrayList<String>();
                    for (int a = 0; a < comprasJson.length(); a++) 
                    {
                        
                        JSONObject compra = comprasJson.getJSONObject(a);
                        JSONObject metodoPago = compra.getJSONObject("metodoPago");
                        MetodoPago metodoPagoObjeto= null;
                        if (metodoPago.getString("nombre").equals("efectivo"))
                        {
                            metodoPagoObjeto = new Efectivo(metodoPago.getString("nombre"), metodoPago.getInt("monto"));

                        }
                        else if(metodoPago.getString("nombre").equals("tarjeta"))
                        {
                            metodoPagoObjeto = new Tarjeta(metodoPago.getString("nombre"), metodoPago.getInt("monto"), metodoPago.getString("loginComprador"), metodoPago.getInt("numero")
                                                                    , metodoPago.getInt("pin"), metodoPago.getInt("csv"));

                        }
                        else if(metodoPago.getString("nombre").equals("transferencia"))
                        {
                            metodoPagoObjeto = new Transferencia(metodoPago.getString("nombre"), metodoPago.getInt("monto"), metodoPago.getString("tipo"), metodoPago.getString("id"));

                        }
                        Compra compraObjeto = new Compra(compra.getString("compradorLogin"), compra.getInt("precio"), compra.getString("nombrePieza"), metodoPagoObjeto, compra.getString("fecha"));
                        compras.add(compraObjeto);
                    }

                    for (int a = 0; a < mensajesJson.length(); a++) 
                    {
                        JSONObject mensaje = mensajesJson.getJSONObject(a);
                        Mensaje mensajeObjeto =  new Mensaje(mensaje.getString("nombrePieza"), mensaje.getBoolean("vendida"), mensaje.getString("mensaje"));
                        mensajes.add(mensajeObjeto);
                    }
                    for (int a = 0; a < idPiezasJson.length(); a++) 
                    {
                        idPiezas.add(idPiezasJson.getString(a));
                    }


                    usuarioParaAñadir = new Comprador(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), 
                                            usuario.getString("telefono"),usuario.getBoolean("verificado"), usuario.getJSONObject("valores_especiales").getFloat("estadoCuenta"), 
                                            compras, usuario.getJSONObject("valores_especiales").getFloat("maxCompras"),usuario.getJSONObject("valores_especiales").getBoolean("mora"), mensajes, idPiezas);

                }
                else if (rol.equals("operador")) 
                {
                    usuarioParaAñadir = new Operador(usuario.getString("login"), usuario.getString("nombre"), usuario.getString("password"), usuario.getString("rol"), 
                                            usuario.getString("telefono"),usuario.getBoolean("verificado"), new ArrayList<String>());
                    
                }
                    
                usuariosObjeto.add(usuarioParaAñadir);
            }

            Map<String, ArrayList<String>> autoresMapa = new HashMap<String,ArrayList<String>>();

            for (int i = 0; i < autoresArray.length(); i++) 
            {
                JSONObject autor = autoresArray.getJSONObject(i);
                ArrayList<String> listaPiezas = new ArrayList<String>();
            
                for (int a = 0; a < autor.getJSONArray("piezas").length(); a++) 
                {
                    listaPiezas.add(autor.getJSONArray("piezas").getString(a));
                }

                autoresMapa.put(autor.getString("nombre"), listaPiezas);
            }


            ArrayList<Subasta> subastasObjeto = new ArrayList<Subasta>();

            for (int i = 0 ; i<subastasArray.length(); i++)
            {
                JSONObject subasta = subastasArray.getJSONObject(i);
                ArrayList<String> listaPiezas = new ArrayList<String>();
                for (int a = 0; a < subasta.getJSONArray("idListaPiezasSubasta").length(); a++) 
                {
                    listaPiezas.add(subasta.getJSONArray("idListaPiezasSubasta").getString(a));
                }
                ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
                for (int a = 0; a < subasta.getJSONArray("listaOfertas").length(); a++) 
                {
                   JSONObject ofertaJson = subasta.getJSONArray("listaOfertas").getJSONObject(a);
                    
                    Oferta oferta = new Oferta(ofertaJson.getString("compradorLogin"), ofertaJson.getInt("valorOfertado"), ofertaJson.getString("metodoPago"), 
                                    ofertaJson.getString("nombrepiezaSubastada"), ofertaJson.getString("fecha"));

                   listaOfertas.add(oferta);
                }
                String id = subasta.getString("id");

                Subasta subastaObjeto = new Subasta(id, listaOfertas, listaPiezas);
                subastasObjeto.add(subastaObjeto);
            }



            int totalObras = piezasBodegaObjeto.size() + piezasExhibidasObjeto.size();

            Inventario inventario = new Inventario(piezasBodegaObjeto,piezasExhibidasObjeto);

            ArrayList<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();

            for (int i = 0 ; i<tarjetasArray.length(); i++)
            {
                JSONObject tarjeta = tarjetasArray.getJSONObject(i);
                Tarjeta tarjetaNueva = new Tarjeta(tarjeta.getString("nombre"), tarjeta.getInt("monto"), tarjeta.getString("loginComprador"), tarjeta.getInt("numero"), 
                tarjeta.getInt("pin"), tarjeta.getInt("csv"));
                listaTarjetas.add(tarjetaNueva);

            }
            
            ArrayList<Transferencia> listaTransferencias = new ArrayList<Transferencia>();

            for (int i = 0 ; i<transferenciasArray.length(); i++)
            {
                JSONObject transferencia = transferenciasArray.getJSONObject(i);
                Transferencia nuevaTransferencia = new Transferencia(transferencia.getString("nombre"), transferencia.getInt("monto"), transferencia.getString("tipo"), transferencia.getString("id"));
                listaTransferencias.add(nuevaTransferencia);
            }


            galeriaRetornada = new Galeria("GaleriaDakol", totalObras,inventario , usuariosObjeto, subastasObjeto,autoresMapa,listaTarjetas,listaTransferencias) ;

            
            
        }
        catch (FileNotFoundException e) 
        {
            
                e.printStackTrace();
        }

        return galeriaRetornada;
        
    }
    
}
