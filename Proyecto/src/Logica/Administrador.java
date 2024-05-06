package Logica;


import java.util.ArrayList;
import java.util.List;

import Persistencia.PiezasPersistencia;
import Persistencia.SubastaPersistencia;
import Persistencia.UsuarioPersistencia;

public class Administrador extends Usuario

{


	public Administrador(String login, String nombre, String password, String rol, String telefono, boolean verificado) 
	{
		super(login, nombre, password, rol, telefono, verificado);
		
	}
	
	public  static void ingresarPieza(Galeria galeria,Pieza pieza ) 
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
	
	
	
		
	public static boolean aprobarVentaSubasta(Oferta mejorOferta, Galeria galeria)
	{
		String loginComprador=mejorOferta.getCompradorLogin();
		Comprador comprador= Servicios.buscarComprador(galeria, loginComprador);
		Pieza pieza= mejorOferta.getPiezaSubastada();
		int valorMinimo= pieza.valores.get(1);
		 boolean vendida=false;

		if (mejorOferta.getValorOfertado()< valorMinimo )
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}
		else if (comprador.isMora()==true)
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}
		else if(comprador.getEstadoCuenta()< mejorOferta.getValorOfertado())
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}

		else if (comprador.getMaxCompras()< mejorOferta.getValorOfertado() )
		{
			vendida=false;
			String mensaje1= "La pieza con el titulo "+ pieza.getTitulo()+ " " + " no fue vendida";

			Mensaje mensaje2= new Mensaje(pieza.getTitulo(), vendida, mensaje1 );
			comprador.getMensajesSubasta().add(mensaje2);
		}

		else
		{
			vendida=true;

			Cajero.registrarCompraSubasta(mejorOferta, comprador, galeria);

		}

		return vendida;

		
		
	}
	
	public static boolean aprobarVentaPrecioFijo(Comprador comprador,Pieza pieza, String metodoPago, Galeria galeria) 
	{
		float cuenta = comprador.getEstadoCuenta();
		List<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		boolean retorno= false;
		if (precioFijo <= cuenta)
		{
			Cajero.registrarCompraPrecioFijo(comprador,pieza, metodoPago, galeria);
			retorno= true;
			
		}
		else 
		{
			retorno= false;
		}

		return retorno;
	}
	
		
		public static void ingresarUsuario(Usuario usuario,Galeria galeria )
		{

			galeria.getUsuarios().add(usuario);

			UsuarioPersistencia.registrarUsuario(usuario);


		}

		public static void crearSusbasta(Galeria galeria, String id)
		{

			 ArrayList<Oferta> listaOfertas= new ArrayList<Oferta>();

			 ArrayList<Pieza> listaPiezasSubasta=   new ArrayList<>();
			 
			 ArrayList<Comprador> listaCompradores = new ArrayList<Comprador>();

			  Subasta subasta = new Subasta(id, listaOfertas, listaPiezasSubasta, listaCompradores);

			  galeria.getSubastas().add(subasta);
			  SubastaPersistencia.registrarSubasta(galeria, subasta);
		}		
	
}




