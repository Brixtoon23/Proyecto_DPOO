package tests;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Logica.Galeria;
import Logica.Inventario;
import Persistencia.InicializadorDeClases;
import Logica.Administrador;
import Logica.Pieza;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Pintura;
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


    @BeforeAll
    public void setUp() throws Exception
    {


        Autores_uno = new ArrayList<String>();
        Autores_uno.add("Autor1");
        Autores_dos = new ArrayList<String>();
        Autores_dos.add("Autor1");
        Autores_dos.add("Autor2");
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
        int bodega_inicial = GaleriaPrueba.getInventario().getPiezasBodega().size();
        int exhibicion_inicial = GaleriaPrueba.getInventario().getPiezasExhibidad().size();
        assertEquals((bodega_inicial+exhibicion_inicial),GaleriaPrueba.getCantidadObras(), "La cantidad incial de obras no es correcta");
        Administrador.ingresarPieza(GaleriaPrueba,VideoPrueba); //Se ingresa una pieza a exhibicion
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
}
