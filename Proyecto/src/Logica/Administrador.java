package Logica;


import java.util.ArrayList;

import java.util.List;

import Persistencia.AutoresPersistencia;
import Persistencia.PiezasPersistencia;
import Persistencia.SubastaPersistencia;
import Persistencia.TransaccionesPersistencia;
import Persistencia.UsuarioPersistencia;

public class Administrador extends Usuario

{


	public Administrador(String login, String nombre, String password, String rol, String telefono, boolean verificado) 
	{
		super(login, nombre, password, rol, telefono, verificado);
		
	}
	
	public  static void ingresarPieza(Galeria galeria, Pieza pieza) 
	{
		
		if(pieza.isBodega()==true)
		{
			   galeria.getInventario().getPiezasBodega().add(pieza);
			   PiezasPersistencia.registrarPieza(galeria,pieza);
			  
		     
		}
		else
		{
			 galeria.getInventario().getPiezasExhibidad().add(pieza);
			 PiezasPersistencia.registrarPieza(galeria,pieza);
		}

		Propietario propietario= Servicios.buscarPropietario(galeria, pieza.getLoginPropietarioActual());

		propietario.getHistorialPiezas().add(pieza.getTitulo());
		propietario.getIdPiezasActuales().add(pieza.getTitulo());
		int nuevaCantidadObras = galeria.getCantidadObras() + 1;
		galeria.setCantidadObras(nuevaCantidadObras);
		
	    // Actualizar persistecia propietario

		UsuarioPersistencia.actualizarPropietario( propietario);



		
		
	}

	public static void ingresarUsuario(Usuario usuario,Galeria galeria )
	{

			galeria.getUsuarios().add(usuario);

			UsuarioPersistencia.registrarUsuario(usuario);
		
	}
		
	
	public static void verificarComprador(Comprador cliente)
	{
		if (cliente.isMora()==false)
		{
			cliente.setVerificado(true);

	        float estadoCuenta = cliente.getEstadoCuenta();

	        if (estadoCuenta < 200000) 
	        {
	            cliente.setMaxCompras(150000);
	        } 
	        
	        else if (estadoCuenta >= 200000 && estadoCuenta < 900000) 
	        {
	            cliente.setMaxCompras(800000);
	        } 
	        
	        else if (estadoCuenta >= 900000 && estadoCuenta < 2000000)
	        {
	            cliente.setMaxCompras(1900000);
	        }
		}
		
		else
		{
			cliente.setVerificado(false);
		}
		
	}
		
	public static void ingresarAutor(Galeria galeria, ArrayList<String> autores, String pieza)
	{
		
		for(int i=0 ;i < autores.size()  ;i++)
		{
			if (galeria.getAutores().containsKey(autores.get(i))) 
			{
				galeria.getAutores().get(autores.get(i)).add(pieza);
				AutoresPersistencia.registrarAutor(autores.get(i),pieza);
			}
			else
			{
				galeria.getAutores().put(autores.get(i), new ArrayList<String>());
				galeria.getAutores().get(autores.get(i)).add(pieza);
				AutoresPersistencia.registrarAutor(autores.get(i),pieza);

			}
		}

			


	}
	
	public static void verificarOperador(Operador operador)
	{
		if (operador.getPassword().equals("Galeria"))
			operador.setVerificado(true);
		else
		{
			operador.setVerificado(false);
		}
		
   
		
	}
	public static void verificarCajero(Cajero cajero)
	{
		if (cajero.getPassword().equals("Transferencia"))
			cajero.setVerificado(true);
		else
		{
			cajero.setVerificado(false);
		}
	}
	
	public static void verificarAdministrador(Administrador admin) 
	{
		if (admin.getPassword().equals("Admin"))
			admin.setVerificado(true);
		else
		{
			admin.setVerificado(false);
		}
	
		
	}
	public static void verificarPropietario(Propietario propietario) 
	{
		if (propietario.getPassword().equals("Admin"))
			propietario.setVerificado(true);
		else
		{
			propietario.setVerificado(false);
		}
	
		
	}
	
	public static boolean aprobarVentaSubasta(Oferta mejorOferta, Galeria galeria, String fecha)
	{
		String loginComprador=mejorOferta.getCompradorLogin();
		
		Comprador comprador= Servicios.buscarComprador(galeria, loginComprador);
		String nombrePieza= mejorOferta.getNombrepiezaSubastada();
		Pieza pieza= Servicios.buscarPieza(galeria, nombrePieza);
		int valorMinimo= pieza.valores.get(1);
		boolean vendida=false;

		if (mejorOferta.getValorOfertado() <valorMinimo )
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida porque el valor ofertado es menor que el valor mínimo";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}
		else if (comprador.isMora()==true)
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida, ya que te encuentras en mora";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}
		else if(comprador.getEstadoCuenta()< mejorOferta.getValorOfertado())
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida, porque no tienes dinero suficiente en tu estado de cuenta";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}

		else if (comprador.getMaxCompras()< mejorOferta.getValorOfertado() )
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida, porque superaste el maximo de tus compras";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}

		else
		{
			vendida=true;

			Cajero.registrarCompraSubasta(mejorOferta, comprador, galeria, fecha);

		}

		return vendida;

		
		
	}
	
	public static String aprobarVentaPrecioFijo(Comprador comprador, Pieza pieza, String metodoPago, Galeria galeria, String fecha, String pasarela, String pago, String csv, String clave) {
		boolean pagoAprovado = false;
		boolean retorno = false;
		String mensaje = "";
	
		if (metodoPago.equals("tarjeta") || metodoPago.equals("transferencia")) {
			int n = galeria.getHistorias().size();
			n++;
			Historia historia = new Historia(comprador.getLogin(), fecha, pieza.getValores().get(0), false, n, null);
	
			if (pago.equals("davivienda")) 
			{
				mensaje = Pasarelas.menuDavivienda.menu(historia, csv, clave, clave);
				if ( mensaje.equals("Pago realizado con éxito"))
				{
				pagoAprovado = true;
				}

			} else if (pago.equals("bancolombia")) 
			{
				mensaje = Pasarelas.menuBancolombia.menu(historia, csv, clave);
				pagoAprovado = mensaje.equals("Pago realizado con éxito");
			}
	
			historia.setRealizada(pagoAprovado);
			galeria.getHistorias().add(historia);
			TransaccionesPersistencia.registrarHistoria(historia);
	
			if (pagoAprovado) 
			{
				Cajero.registrarCompraPrecioFijo(comprador, pieza, metodoPago, galeria, fecha);
				retorno = true;
			}
		} else {
			float cuenta = comprador.getEstadoCuenta();
			List<Integer> valores = pieza.getValores();
			int precioFijo = valores.get(0);
			if (precioFijo <= cuenta || pagoAprovado) {
				Cajero.registrarCompraPrecioFijo(comprador, pieza, metodoPago, galeria, fecha);
				mensaje= "true";
			}
		}
	
		return mensaje;
	}
	
	
		

	public static boolean  crearSusbasta(Galeria galeria, String id, ArrayList<String> piezas)
	{
		boolean retorno = true; 

		ArrayList<Oferta> listaOfertas= new ArrayList<Oferta>();

		Subasta subasta = new Subasta(id, listaOfertas, piezas);

		galeria.getSubastas().add(subasta);
		
		SubastaPersistencia.registrarSubasta(subasta);


		return retorno;
	}
	
	
	public static int montoColeccion(Galeria galeria, String loginComprador)
	{


		ArrayList<Compra> compras;
		int monto=0;
		String loginPropiertario= loginComprador.replace("_comprador", "_propietario");
		Propietario propietario = Servicios.buscarPropietario(galeria, loginPropiertario);

		if  ( propietario != null)
		{
			
			 ArrayList<String> idPiezas = propietario.getIdPiezasActuales();
			for (  String id : idPiezas)
			{
				Pieza pieza = Servicios.buscarPieza(galeria, id);
				monto+=pieza.getValores().get(0);
			}
			return monto;
		}
		return monto;


	}


	
	
}




