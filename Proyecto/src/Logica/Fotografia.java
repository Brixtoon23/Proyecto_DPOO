package Logica;

import java.util.ArrayList;


public class Fotografia extends Pieza

{
	private String resolucion;
	private int tamanioGiga;
	
	

	

	

	public Fotografia(String titulo, int anioCreacion, String lugarCreacion, ArrayList<String> autor,
			boolean disponible, int tiempoConsignacion, boolean subasta, ArrayList<Integer> valores,
			ArrayList<String> historialPropietarios, boolean bodega, String tipo, String resolucion, int tamanioGiga) {
		super(titulo, anioCreacion, lugarCreacion, autor, disponible, tiempoConsignacion, subasta, valores,
				historialPropietarios, bodega, tipo);
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
