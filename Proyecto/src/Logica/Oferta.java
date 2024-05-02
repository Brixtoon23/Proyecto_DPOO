package Logica;

public class Oferta 
{
	private String Nombre;
	private String  compradorLogin;
	private int valorOfertado;
	private String idSubasta;
	private String metodoPago;
	private Pieza piezaSubastada;

	
	
	
	public Oferta(String nombre, String compradorLogin, int valorOfertado, String idSubasta, String metodoPago,
			Pieza piezaSubastada) {
		Nombre = nombre;
		this.compradorLogin = compradorLogin;
		this.valorOfertado = valorOfertado;
		this.idSubasta = idSubasta;
		this.metodoPago = metodoPago;
		this.piezaSubastada = piezaSubastada;
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
	public Pieza getPiezaSubastada() {
		return piezaSubastada;
	}
	
	

	
	
	
	
	
}
	
	
	