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

	
	public static void registrarCompraSubasta(Oferta oferta)

	{
		boolean disponible= oferta.getPiezaSubastada().isDisponible();
		if (disponible == false)
		{
			Comprador comprador= oferta.getComprador();
			int valorPago= oferta.getValorOfertado();
			float estadoCuenta=comprador.getEstadoCuenta();
			
		
			comprador.setEstadoCuenta( (estadoCuenta-valorPago));
			
			
			String metodoPago= oferta.getMetodoPago();
			Pieza piezaComprada=oferta.getPiezaSubastada();
			piezaComprada.getPropietario().getPiezasActuales().remove(piezaComprada);
			Compra compra= new Compra(true,  comprador,valorPago,  piezaComprada, metodoPago );
			comprador.getHistorialCompras().add(compra);
			comprador.getPiezasCompradas().add(piezaComprada);
			
			
			List<Compra> compras= comprador.getHistorialCompras();
			List<Pieza> historialPiezas= new ArrayList<>();
			for (Compra compra1 : compras)
			{
				historialPiezas.add(compra1.getPieza());
			}
			
			Propietario newPropietario= new Propietario(comprador.getLogin(), comprador.getNombre(), comprador.getPassword(), comprador.getRol(), comprador.getTelefono(), comprador.isVerificado(),
					comprador.getPiezasCompradas(),  historialPiezas);
			
			piezaComprada.setPropietario(newPropietario);
			
			
			comprador.getHistorialCompras().add(compra);
			comprador.getPiezasCompradas().add(piezaComprada);
			
			
		}
	}
	public static void registrarCompraPrecioFijo(Comprador comprador,Pieza pieza, String metodoPago) 
	{
		float cuenta = comprador.getEstadoCuenta();
		List<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		
		Propietario propietarioAnterior = pieza.getPropietario();
		List<Pieza> piezasPropietarioAnterior = propietarioAnterior.getPiezasActuales();
		piezasPropietarioAnterior.remove(pieza);
		
		List<Compra> historialCompra = comprador.getHistorialCompras();
		Compra compraNueva = new Compra(true, comprador, precioFijo, pieza,  metodoPago);
		historialCompra.add(compraNueva);
		comprador.setHistorialCompras(historialCompra);
		
		
		cuenta = cuenta - precioFijo;
		comprador.setEstadoCuenta(cuenta);
		
		
		List<Pieza> piezas =  comprador.getPiezasCompradas();
		piezas.add(pieza);
		comprador.setPiezasCompradas(piezas);
		
		
		List<Compra> compras = comprador.getHistorialCompras();
		List<Pieza> historial = new ArrayList<Pieza>();
		for (Compra compra :compras)
		{
			Pieza pieza1 = compra.getPieza();
			historial.add(pieza1);
			
		}
		
		
		Propietario propietario = new Propietario(comprador.getLogin(), comprador.getNombre(), comprador.getPassword(), comprador.getRol(), comprador.getTelefono(), comprador.isVerificado(), comprador.getPiezasCompradas(), historial);
		pieza.setPropietario(propietario);
		
	}

	public static boolean verificarComprador(Comprador comprador,Pieza pieza)
	{
		return Administrador.verificacionComprador(comprador,pieza);
	}
}
