package tests;

import Logica.Galeria;
import Logica.Oferta;
import Logica.Operador;
import Logica.Subasta;
import Persistencia.InicializadorDeClases;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class TestsOperador {
    

   

    @Test
    public void testRegistrarOferta() {
        // Datos de prueba
        Galeria galeria=InicializadorDeClases.cargarGaleria();
        ArrayList<Subasta> subastas= galeria.getSubastas();

     
        int valorOfertado = 300000000;
        String metodoPago = "efectivo";
        String nombrePieza = "Order 66";
        String fecha = "12/03/2024";

        // Crear una nueva oferta
        Oferta oferta = new Oferta("gladys_comprador", valorOfertado, metodoPago, nombrePieza, fecha);

        // Registrar la oferta
        Operador.registrarOferta(oferta, subastas, galeria, fecha);

        // Obtener la subasta correspondiente
        Subasta subasta = galeria.getSubastas().getFirst();

        // Verificar que la oferta fue registrada correctamente
        Oferta ofertaRegistrada = subasta.getListaOfertas().getLast();

        // Comparar la oferta registrada con la oferta esperada
        assertEquals(oferta, ofertaRegistrada);

        // Verificar que el tamaño de la lista de ofertas es 1
        assertEquals(1, subasta.getListaOfertas().size());

        // Adicional: verificar que la oferta en la subasta es correcta
        assertTrue(subasta.getListaOfertas().contains(oferta));






        int valorOfertado1 = 400000000;
        String metodoPago1 = "efectivo";
        String nombrePieza1 =  "La monalisa";
        String fecha1 = "15/03/2024";

        Oferta oferta1 = new Oferta( "gabriela_comprador", valorOfertado1, metodoPago1, nombrePieza1, fecha1);

        // Registrar la oferta
        Operador.registrarOferta(oferta1, subastas, galeria, fecha1);

        // Obtener la subasta correspondiente
        Subasta subasta1 = galeria.getSubastas().getLast();

        // Verificar que la oferta fue registrada correctamente
       

        // Verificar que el tamaño de la lista de ofertas es 1
        assertEquals(0 , subasta1.getListaOfertas().size());

      
    }

   
    






  






   

    }
    
    



