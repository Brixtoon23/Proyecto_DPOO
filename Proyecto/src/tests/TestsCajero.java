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
    public void testRegistrarCompra()
    {
        Comprador cliente = Servicios.buscarComprador(galeriaPrueba,"briceno_comprador");
        int tamanioHistorialCompras = cliente.getHistorialCompras().size();
        double estadoCuentaInicial = cliente.getEstadoCuenta();
        Pieza pieza = Servicios.buscarPiezaSubasta(galeriaPrueba, "El rayo mquen");
        Propietario antiguoPropietario = Servicios.buscarPropietario(galeriaPrueba, "bri_propietario");
        int piezasAntiguoPropietario = antiguoPropietario.getIdPiezasActuales().size();

        Cajero.registrarCompraPrecioFijo(cliente,pieza,"PagoX",galeriaPrueba,"20/20/10");

        //Se verifica que la pieza se haya retirado de la lista de piezas del propietario
        antiguoPropietario = Servicios.buscarPropietario(galeriaPrueba, "bri_propietario");
        assertEquals(piezasAntiguoPropietario,((antiguoPropietario.getIdPiezasActuales().size())-1),"La pieza no fue retirada de la lista del propietario anterior");

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
    }

}
