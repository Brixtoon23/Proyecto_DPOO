package Logica;

public class Oferta 
{
	private String Nombre;
	private String  compradorLogin;
	private int valorOfertado;
	private String idSubasta;
	private String metodoPago;

	
	public Oferta(String nombre, String compradorLogin, int valorOfertado, String idSubasta, String metodoPago) {
		Nombre = nombre;
		this.compradorLogin = compradorLogin;
		this.valorOfertado = valorOfertado;
		this.idSubasta = idSubasta;
		this.metodoPago = metodoPago;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getCompradorLogin() {
		return compradorLogin;
	}
	public int getValorOfertado() {
		return valorOfertado;
	}
	public String getIdSubasta() {
		return idSubasta;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	

	
	
	
	
	
}
	
	
	