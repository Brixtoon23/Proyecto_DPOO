package tests;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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
import Logica.Servicios;
import Logica.Video;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestServicios 
{
    private Galeria galeriaPrueba = InicializadorDeClases.cargarGaleria();
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

    @BeforeEach
    public void setUp()
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

        EsculturaPrueba = new Escultura("El pensador", "Me", 1990, "somewhere", Autores_dos, true, -1, false, Valores_uno, true, "escultura", historial1, 1, 10, 12, 56, false,null);
        VideoPrueba = new Video("Order 66", "Canc1ll3r_Palpatine", 2020, "In a galaxy far, far away", Autores_uno, false, 20, true, Valores_dos, false, "video", historial2, 20, 1, "720",null);
        Photo = new Fotografia("Random photo", "Me_again", 2023, "who knows", Autores_uno, false, 32, true, Valores_dos, false, "video", historial1, "None", 28,null);
        PinturaPrueba = new Pintura("Una pintura", "alguien", 1020, "???", Autores_dos, true, -1, false, Valores_uno, true, "pintura", historial2, 3, 3, 14, "creatividad",null);



    }

    @Test
    public void TestBuscarPieza()
    {
        //Se prueba si el método encuentra una pieza que sí esta en la galería
        assertEquals("El David",Servicios.buscarPieza(galeriaPrueba,"El David").getTitulo(),"La pieza encontrada no es la correcta");
        //Se prueba si el método retorna null cuando se le pasa una pieza que no está en la galería
        assertEquals(null,Servicios.buscarPieza(galeriaPrueba,"Algo"),"Se encontró una pieza que no pertence a la galería");
    }

    @Test
    public void TestBuscarComprador()
    {
        //Se prueba que el método puede encontrar a un comprador que sí esté en la galería
        assertEquals("briceno_comprador",Servicios.buscarComprador(galeriaPrueba, "briceno_comprador").getLogin(),"No se encontró al usuario correctamente");
        //Se prueba que el método no encuentre a un comprador que no esté registrado en la galería
        assertEquals(null,Servicios.buscarComprador(galeriaPrueba, "X"),"Se encontró a un comprador que no está registrado en la galería");
    }

    @Test
    public void TestBuscarPropietario()
    {
        //Se prueba que el método puede encontrar a un propietario que sí esté en la galería
        assertEquals("briceno_propietario",Servicios.buscarPropietario(galeriaPrueba, "briceno_propietario").getLogin(),"No se encontró al usuario correctamente");
        //Se prueba que el método no encuentre a un comprador que no esté registrado en la galería
        assertEquals(null,Servicios.buscarComprador(galeriaPrueba, "X"),"Se encontró a un propietario que no está registrado en la galería");
    }

}
