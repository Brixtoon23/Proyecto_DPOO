package Logica;

public class Compra 
{
	private boolean aceptada;
	private Comprador comprador;
	private int precio;
	private Pieza pieza;
	private String metodoPago; 
	public Compra(boolean aceptada, Comprador comprador, int precio, Pieza pieza, String metodoPago)
	 {
		
		this.aceptada = aceptada;
		this.comprador = comprador;
		this.precio = precio;
		this.pieza = pieza;
		this.metodoPago=metodoPago;
	}
	public boolean isAceptada() {
		return aceptada;
	}
	public Comprador getComprador() {
		return comprador;
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
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	
	
	

}