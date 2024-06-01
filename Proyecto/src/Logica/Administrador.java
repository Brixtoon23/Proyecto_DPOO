package Logica;


import java.util.ArrayList;

import java.util.List;

import Persistencia.AutoresPersistencia;
import Persistencia.PiezasPersistencia;
import Persistencia.SubastaPersistencia;
import Persistencia.TarjetasPersistencia;
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
	public static void ingresarTarjeta(Tarjeta tarjeta,Galeria galeria )
	{

			galeria.getTarjetas().add(tarjeta);

			TarjetasPersistencia.registrarTarjetas(tarjeta);
		
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
	
	public static boolean aprobarVentaSubasta(Oferta mejorOferta, Galeria galeria, String fecha, MetodoPago metodoPago)
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

			Cajero.registrarCompraSubasta(mejorOferta, comprador, galeria, fecha, metodoPago);

		}

		return vendida;

		
		
	}
	
	public static boolean aprobarVentaPrecioFijo(Comprador comprador,Pieza pieza, Galeria galeria ,String fecha, MetodoPago metodoPago) 
	{
		float cuenta = comprador.getEstadoCuenta();
		List<Integer> valores = pieza.getValores();
		int precioFijo = valores.get(0);
		boolean retorno= false;
		if (precioFijo <= cuenta)
		{
			Cajero.registrarCompraPrecioFijo(comprador,pieza, galeria, fecha, metodoPago);
			retorno= true;
			
		}
		else 
		{
			retorno= false;
		}

		return retorno;
	}
	
		

	public static void crearSusbasta(Galeria galeria, String id, ArrayList<String> piezas)
	{

		ArrayList<Oferta> listaOfertas= new ArrayList<Oferta>();

		Subasta subasta = new Subasta(id, listaOfertas, piezas);

		galeria.getSubastas().add(subasta);
		
		SubastaPersistencia.registrarSubasta(subasta);
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




