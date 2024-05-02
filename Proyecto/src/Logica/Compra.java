package Logica;

public class Compra 
{
	
	private String compradorLogin;
	private int precio;
	private Pieza pieza;
	private String metodoPago; 
	public Compra( String compradorLogin, int precio, Pieza pieza, String metodoPago)
	 {
		
		
		this.compradorLogin = compradorLogin;
		this.precio = precio;
		this.pieza = pieza;
		this.metodoPago=metodoPago;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public Pieza getPieza() {
		return pieza;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public String getCompradorLogin() {
		return compradorLogin;
	}
	
	


	
	
	

}