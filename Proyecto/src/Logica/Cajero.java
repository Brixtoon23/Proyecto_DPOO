package Logica;

import java.util.ArrayList;
import java.util.List;

public class Cajero  extends Usuario
{
	private List<Compra> comprasRegistradas;

	

	public Cajero(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			List<Compra> comprasRegistradas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.comprasRegistradas = comprasRegistradas;
	}

	public List<Compra> getComprasRegistradas() {
		return comprasRegistradas;
	}

	public void setComprasRegistradas(List<Compra> comprasRegistradas) 
	{
		this.comprasRegistradas = comprasRegistradas;
	}

	
	public static void registrarCompraSubasta(Oferta oferta, Comprador comprador)

	{

		Pieza pieza =  oferta.getPiezaSubastada();

		pieza.setDisponoble(false);

		pieza.setLoginPropietario(comprador.getLogin());
		comprador.getPiezasCompradas().add(pieza);
		Compra compra= new Compra(comprador.getLogin(), oferta.getValorOfertado(), pieza, oferta.getMetodoPago());
		comprador.getHistorialCompras().add(compra);
		String mensaje1="La pieza con el titulo "+ pieza.getTitulo()+ " " + "fue vendida exitosamente";
		Mensaje mensaje = new Mensaje(pieza.getTitulo(), true, mensaje1);
		comprador.getMensajesSubasta().add(mensaje);
			





		
	}









	
	public static void registrarCompraPrecioFijo(Comprador comprador,Pieza pieza, String metodoPago) 
	{
		float cuenta = comprador.getEstadoCuenta();
		List<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		
		String propietarioAnteriorLogin = pieza.getLoginPropietario();
		Propietario propietarioAnterior= Servicios.buscarPropietario(null, propietarioAnteriorLogin);
		List<Pieza> piezasPropietarioAnterior = propietarioAnterior.getPiezasActuales();

		piezasPropietarioAnterior.remove(pieza);
		
		List<Compra> historialCompra = comprador.getHistorialCompras();

		Compra compraNueva = new Compra(propietarioAnteriorLogin, precioFijo, pieza, metodoPago);

		historialCompra.add(compraNueva);
		
		cuenta = cuenta - precioFijo;
		comprador.setEstadoCuenta(cuenta);
		
		
		List<Pieza> piezas =  comprador.getPiezasCompradas();
		piezas.add(pieza);
		comprador.setPiezasCompradas(piezas);


		Propietario nuevoPropiertario= Servicios.buscarPropietario(null, comprador.login);
		if (nuevoPropiertario== null)
		{
			new Propietario( , propietarioAnteriorLogin, metodoPago, propietarioAnteriorLogin, propietarioAnteriorLogin, false, piezas, piezas)

		}
		
		
		
		 
		
		
	
		
	}
}
