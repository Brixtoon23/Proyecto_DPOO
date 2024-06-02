package Logica;

import java.util.ArrayList;


public class Comprador  extends Usuario
{
	private  float estadoCuenta;
	private  ArrayList<Compra> historialCompras;
	private float maxCompras;
	private boolean mora;
	private ArrayList<Mensaje> mensajesSubasta;
	private ArrayList<String> idpiezasCompradas;

	public Comprador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			float estadoCuenta, ArrayList<Compra> historialCompras, float maxCompras, boolean mora,
			ArrayList<Mensaje> mensajesSubasta, ArrayList<String> idpiezasCompradas) 
			
	{
		super(login, nombre, password, rol, telefono, verificado);
		this.estadoCuenta = estadoCuenta;
		this.historialCompras = historialCompras;
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

	public ArrayList<Compra> getHistorialCompras() {
		return historialCompras;
	}

	public void setHistorialCompras(ArrayList<Compra> historialCompras) {
		this.historialCompras = historialCompras;
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

	public ArrayList<Mensaje> getMensajesSubasta() {
		return mensajesSubasta;
	}

	public void setMensajesSubasta(ArrayList<Mensaje> mensajesSubasta) {
		this.mensajesSubasta = mensajesSubasta;
	}

	public ArrayList<String> getIdpiezasCompradas() {
		return idpiezasCompradas;
	}

	public void setIdpiezasCompradas(ArrayList<String> idpiezasCompradas) {
		this.idpiezasCompradas = idpiezasCompradas;
	}

	

}