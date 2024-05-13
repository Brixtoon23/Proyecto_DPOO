package tests;
import org.junit.Test;

import Logica.Administrador;
import Logica.Comprador;
import Logica.Galeria;
import Logica.Oferta;
import Logica.Pieza;
import Logica.Servicios;
import Logica.Subasta;
import Persistencia.InicializadorDeClases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestsAdmin {
    
    

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
        
        
        String loginComprador = "nikol_propietario";

        int monto= Administrador.montoColeccion(galeria, loginComprador);

        assertEquals(0.0f, monto, 0.01f);
     }



     @Test
     public void testAprobarVentaSubasta()
     
     {
        Galeria galeria = InicializadorDeClases.cargarGaleria();
        String metodoPago= "trasferencia";
        String fecha= "12/05/2024";
        Oferta oferta= new Oferta("sara_comprador", 30000000 , metodoPago,  "La monalisa" , fecha);
        boolean aprobado= Administrador.aprobarVentaSubasta(oferta, galeria, fecha);
        assertEquals(true, aprobado);

     }

    
}