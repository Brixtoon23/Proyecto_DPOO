package Logica;

import java.util.ArrayList;
import java.util.Map;


public class Fotografia extends Pieza

{
	private String resolucion;
	private int tamanioGiga;
	
	


	


	public Fotografia(String titulo, String loginPropietarioActual, int anioCreacion, String lugarCreacion,
			ArrayList<String> autor, boolean disponible, int tiempoConsignacion, boolean subasta,
			ArrayList<Integer> valores, boolean bodega, String tipo,
			ArrayList<Map<String, String>> historialPropietarios, String resolucion, int tamanioGiga) {
		super(titulo, loginPropietarioActual, anioCreacion, lugarCreacion, autor, disponible, tiempoConsignacion,
				subasta, valores, bodega, tipo, historialPropietarios);
		this.resolucion = resolucion;
		this.tamanioGiga = tamanioGiga;
	}

	public String getResolucion() {
		return resolucion;
	}

	public int getTamanioGiga() {
		return tamanioGiga;
	}
	

	

	
	

}
