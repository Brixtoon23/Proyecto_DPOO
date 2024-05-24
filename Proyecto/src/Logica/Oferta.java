package Logica;

public class Oferta 
{
	
	private String  compradorLogin;
	private int valorOfertado;
	private String metodoPago;
	private String nombrePiezaSubastada;
	private String fecha;

	
	
	public Oferta(String compradorLogin, int valorOfertado,  String metodoPago,
			String nombrePiezaSubastada, String fecha) {
		this.compradorLogin = compradorLogin;
		this.valorOfertado = valorOfertado;

		this.metodoPago = metodoPago;
		this.nombrePiezaSubastada = nombrePiezaSubastada;
		this.fecha = fecha;
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
	
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public String getNombrepiezaSubastada() {
		return nombrePiezaSubastada;
	}
	public void setNombrepiezaSubastada(String nombrePiezaSubastada) {
		this.nombrePiezaSubastada = nombrePiezaSubastada;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
	
	
	