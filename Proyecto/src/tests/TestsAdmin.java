package tests;
import org.junit.Test;

import Logica.Administrador;
import Logica.Comprador;
import Logica.Galeria;
import Logica.Mensaje;
import Logica.Oferta;
import Logica.Pieza;
import Logica.Servicios;
import Logica.Subasta;
import Persistencia.InicializadorDeClases;
import Logica.Compra;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Logica.Galeria;
import Logica.Inventario;
import Persistencia.InicializadorDeClases;
import Logica.Comprador;
import Logica.Administrador;
import Logica.Pieza;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Pintura;
import Logica.Servicios;
import Logica.Video;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestsAdmin 
{
    private ArrayList<String> Autores_uno;
    private Escultura EsculturaPrueba;
    private ArrayList<String> Autores_dos;
    private Video VideoPrueba;
    private Fotografia Photo;
    private Pintura PinturaPrueba;
    private ArrayList<Integer> Valores_uno;
    private ArrayList<Integer> Valores_dos;
    private ArrayList<Map<String,Object>> historial1;
    private ArrayList<Map<String,Object>> historial2;
    private static Galeria GaleriaPrueba = InicializadorDeClases.cargarGaleria();


    @BeforeEach
    public void setUp() throws Exception
    {


        Autores_uno = new ArrayList<String>();
        Autores_uno.add("Autor1");
        Autores_dos = new ArrayList<String>();
        Autores_dos.add("Autor1");
        Autores_dos.add("pixar");
        Valores_uno = new ArrayList<Integer>();
        Valores_uno.add(120000);
        Valores_dos = new ArrayList<Integer>();
        Valores_dos.add(0);
        Map<String,Object> propietario1 = new HashMap<String,Object>();
        propietario1.put("loginPropietario","loginX");
        propietario1.put("valorCompra",120000);
        propietario1.put("fecha","02/20/18");
        historial1.add(propietario1);
        Map<String,Object> propietario2 = new HashMap<String,Object>();
        propietario2.put("loginPropietario","loginY");
        propietario2.put("valorCompra",340000);
        propietario2.put("fecha","01/30/20");
        historial2.add(propietario1);
        historial2.add(propietario2);

        EsculturaPrueba = new Escultura("El pensador", "Me", 1990, "somewhere", Autores_dos, true, -1, false, Valores_uno, true, "escultura", historial1, 1, 10, 12, 56, false);
        VideoPrueba = new Video("Order 66", "Canc1ll3r_Palpatine", 2020, "In a galaxy far, far away", Autores_uno, false, 20, true, Valores_dos, false, "video", historial2, 20, 1, "720");
        Photo = new Fotografia("Random photo", "Me_again", 2023, "who knows", Autores_uno, false, 32, true, Valores_dos, false, "video", historial1, "None", 28);
        PinturaPrueba = new Pintura("Una pintura", "alguien", 1020, "???", Autores_dos, true, -1, false, Valores_uno, true, "pintura", historial2, 3, 3, 14, "creatividad");

    }

    @Test
    public void testIngresarPieza()
    {
        VideoPrueba = new Video("Order 66", "Canc1ll3r_Palpatine", 2020, "In a galaxy far, far away", Autores_uno, false, 20, true, Valores_dos, false, "video", historial2, 20, 1, "720");
        int bodega_inicial = GaleriaPrueba.getInventario().getPiezasBodega().size();
        int exhibicion_inicial = GaleriaPrueba.getInventario().getPiezasExhibidad().size();
        assertEquals((bodega_inicial+exhibicion_inicial),GaleriaPrueba.getCantidadObras(), "La cantidad incial de obras no es correcta");
        Administrador.ingresarPieza(GaleriaPrueba,VideoPrueba);  //Se ingresa una pieza a exhibicion
        assertEquals((exhibicion_inicial+bodega_inicial+1),GaleriaPrueba.getCantidadObras(),"La pieza no se agregó a la galería");
        assertEquals((exhibicion_inicial+1),GaleriaPrueba.getInventario().getPiezasExhibidad().size(), "La pieza no se agregó a la lista correcta en la galería");
        Pieza piezaAgregada = GaleriaPrueba.getInventario().getPiezasExhibidad().get(-1);
        //Se verifica que la pieza que se agregó sea la correcta
        assertEquals(VideoPrueba.getTitulo(),piezaAgregada.getTitulo(),"La pieza no se agregó correctamente, el título no es correcto");
        assertEquals(VideoPrueba.getLoginPropietarioActual(), piezaAgregada.getLoginPropietarioActual(),"La pieza no se agregó correctamente, el propietario actual no es correcto");
        assertEquals(VideoPrueba.getAutor().size(),piezaAgregada.getAutor().size(),"La pieza no se agregó correctamente, los autores no son los correctos");
        assertEquals(VideoPrueba.getTipo(),piezaAgregada.getTipo(), "La pieza no se agregó correctamente, el tipo de pieza es incorrecto");

        exhibicion_inicial = GaleriaPrueba.getInventario().getPiezasExhibidad().size(); //Se actualiza la cantidad en bodega inicial para la siguiente prueba
        
        //Ahora se hace una prueba para el ingreso de un pieza a bodega
        Administrador.ingresarPieza(GaleriaPrueba,PinturaPrueba);
        assertEquals((exhibicion_inicial+bodega_inicial+1),GaleriaPrueba.getCantidadObras(),"La pieza no se agregó a la galería");
        assertEquals((bodega_inicial+1),GaleriaPrueba.getInventario().getPiezasBodega().size(), "La pieza no se agregó a la lista correcta en la galería");
        //Se verifica que la pieza agregada es correcta
        piezaAgregada = GaleriaPrueba.getInventario().getPiezasBodega().get(-1);
        assertEquals(PinturaPrueba.getTitulo(),piezaAgregada.getTitulo(),"La pieza no se agregó correctamente, el título no es correcto");
        assertEquals(PinturaPrueba.getLoginPropietarioActual(), piezaAgregada.getLoginPropietarioActual(),"La pieza no se agregó correctamente, el propietario actual no es correcto");
        assertEquals(PinturaPrueba.getAutor().size(),piezaAgregada.getAutor().size(),"La pieza no se agregó correctamente, los autores no son los correctos");
        assertEquals(PinturaPrueba.getTipo(),piezaAgregada.getTipo(), "La pieza no se agregó correctamente, el tipo de pieza es incorrecto");
    }

    @Test
    public void testAprobarVentaPrecioFijo()
    {
        Comprador conSuficienteDinero = Servicios.buscarComprador(GaleriaPrueba, "briceno_comprador");
        Comprador sinSuficienteDinero = Servicios.buscarComprador(GaleriaPrueba, "Sin_Plata_comprador");
        Pieza pieza = Servicios.buscarPieza(GaleriaPrueba, "El rayo mquen");
        //Se veirifica que el administrador autorice la compra para un comprador con monto suficiente y que no lo autorice para uno sin suficiente dinero
        boolean respuesta1 = Administrador.aprobarVentaPrecioFijo(conSuficienteDinero,pieza,"X",GaleriaPrueba,"10/26/10");
        boolean respuesta2 = Administrador.aprobarVentaPrecioFijo(sinSuficienteDinero,pieza,"X",GaleriaPrueba,"10/26/10");
        assertEquals(true, respuesta1,"No se aprobó la venta para un comprador con el suficiente dinero");
        assertEquals(false,respuesta2,"Se aprobó la venta para un cliente que no tiene suficiente dinero");
    }

    @Test
    public void testVerificarComprador()
    {
        Comprador compradorTest1 = new Comprador("X","Someone","XX","comprador","12345",false,200000,null,0,false,null,null);
        Comprador compradorTest2 = new Comprador("Y","Someonelse","YY","comprador","54321",false,200000,null,0,true,null,null);
        Administrador.verificarComprador(compradorTest1);
        Administrador.verificarComprador(compradorTest2);
        //Se prueba si compradorTest1 fue verificado como true y compradorTest2 fue verificado como false (comprador2 está en mora)
        assertEquals(true,compradorTest1.isVerificado(),"El comprador no fue verificado correctamente");
        assertEquals(false,compradorTest2.isVerificado(),"El comprador no fue verificado correctamente");
        
    }

    @Test
    public void testIngresarAutor()
     
    {
        Galeria galeria = InicializadorDeClases.cargarGaleria();

        Pieza pieza= Servicios.buscarPieza(galeria, "Caminos Entrelazados");
        int listaAntes= galeria.getAutores().size();

        Administrador.ingresarAutor(galeria, pieza.getAutor(), "Caminos Entrelazados");
        //Se verifica que se haya ingresado el nuevo autor
        assertEquals(listaAntes+3 , galeria.getAutores().size(),"No se añadió el nuevo autor");
        //Se verifica que a pixar se le haya añadido la pieza
       
        

    }    
    

    @Test
    public void testCrearSusbasta() 
    {
      Galeria galeria = InicializadorDeClases.cargarGaleria();
      String idSubasta="subasta prueba";
       ArrayList<String> piezas = new ArrayList<>();
       piezas.add("Las meninas");
       piezas.add("La monalisa");

        Administrador.crearSusbasta(galeria, idSubasta, piezas);

        assertEquals(galeria.getSubastas().size(), 3);
        Subasta subastaCreada = galeria.getSubastas().get(2);
        assertEquals(subastaCreada.getId(), idSubasta);
        assertEquals(subastaCreada.getIdListaPiezasSubasta(), piezas);

    }

    @Test
     public void testMontoColeccion() 
     {
        
        Galeria galeria = InicializadorDeClases.cargarGaleria();
        
        
        String loginComprador = "alejandra_comprador";

        int monto= Administrador.montoColeccion(galeria, loginComprador);

        assertEquals(6000000, monto);
     }



     @Test
     public void testAprobarVentaSubasta()
     
     {
        Galeria galeria = InicializadorDeClases.cargarGaleria();
        String metodoPago= "trasferencia";
        String fecha= "12/05/2024";
        Oferta oferta= new Oferta("sara_comprador", 4123456 , metodoPago,   "La monalisa" , fecha);
        boolean aprobado= Administrador.aprobarVentaSubasta(oferta, galeria, fecha);
        assertEquals(true, aprobado);

     }

     @Test
     public void testIngresarUsuario()
    {
        Galeria galeria = InicializadorDeClases.cargarGaleria();
        ArrayList<Compra> listacompras= new ArrayList<>();
        ArrayList<Mensaje> mensajesSubasta= new ArrayList<>();
        ArrayList<String> listaIdPiezasCompradas= new ArrayList<>();
        Comprador comprador= new Comprador("gladys_comprador", "gladys", "gladys", "comprador", "12387544", true, 1233948383, listacompras, 234566544, false, mensajesSubasta, listaIdPiezasCompradas);
        Administrador.ingresarUsuario(comprador, galeria);
        Comprador compradorgaleria= Servicios.buscarComprador(galeria, "gladys_comprador");

        assertEquals(compradorgaleria,comprador);


    }







    
}