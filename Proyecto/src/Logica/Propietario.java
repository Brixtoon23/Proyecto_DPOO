package Logica;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Usuario
{
	
	private ArrayList<String> idPiezasActuales = new ArrayList<String>();
	private ArrayList<String> HistorialPiezas = new ArrayList<String>();
	public Propietario(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			ArrayList<String> idPiezasActuales, ArrayList<String> historialPiezas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.idPiezasActuales = idPiezasActuales;
		HistorialPiezas = historialPiezas;
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
