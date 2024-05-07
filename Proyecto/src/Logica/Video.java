package Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Video extends Pieza
{
	private int duracion;
	private int tamanioGiga;
	private String resolucion;


	

	

	

	public Video(String titulo, String loginPropietarioActual, int anioCreacion, String lugarCreacion,
			ArrayList<String> autor, boolean disponible, int tiempoConsignacion, boolean subasta,
			ArrayList<Integer> valores, boolean bodega, String tipo,
			ArrayList<Map<String, String>> historialPropietarios, int duracion, int tamanioGiga, String resolucion) {
		super(titulo, loginPropietarioActual, anioCreacion, lugarCreacion, autor, disponible, tiempoConsignacion,
				subasta, valores, bodega, tipo, historialPropietarios);
		this.duracion = duracion;
		this.tamanioGiga = tamanioGiga;
		this.resolucion = resolucion;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getTamanioGiga() {
		return tamanioGiga;
	}

	public String getResolucion() {
		return resolucion;
	}

	public boolean isDisponible() {
		
		return disponible;
	}

	
	

}
