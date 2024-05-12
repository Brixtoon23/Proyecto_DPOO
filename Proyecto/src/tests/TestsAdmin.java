package tests;
import org.junit.Test;

import Logica.Administrador;
import Logica.Galeria;
import Logica.Subasta;
import Persistencia.InicializadorDeClases;

import static org.junit.Assert.*;

import java.util.ArrayList;

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

        assertEquals(galeria.getSubastas().size(), 2);
        Subasta subastaCreada = galeria.getSubastas().get(1);
        assertEquals(subastaCreada.getId(), idSubasta);
        assertEquals(subastaCreada.getIdListaPiezasSubasta(), piezas);

    }


    

}


