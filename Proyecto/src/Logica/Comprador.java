package Logica;

import java.util.List;

public class Comprador  extends Usuario
{
	private  float estadoCuenta;
	private  List<Compra> historialCompras;
	private float maxCompras;
	private boolean mora;
	private List<Mensaje> mensajesSubasta;
	private List<String> idpiezasCompradas;

	
	
	
	
	
	
	public Comprador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			float estadoCuenta, List<Compra> historialidCompras, float maxCompras, boolean mora,
			List<Mensaje> mensajesSubasta, List<String> idpiezasCompradas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.estadoCuenta = estadoCuenta;
		this.historialCompras = historialidCompras;
		this.maxCompras = maxCompras;
		this.mora = mora;
		this.mensajesSubasta = mensajesSubasta;
		this.idpiezasCompradas = idpiezasCompradas;
	}
	public float getEstadoCuenta() {
		return estadoCuenta;
	}
	public void setEstadoCuenta(float estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	
	
	public float getMaxCompras() {
		return maxCompras;
	}
	public void setMaxCompras(float maxCompras) {
		this.maxCompras = maxCompras;
	}

	public boolean isMora() {
		return mora;
	}
	public void setMora(boolean mora) {
		this.mora = mora;
	}
	
	



	public List<Mensaje> getMensajesSubasta() {
		return mensajesSubasta;
	}

	public void setMensajesSubasta(List<Mensaje> mensajesSubasta) {
		this.mensajesSubasta = mensajesSubasta;
	}
	
	public List<String> getIdpiezasCompradas() {
		return idpiezasCompradas;
	}
	public void setIdpiezasCompradas(List<String> idpiezasCompradas) {
		this.idpiezasCompradas = idpiezasCompradas;
	}
	public List<Compra> getHistorialCompras() {
		return historialCompras;
	}
	public void setHistorialCompras(List<Compra> historialCompras) {
		this.historialCompras = historialCompras;
	}

	

	


}