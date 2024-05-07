package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cajero  extends Usuario
{
	private List<String> idcomprasRegistradas;

	
	
	public Cajero(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			List<String> idcomprasRegistradas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.idcomprasRegistradas = idcomprasRegistradas;
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
		Map<String, String> mapa = new HashMap<>();
		mapa.put("propietario",comprador.getLogin());
		
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
		List<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		
		String propietarioAnteriorLogin = pieza.getLoginPropietarioActual();
		Propietario propietarioAnterior= Servicios.buscarPropietario(galeria, propietarioAnteriorLogin);
		List<String> piezasPropietarioAnterior = propietarioAnterior.getIdPiezasActuales();

		piezasPropietarioAnterior.remove(pieza.getTitulo());
		
		List<Compra> historialCompra = comprador.getHistorialCompras();

		Compra compraNueva = new Compra(propietarioAnteriorLogin, precioFijo, pieza.getTitulo() , metodoPago, fecha);

		historialCompra.add(compraNueva);
		
		cuenta = cuenta - precioFijo;
		comprador.setEstadoCuenta(cuenta);
		
		
		List<String> piezas =  comprador.getIdpiezasCompradas();
		piezas.add(pieza.getTitulo());

		comprador.setIdpiezasCompradas(piezas);
		String loginnuevoPropiertario= comprador.login.replace("_comprador", "_propietario");
		Propietario nuevoPropiertario= Servicios.buscarPropietario(galeria, loginnuevoPropiertario);

		nuevoPropiertario.getHistorialPiezas().add(pieza.getTitulo());
		nuevoPropiertario.getIdPiezasActuales().add(pieza.getTitulo());

		
		

	}













	public List<String> getIdcomprasRegistradas() {
		return idcomprasRegistradas;
	}













	public void setIdcomprasRegistradas(List<String> idcomprasRegistradas) {
		this.idcomprasRegistradas = idcomprasRegistradas;
	}
}
