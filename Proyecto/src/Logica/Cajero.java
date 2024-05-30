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



	public static void registrarCompraSubasta(Oferta oferta, Comprador comprador, Galeria galeria, String fecha, MetodoPago metodoPago)

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

		Compra compra= new Compra(comprador.getLogin(), oferta.getValorOfertado(), nombrePieza, metodoPago, fecha);
		
		
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




	
	public static void registrarCompraPrecioFijo(Comprador comprador,Pieza pieza, Galeria galeria, String fecha, MetodoPago metodoPago) 
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
	

		Compra compraNueva = new Compra(comprador.getLogin(), precioFijo, pieza.getTitulo() , metodoPago, fecha);

		historialCompra.add(compraNueva);

		comprador.setHistorialCompras(historialCompra);
		
		
		
		
		ArrayList<String> piezas =  comprador.getIdpiezasCompradas();
		piezas.add(pieza.getTitulo());
		comprador.setIdpiezasCompradas(piezas);
		
		
		String loginnuevoPropiertario= comprador.login.replace("_comprador", "_propietario");
		Propietario nuevoPropiertario= Servicios.buscarPropietario(galeria, loginnuevoPropiertario);

		nuevoPropiertario.getHistorialPiezas().add(pieza.getTitulo());
		nuevoPropiertario.getIdPiezasActuales().add(pieza.getTitulo());


		Map<String, Object> mapa = new HashMap<>();

		mapa.put( "loginPropietario", loginnuevoPropiertario);
		mapa.put("valorCompra", precioFijo);
		mapa.put("fechaVenta", fecha);

		pieza.getHistorialPropietarios().add(mapa);

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


	public static void registrarCompraTarjetaPrecioFijo(String loginComprador, String nombrePieza, Galeria galeria, String fecha, int numeroTarjeta) 
	{
		Tarjeta metodoPago= Servicios.BuscarTarjeta(galeria, numeroTarjeta);
		Comprador comprador= Servicios.buscarComprador(galeria, loginComprador);
		Pieza pieza= Servicios.buscarPieza(galeria, nombrePieza);
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
	

		Compra compraNueva = new Compra(comprador.getLogin(), precioFijo, pieza.getTitulo() , metodoPago, fecha);

		historialCompra.add(compraNueva);

		comprador.setHistorialCompras(historialCompra);
		
		
		
		
		ArrayList<String> piezas =  comprador.getIdpiezasCompradas();
		piezas.add(pieza.getTitulo());
		comprador.setIdpiezasCompradas(piezas);
		
		
		String loginnuevoPropiertario= comprador.login.replace("_comprador", "_propietario");
		Propietario nuevoPropiertario= Servicios.buscarPropietario(galeria, loginnuevoPropiertario);

		nuevoPropiertario.getHistorialPiezas().add(pieza.getTitulo());
		nuevoPropiertario.getIdPiezasActuales().add(pieza.getTitulo());


		Map<String, Object> mapa = new HashMap<>();

		mapa.put( "loginPropietario", loginnuevoPropiertario);
		mapa.put("valorCompra", precioFijo);
		mapa.put("fechaVenta", fecha);

		pieza.getHistorialPropietarios().add(mapa);

		PiezasPersistencia.actualizarPropietarioPieza(galeria,pieza);
		UsuarioPersistencia.actualizarCompradorCompra( comprador );
		UsuarioPersistencia.actualizarPropietarioCompra(propietarioAnterior,nuevoPropiertario);


		
	}



}
