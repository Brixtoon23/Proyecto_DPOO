package Logica;


import java.util.ArrayList;
import java.util.List;

import Persistencia.PiezasPersistencia;
import Persistencia.UsuarioPersistencia;

public class Administrador extends Usuario

{


	public Administrador(String login, String nombre, String password, String rol, String telefono, boolean verificado) {
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
	
	
	
		
	public void aprobarVentaSubasta(Operador operador )
	{
		List<Oferta> mejoresOfertas= Operador.mejoresOfertas(operador.getSubastas());
		
		for (Oferta oferta: mejoresOfertas)
		{
			
			Comprador comprador= oferta.getComprador();
			if (comprador.isMora()== true)
				oferta.getPiezaSubastada().setDisponoble(true);
			else if (comprador.getEstadoCuenta()< oferta.getValorOfertado())
			{
				oferta.getPiezaSubastada().setDisponoble(true);
			
			}
			else if (oferta.getValorOfertado() > comprador.getMaxCompras())
					{
				         oferta.getPiezaSubastada().setDisponoble(true);
					}
			else
			{
				Cajero.registrarCompraSubasta(oferta);
			}
		}
	}
	
	public void aprobarVentaPrecioFijo(Comprador comprador,Pieza pieza, String metodoPago ) 
	{
		float cuenta = comprador.getEstadoCuenta();
		List<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		if (precioFijo <= cuenta)
		{
			Cajero.registrarCompraPrecioFijo(comprador,pieza, metodoPago);
			
		}
	}
	
		
		public static void ingresarUsuario(Usuario usuario,Galeria galeria )
		{

			galeria.getUsuarios().add(usuario);

			UsuarioPersistencia.registrarUsuario(usuario);


		}

		public static void crearSusbasta(int id, Pieza pieza)
		{

			 List<Oferta> listaOfertas= new ArrayList<>();

			 List<Pieza> listaPiezasSubasta=   new ArrayList<>();
			 listaPiezasSubasta.add(pieza);

			  Subasta subasta =new Subasta( id, listaOfertas, listaPiezasSubasta);

			  Operador.getSubastas().add(subasta);
		}

		public static boolean verificacionComprador(Comprador comprador, Pieza pieza)
		{
			boolean tienePlata = (comprador.getEstadoCuenta()-pieza.getValores().get(0))>0;
			return (comprador.isVerificado())&&(!comprador.isMora())&&tienePlata;
		}
		
	
}




