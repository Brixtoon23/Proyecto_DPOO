package tests;

import Logica.Galeria;
import Logica.Oferta;
import Logica.Operador;
import Logica.Subasta;
import Persistencia.InicializadorDeClases;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestsOperador {

    @Test
    public void testRegistrarOferta() {


      
        Galeria galeria = InicializadorDeClases.cargarGaleria();
        String compradorLogin= "Daniel_comprador";
        int valorOfertado= 300000000;
        String metodoPago="efectivo";
        String nombrePieza=  "La monalisa";
        String fecha= "12/03/2024";

        Oferta oferta= new Oferta(compradorLogin, valorOfertado, metodoPago, nombrePieza, fecha);

        ArrayList<Subasta> subastas= galeria.getSubastas();

        Operador.registrarOferta(oferta, subastas, galeria, fecha);

        Subasta subasta= galeria.getSubastas().get(2);
        
        Oferta oferta1= subasta.getListaOfertas().get(0);
        assertEquals(oferta1, oferta1);
        assertEquals(subasta.getListaOfertas().size(), 1);





    }
   


    



    
    
   
    
    
            
   

    }
    
    



