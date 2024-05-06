package Logica;

import java.util.ArrayList;
import java.util.List;

public class Pintura extends Pieza
{
	private int alto;
	private int ancho;
	private int peso;
	private String tecnica;
	
	
			
	

	public Pintura(String titulo, int anioCreacion, String lugarCreacion, ArrayList<String> autor, boolean disponible,
			int tiempoConsignacion, boolean subasta, ArrayList<Integer> valores,
			ArrayList<String> historialPropietarios, boolean bodega, String tipo, int alto, int ancho, int peso,
			String tecnica) {
		super(titulo, anioCreacion, lugarCreacion, autor, disponible, tiempoConsignacion, subasta, valores,
				historialPropietarios, bodega, tipo);
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
