package Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Video extends Pieza
{
	private int duracion;
	private int tamanioGiga;
	private String resolucion;


	public Video(String titulo, int anioCreacion, String lugarCreacion, ArrayList<String> autor, boolean disponible,
			int tiempoConsignacion, boolean subasta, ArrayList<Integer> valores, String loginPropietario,
			boolean bodega, String tipo, int duracion, int tamanioGiga, String resolucion) {
		super(titulo, anioCreacion, lugarCreacion, autor, disponible, tiempoConsignacion, subasta, valores,
				loginPropietario, bodega, tipo);
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
