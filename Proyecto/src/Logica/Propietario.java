package Logica;

import java.util.ArrayList;


public class Propietario extends Usuario
{
	
	private ArrayList<String> idPiezasActuales = new ArrayList<String>();
	private ArrayList<String> HistorialPiezas = new ArrayList<String>();
	
	public Propietario(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			ArrayList<String> piezasActuales, ArrayList<String> historialPiezas2) {
		super(login, nombre, password, rol, telefono, verificado);
		this.idPiezasActuales = piezasActuales;
		HistorialPiezas = historialPiezas2;
	}
	public ArrayList<String> getIdPiezasActuales() {
		return idPiezasActuales;
	}
	public void setIdPiezasActuales(ArrayList<String> idPiezasActuales) {
		this.idPiezasActuales = idPiezasActuales;
	}
	public ArrayList<String> getHistorialPiezas() {
		return HistorialPiezas;
	}
	public void setHistorialPiezas(ArrayList<String> historialPiezas) {
		HistorialPiezas = historialPiezas;
	}
	

	
	
	
	
	
	

}
