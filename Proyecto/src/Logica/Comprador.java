package Logica;

import java.util.List;

public class Comprador  extends Usuario
{
	private  float estadoCuenta;
	private  List<Compra> historialCompras;
	private float maxCompras;
	private boolean mora;

	private List<Pieza> piezasCompradas;
	
	public Comprador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			float estadoCuenta, List<Compra> historialCompras,float maxCompras,
			boolean mora, List<Pieza> piezasCompradas)
	{
		super(login, nombre, password, rol, telefono, verificado);
		this.estadoCuenta =  estadoCuenta;
		this.historialCompras = historialCompras;
		this.maxCompras =  maxCompras;
		
		this.mora = mora;
		this.piezasCompradas = piezasCompradas;
		
	}
	
	
	
	
	public float getEstadoCuenta() {
		return estadoCuenta;
	}
	public void setEstadoCuenta(float estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	public List<Compra> getHistorialCompras() {
		return historialCompras;
	}
	public void setHistorialCompras(List<Compra> historialCompras) {
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
	public List<Pieza> getPiezasCompradas() {
		return piezasCompradas;
	}
	public void setPiezasCompradas(List<Pieza> piezasCompradas) {
		this.piezasCompradas = piezasCompradas;
	}


}