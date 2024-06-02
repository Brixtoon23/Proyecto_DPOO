package Logica;

public class Compra 
{
	
	private String compradorLogin;
	private int precio;
	private  String Nombrepieza;
	private String metodoPago; 
	private String fecha;

	public Compra(String compradorLogin, int precio, String nombrepieza, String metodoPago, String fecha) {
		this.compradorLogin = compradorLogin;
		this.precio = precio;
		Nombrepieza = nombrepieza;
		this.metodoPago = metodoPago;
		this.fecha = fecha;
	}

	public String getCompradorLogin() {
		return compradorLogin;
	}

	public void setCompradorLogin(String compradorLogin) {
		this.compradorLogin = compradorLogin;
	}

	public int getPrecio() {
		return precio;
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

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	


	
	
	

	

	
	

}