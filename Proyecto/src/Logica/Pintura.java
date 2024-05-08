package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pintura extends Pieza
{
	private int alto;
	private int ancho;
	private int peso;
	private String tecnica;
	
	
			
	

	

	

	public Pintura(String titulo, String loginPropietarioActual, int anioCreacion, String lugarCreacion,
			ArrayList<String> autor, boolean disponible, int tiempoConsignacion, boolean subasta,
			ArrayList<Integer> valores, boolean bodega, String tipo,
			ArrayList<Map<String, Object>> historialPropietarios, int alto, int ancho, int peso, String tecnica) {
		super(titulo, loginPropietarioActual, anioCreacion, lugarCreacion, autor, disponible, tiempoConsignacion,
				subasta, valores, bodega, tipo, historialPropietarios);
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.tecnica = tecnica;
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public int getPeso() {
		return peso;
	}

	public String getTecnica() {
		return tecnica;
	}
	
	
	

}
