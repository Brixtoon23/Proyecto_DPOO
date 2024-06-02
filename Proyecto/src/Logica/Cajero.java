package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Persistencia.PiezasPersistencia;
import Persistencia.UsuarioPersistencia;

public class Cajero  extends Usuario
{
	private ArrayList<Compra> comprasRegistradas;

	
	
	public Cajero(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			ArrayList<Compra> comprasResgistradas) 
	{
		super(login, nombre, password, rol, telefono, verificado);
		this.comprasRegistradas = comprasResgistradas;
	}



	public static void registrarCompraSubasta(Oferta oferta, Comprador comprador, Galeria galeria, String fecha)

	{

		String nombrePieza =  oferta.getNombrepiezaSubastada();
		Pieza pieza = Servicios.buscarPieza(galeria, nombrePieza);
		float cuenta= comprador.getEstadoCuenta() - oferta.getValorOfertado();
		comprador.setEstadoCuenta(cuenta);


		pieza.setDisponible(false);
		Propietario propietarioAnterior = Servicios.buscarPropietario(galeria, pieza.getLoginPropietarioActual());
		propietarioAnterior.getIdPiezasActuales().remove(pieza.getTitulo());


		String loginNuevoPropiertario= comprador.login.replace("_comprador", "_propietario");
		Propietario nuevoPropiertario = Servicios.buscarPropietario(galeria, loginNuevoPropiertario);

		Map<String, Object> mapa = new HashMap<>();

		mapa.put( "loginPropietario",loginNuevoPropiertario);
		mapa.put("valorCompra", oferta.getValorOfertado());
		mapa.put("fechaVenta", fecha);

		pieza.getHistorialPropietarios().add(mapa);

		Compra compra= new Compra(comprador.getLogin(), oferta.getValorOfertado(), nombrePieza, nombrePieza, fecha);
		
		
		comprador.getHistorialCompras().add(compra);
		comprador.getIdpiezasCompradas().add(pieza.getTitulo());
		nuevoPropiertario.getIdPiezasActuales().add(pieza.getTitulo());

		String mensaje1="La pieza con el titulo "+ pieza.getTitulo()+ " " + "fue vendida exitosamente";
		Mensaje mensaje = new Mensaje(pieza.getTitulo(), true, mensaje1);

		comprador.getMensajesSubasta().add(mensaje);

		PiezasPersistencia.actualizarPropietarioPieza(galeria,pieza);
		UsuarioPersistencia.actualizarCompradorCompra( comprador );
		UsuarioPersistencia.actualizarPropietarioCompra(propietarioAnterior,nuevoPropiertario);


		
	}




	
	public static void registrarCompraPrecioFijo(Comprador comprador,Pieza pieza, String metodoPago,Galeria galeria, String fecha) 
	{
		if (metodoPago.equals("efectivo"))
		{
		float cuenta = comprador.getEstadoCuenta();
		ArrayList<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		cuenta -= precioFijo;
		comprador.setEstadoCuenta(cuenta);

		pieza.setDisponible(false);
		
		String propietarioAnteriorLogin = pieza.getLoginPropietarioActual();
		Propietario propietarioAnterior= Servicios.buscarPropietario(galeria, propietarioAnteriorLogin);
		ArrayList<String> piezasPropietarioAnterior = propietarioAnterior.getIdPiezasActuales();

		piezasPropietarioAnterior.remove(pieza.getTitulo());
		propietarioAnterior.setIdPiezasActuales(piezasPropietarioAnterior);

		
		ArrayList<Compra> historialCompra = comprador.getHistorialCompras();

		Compra compraNueva = new Compra(comprador.getLogin(), precioFijo , pieza.getTitulo() , metodoPago, fecha);

		historialCompra.add(compraNueva);

		comprador.setHistorialCompras(historialCompra);
		
		
		ArrayList<String> piezas =  comprador.getIdpiezasCompradas();
		piezas.add(pieza.getTitulo());
		comprador.setIdpiezasCompradas(piezas);
		
		
		String loginnuevoPropiertario= comprador.login.replace("_comprador", "_propietario");
		Propietario nuevoPropiertario= Servicios.buscarPropietario(galeria, loginnuevoPropiertario);

		ArrayList<String> nuevoHistorial = nuevoPropiertario.getHistorialPiezas();
		nuevoHistorial.add(pieza.getTitulo());
		nuevoPropiertario.setHistorialPiezas(nuevoHistorial);

		ArrayList<String> nuevasIdPiezas = nuevoPropiertario.getIdPiezasActuales();
		nuevasIdPiezas.add(pieza.getTitulo());
		nuevoPropiertario.setIdPiezasActuales(nuevasIdPiezas);


		Map<String, Object> mapa = new HashMap<>();

		mapa.put( "loginPropietario", loginnuevoPropiertario);
		mapa.put("valorCompra",  precioFijo);
		mapa.put("fechaVenta", fecha);

		pieza.getHistorialPropietarios().add(mapa);
		pieza.setLoginPropietarioActual(loginnuevoPropiertario);

		PiezasPersistencia.actualizarPropietarioPieza(galeria,pieza);
		UsuarioPersistencia.actualizarCompradorCompra( comprador );
		UsuarioPersistencia.actualizarPropietarioCompra(propietarioAnterior,nuevoPropiertario);
		}


		int valor = pieza.getValores().get(0); 

		pieza.setDisponible(false);
		
		String propietarioAnteriorLogin = pieza.getLoginPropietarioActual();
		Propietario propietarioAnterior= Servicios.buscarPropietario(galeria, propietarioAnteriorLogin);
		ArrayList<String> piezasPropietarioAnterior = propietarioAnterior.getIdPiezasActuales();

		piezasPropietarioAnterior.remove(pieza.getTitulo());
		propietarioAnterior.setIdPiezasActuales(piezasPropietarioAnterior);

		
		ArrayList<Compra> historialCompra = comprador.getHistorialCompras();

		Compra compraNueva = new Compra(comprador.getLogin(),valor , pieza.getTitulo() , metodoPago, fecha);

		historialCompra.add(compraNueva);

		comprador.setHistorialCompras(historialCompra);
		
		
		ArrayList<String> piezas =  comprador.getIdpiezasCompradas();
		piezas.add(pieza.getTitulo());
		comprador.setIdpiezasCompradas(piezas);
		
		
		String loginnuevoPropiertario= comprador.login.replace("_comprador", "_propietario");
		Propietario nuevoPropiertario= Servicios.buscarPropietario(galeria, loginnuevoPropiertario);

		ArrayList<String> nuevoHistorial = nuevoPropiertario.getHistorialPiezas();
		nuevoHistorial.add(pieza.getTitulo());
		nuevoPropiertario.setHistorialPiezas(nuevoHistorial);

		ArrayList<String> nuevasIdPiezas = nuevoPropiertario.getIdPiezasActuales();
		nuevasIdPiezas.add(pieza.getTitulo());
		nuevoPropiertario.setIdPiezasActuales(nuevasIdPiezas);


		Map<String, Object> mapa = new HashMap<>();

		mapa.put( "loginPropietario", loginnuevoPropiertario);
		mapa.put("valorCompra", valor);
		mapa.put("fechaVenta", fecha);

		pieza.getHistorialPropietarios().add(mapa);
		pieza.setLoginPropietarioActual(loginnuevoPropiertario);

		PiezasPersistencia.actualizarPropietarioPieza(galeria,pieza);
		UsuarioPersistencia.actualizarCompradorCompra( comprador );
		UsuarioPersistencia.actualizarPropietarioCompra(propietarioAnterior,nuevoPropiertario);


	}




	public ArrayList<Compra> getComprasRegistradas() 
	{
		return comprasRegistradas;
	}





	public void setComprasRegistradas(ArrayList<Compra> comprasRegistradas) {
		this.comprasRegistradas = comprasRegistradas;
	}
}
