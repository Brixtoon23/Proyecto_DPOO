package Logica;

public class Oferta 
{
	private Pieza piezaSubastada;
	private String  compradorLogin;
	private int valorOfertado;
	private String idSubasta;
	private String metodoPago;
	public Oferta(Pieza piezaSubastada, String compradorLogin, int valorOfertado, String idSubasta, String metodoPago) {
		this.piezaSubastada= piezaSubastada;
		this.compradorLogin = compradorLogin;
		this.valorOfertado = valorOfertado;
		this.idSubasta = idSubasta;
		this.metodoPago = metodoPago;
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