package Logica;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Usuario
{
	
	private ArrayList<Pieza> piezasActuales = new ArrayList<Pieza>();
	private ArrayList<Pieza> historialPiezas = new ArrayList<Pieza>();
	
	public Propietario(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			List<Pieza> piezasActuales, List<Pieza> historialPiezas) 
	{
		super(login, nombre, password, rol, telefono, verificado);
	}

	public List<Pieza> getPiezasActuales() {
		return piezasActuales;
	}

	public void setPiezasActuales(ArrayList<Pieza> piezasActuales) {
		this.piezasActuales = piezasActuales;
	}

	public List<Pieza> getHistorialPiezas() {
		return historialPiezas;
	}

	public void setHistorialPiezas(ArrayList<Pieza> historialPiezas) {
		this.historialPiezas = historialPiezas;
	}
	
	
	
	
	

}
