package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Pieza pieza = Servicios.buscarPiezaSubasta(galeria, nombrePieza);
		float cuenta= comprador.getEstadoCuenta() - oferta.getValorOfertado();
		comprador.setEstadoCuenta(cuenta);


		pieza.setDisponible(false);


		Propietario propietarioAnterior= Servicios.buscarPropietario(galeria, pieza.getLoginPropietarioActual());
		propietarioAnterior.getIdPiezasActuales().remove(pieza.getTitulo());


		String loginnuevoPropiertario= comprador.login.replace("_comprador", "_propietario");

		Map<String, Object> mapa = new HashMap<>();

		mapa.put(  "loginPropietario",loginnuevoPropiertario);
		mapa.put("valorCompra", oferta.getValorOfertado());
		mapa.put("fechaVenta", fecha);

		pieza.getHistorialPropietarios().add(mapa);

		
	

		Compra compra= new Compra(nombrePieza, oferta.getValorOfertado(), nombrePieza, nombrePieza, fecha);
		
		
		comprador.getHistorialCompras().add(compra);

		String mensaje1="La pieza con el titulo "+ pieza.getTitulo()+ " " + "fue vendida exitosamente";
		Mensaje mensaje = new Mensaje(pieza.getTitulo(), true, mensaje1);

		comprador.getMensajesSubasta().add(mensaje);


			





		
	}









	
	public static void registrarCompraPrecioFijo(Comprador comprador,Pieza pieza, String metodoPago,Galeria galeria, String fecha) 
	{
		float cuenta = comprador.getEstadoCuenta();
		ArrayList<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		cuenta = cuenta - precioFijo;
		comprador.setEstadoCuenta(cuenta);

		pieza.setDisponible(false);
		
		String propietarioAnteriorLogin = pieza.getLoginPropietarioActual();
		Propietario propietarioAnterior= Servicios.buscarPropietario(galeria, propietarioAnteriorLogin);
		ArrayList<String> piezasPropietarioAnterior = propietarioAnterior.getIdPiezasActuales();

		piezasPropietarioAnterior.remove(pieza.getTitulo());
		propietarioAnterior.setIdPiezasActuales(piezasPropietarioAnterior);

		
		ArrayList<Compra> historialCompra = comprador.getHistorialCompras();

		Compra compraNueva = new Compra(propietarioAnteriorLogin, precioFijo, pieza.getTitulo() , metodoPago, fecha);

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

		mapa.put(  "loginPropietario", loginnuevoPropiertario);
		mapa.put("valorCompra", precioFijo);
		mapa.put("fechaVenta", fecha);

		pieza.getHistorialPropietarios().add(mapa);

		
		

	}













	public ArrayList<Compra> getComprasRegistradas() 
	{
		return comprasRegistradas;
	}













	public void setComprasRegistradas(ArrayList<Compra> comprasRegistradas) {
		this.comprasRegistradas = comprasRegistradas;
	}
}
