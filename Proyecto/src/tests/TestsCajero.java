package tests;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Logica.Galeria;
import Logica.Inventario;
import Logica.Oferta;
import Persistencia.InicializadorDeClases;
import Logica.Administrador;
import Logica.Cajero;
import Logica.Comprador;
import Logica.Propietario;
import Logica.Compra;
import Logica.Pieza;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Pintura;
import Logica.Servicios;
import Logica.Video;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TestsCajero 
{
    private Galeria galeriaPrueba = InicializadorDeClases.cargarGaleria();

    @Test
    public void testRegistrarCompraPrecioFijo()
    {
        Comprador cliente = Servicios.buscarComprador(galeriaPrueba,"briceno_comprador");
        int tamanioHistorialCompras = cliente.getHistorialCompras().size();
        double estadoCuentaInicial = cliente.getEstadoCuenta();
        Pieza pieza = Servicios.buscarPieza(galeriaPrueba, "La Ultima Cena");
        int tamanioHistorialPieza= pieza.getHistorialPropietarios().size();

        Propietario antiguoPropietario = Servicios.buscarPropietario(galeriaPrueba, "gabriela_propietario");
      

        Cajero.registrarCompraPrecioFijo(cliente,pieza,"Transferencia",galeriaPrueba,"20/20/10");
        int piezasAntiguoPropietario= antiguoPropietario.getIdPiezasActuales().size();
        //Se verifica que la pieza se haya retirado de la lista de piezas del propietario
        antiguoPropietario = Servicios.buscarPropietario(galeriaPrueba, "gabriela_propietario");
        assertEquals(piezasAntiguoPropietario,((antiguoPropietario.getIdPiezasActuales().size())),"La pieza no fue retirada de la lista del propietario anterior");

        //Se verifica que la compra se haya añadido al historial del comprador
        cliente = Servicios.buscarComprador(galeriaPrueba,"briceno_comprador");
        assertEquals(cliente.getHistorialCompras().size(),tamanioHistorialCompras+1,"La compra no se añadío al historial del comprador");
        //Se verifica que la compra haya sido añadida correctamente
        Compra compra = cliente.getHistorialCompras().getLast();
        assertEquals(compra.getNombrepieza(),pieza.getTitulo(),"La pieza que aparece en la compra no corresponde con la pieza que se vendió");
        assertEquals(compra.getCompradorLogin(),cliente.getLogin(),"El login del comprador de la pieza no corresponde con quien la compró");
        //Se verifica que el estado de cuenta del comprador haya cambiado
        assertEquals(true,estadoCuentaInicial>cliente.getEstadoCuenta(),"El estado de cuenta del comprador no se cambió");
        // Se verifica que la pieza haya sido añadida al historial del comprador
        assertEquals(pieza.getTitulo(),cliente.getIdpiezasCompradas().getLast(),"La pieza no fue añadida al historial de piezas compradas");
        //Se verifica que la pieza haya sido añadida a la lista de piezasActuales al perfil de propietario del comprador
        Propietario propietarioActual = Servicios.buscarPropietario(galeriaPrueba, "briceno_propietario");
        assertEquals(pieza.getTitulo(),propietarioActual.getIdPiezasActuales().getLast(),"La pieza no fue agregada al perfil de propiertario del comprador");
        //Se verifica que el historial de propietarios de la pieza se haya actualizado
        pieza = Servicios.buscarPieza(galeriaPrueba, "La Ultima Cena");
        assertEquals(tamanioHistorialPieza+1,pieza.getHistorialPropietarios().size(),"El historial de propietarios de la pieza no se actualizó");
    }
        

    @Test
    public void testRegistrarCompraSubasta()
    {
        Oferta oferta = new Oferta("briceno_comprador",1234567,"Credit Card","La ","01/01/01");
        Comprador cliente = Servicios.buscarComprador(galeriaPrueba,"briceno_comprador");
        int tamanioHistorialCompras = cliente.getHistorialCompras().size();
        double estadoCuentaInicial = cliente.getEstadoCuenta();
        Pieza pieza = Servicios.buscarPieza(galeriaPrueba, "La Venus de Milo");
        int tamanioHistorialPieza = pieza.getHistorialPropietarios().size();
        Propietario antiguoPropietario = Servicios.buscarPropietario(galeriaPrueba, "gabriela_propietario");
        int piezasAntiguoPropietario = antiguoPropietario.getIdPiezasActuales().size();
        int cantMensajesCliente = cliente.getMensajesSubasta().size();

        Cajero.registrarCompraSubasta(oferta,cliente,galeriaPrueba,"10/10/10");

        //Se verifica que la pieza se haya retirado de la lista de piezas del propietario
        antiguoPropietario = Servicios.buscarPropietario(galeriaPrueba, "gabriela_propietario");
        assertEquals(piezasAntiguoPropietario,((antiguoPropietario.getIdPiezasActuales().size())),"La pieza no fue retirada de la lista del propietario anterior");

        //Se verifica que la compra se haya añadido al historial del comprador
        cliente = Servicios.buscarComprador(galeriaPrueba,"briceno_comprador");
        assertEquals(cliente.getHistorialCompras().size(),tamanioHistorialCompras+1,"La compra no se añadío al historial del comprador");
        //Se verifica que la compra haya sido añadida correctamente
        Compra compra = cliente.getHistorialCompras().getLast();
        assertEquals(compra.getNombrepieza(),pieza.getTitulo(),"La pieza que aparece en la compra no corresponde con la pieza que se vendió");
        assertEquals((compra.getCompradorLogin()),(cliente.getLogin()),"El login del comprador de la pieza no corresponde con quien la compró");
        //Se verifica que el estado de cuenta del comprador haya cambiado
        assertEquals(true,estadoCuentaInicial>cliente.getEstadoCuenta(),"El estado de cuenta del comprador no se cambió");
        // Se verifica que la pieza haya sido añadida al historial del comprador
        assertEquals(pieza.getTitulo(),cliente.getIdpiezasCompradas().getLast(),"La pieza no fue añadida al historial de piezas compradas");
        //Se verifica que la pieza haya sido añadida a la lista de piezasActuales al perfil de propietario del comprador
        Propietario propietarioActual = Servicios.buscarPropietario(galeriaPrueba, "briceno_propietario");
        assertEquals(pieza.getTitulo(),propietarioActual.getIdPiezasActuales().getLast(),"La pieza no fue agregada al perfil de propiertario del comprador");
        //Se verifica que el historial de propietarios de la pieza se haya actualizado
        pieza = Servicios.buscarPieza(galeriaPrueba,"La Venus de Milo");
        assertEquals(tamanioHistorialPieza+1,pieza.getHistorialPropietarios().size(),"El historial de propietarios de la pieza no se actualizó");
        //Se verifica si el comprador recibió el mensaje tras ganar la subasta
        assertEquals(cantMensajesCliente+1,cliente.getMensajesSubasta().size(),"No se le envió un mensaje al comprador después de haber acabado la subasta");

    }

}
