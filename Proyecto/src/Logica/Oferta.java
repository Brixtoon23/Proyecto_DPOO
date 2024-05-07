package Logica;

public class Oferta 
{
	private String Nombre;
	private String  compradorLogin;
	private int valorOfertado;
	private String idSubasta;
	private String metodoPago;
	private String NombrepiezaSubastada;
	public Oferta(String nombre, String compradorLogin, int valorOfertado, String idSubasta, String metodoPago,
			String nombrepiezaSubastada) {
		Nombre = nombre;
		this.compradorLogin = compradorLogin;
		this.valorOfertado = valorOfertado;
		this.idSubasta = idSubasta;
		this.metodoPago = metodoPago;
		NombrepiezaSubastada = nombrepiezaSubastada;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCompradorLogin() {
		return compradorLogin;
	}
	public void setCompradorLogin(String compradorLogin) {
		this.compradorLogin = compradorLogin;
	}
	public int getValorOfertado() {
		return valorOfertado;
	}
	public void setValorOfertado(int valorOfertado) {
		this.valorOfertado = valorOfertado;
	}
	public String getIdSubasta() {
		return idSubasta;
	}
	public void setIdSubasta(String idSubasta) {
		this.idSubasta = idSubasta;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public String getNombrepiezaSubastada() {
		return NombrepiezaSubastada;
	}
	public void setNombrepiezaSubastada(String nombrepiezaSubastada) {
		NombrepiezaSubastada = nombrepiezaSubastada;
	}
	

	

	

	
	
	
	
	
}
	
	
	