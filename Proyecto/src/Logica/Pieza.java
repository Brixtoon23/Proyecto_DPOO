package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Pieza
{
	
	protected String titulo;
	protected String loginPropietarioActual;
	protected int anioCreacion;
	protected String  lugarCreacion;
	protected ArrayList<String> autor;
	protected boolean  disponible;
	protected int tiempoConsignacion;
	protected boolean subasta;
	protected ArrayList<Integer> valores;
	protected boolean bodega;
	protected String tipo;
	protected ArrayList<Map<String, String>> historialPropietarios;
	public Pieza(String titulo, String loginPropietarioActual, int anioCreacion, String lugarCreacion,
			ArrayList<String> autor, boolean disponible, int tiempoConsignacion, boolean subasta,
			ArrayList<Integer> valores, boolean bodega, String tipo,
			ArrayList<Map<String, String>> historialPropietarios) {
		this.titulo = titulo;
		this.loginPropietarioActual = loginPropietarioActual;
		this.anioCreacion = anioCreacion;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.disponible = disponible;
		this.tiempoConsignacion = tiempoConsignacion;
		this.subasta = subasta;
		this.valores = valores;
		this.bodega = bodega;
		this.tipo = tipo;
		this.historialPropietarios = historialPropietarios;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getLoginPropietarioActual() {
		return loginPropietarioActual;
	}
	public int getAnioCreacion() {
		return anioCreacion;
	}
	public String getLugarCreacion() {
		return lugarCreacion;
	}
	public ArrayList<String> getAutor() {
		return autor;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public int getTiempoConsignacion() {
		return tiempoConsignacion;
	}
	public boolean isSubasta() {
		return subasta;
	}
	public ArrayList<Integer> getValores() {
		return valores;
	}
	public boolean isBodega() {
		return bodega;
	}
	public String getTipo() {
		return tipo;
	}
	public ArrayList<Map<String, String>> getHistorialPropietarios() {
		return historialPropietarios;
	}

	

	

	
    
	
}