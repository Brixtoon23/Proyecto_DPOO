package Logica;

public class Compra 
{
	
	private String compradorLogin;
	private int precio;
	private  String Nombrepieza;
	private MetodoPago metodoPago; 
	private String fecha;

	


	
	
	

	

	public Compra(String compradorLogin, int precio, String nombrepieza, MetodoPago metodoPagoObjeto, String fecha) {
		this.compradorLogin = compradorLogin;
		this.precio = precio;
		Nombrepieza = nombrepieza;
		this.metodoPago = metodoPagoObjeto;
		this.fecha = fecha;
	}




	public void setCompradorLogin(String compradorLogin) {
		this.compradorLogin = compradorLogin;
	}




	public void setPrecio(int precio) {
		this.precio = precio;
	}




	public String getNombrepieza() {
		return Nombrepieza;
	}




	public void setNombrepieza(String nombrepieza) {
		Nombrepieza = nombrepieza;
	}




	




	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public int getPrecio() {
		return precio;
	}
	
	
	
	public String getCompradorLogin() {
		return compradorLogin;
	}




	public MetodoPago getMetodoPago() {
		return metodoPago;
	}




	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	
	
	


	
	
	

}