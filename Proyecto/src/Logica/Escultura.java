package Logica;

import java.util.ArrayList;


public class Escultura extends Pieza
{
	private int alto;
	private int ancho;
	private int profundidad;
	private int peso;
	private boolean electricidad;
	

	


	public Escultura(String titulo, int anioCreacion, String lugarCreacion, ArrayList<String> autor, boolean disponible,
			int tiempoConsignacion, boolean subasta, ArrayList<Integer> valores, String loginPropietario,
			boolean bodega, String tipo, int alto, int ancho, int profundidad, int peso, boolean electricidad) {
		super(titulo, anioCreacion, lugarCreacion, autor, disponible, tiempoConsignacion, subasta, valores,
				loginPropietario, bodega, tipo);
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.peso = peso;
		this.electricidad = electricidad;
	}


	public int getAlto() {
		return alto;
	}


	public int getAncho() {
		return ancho;
	}


	public int getProfundidad() {
		return profundidad;
	}


	public int getPeso() {
		return peso;
	}


	public boolean isElectricidad() {
		return electricidad;
	}
	
	
	
	

}
