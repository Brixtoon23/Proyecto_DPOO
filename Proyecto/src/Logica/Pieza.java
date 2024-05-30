package Logica;

import java.util.ArrayList;
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
	protected ArrayList<Map<String, Object>> historialPropietarios;
	protected String rutaImagen;

	public Pieza(String titulo, String loginPropietarioActual, int anioCreacion, String lugarCreacion,
			ArrayList<String> autor, boolean disponible, int tiempoConsignacion, boolean subasta,
			ArrayList<Integer> valores, boolean bodega, String tipo,
			ArrayList<Map<String, Object>> historialPropietarios, String rutaImagen) 
			{
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
		this.rutaImagen = rutaImagen;
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
	public ArrayList<Map<String, Object>> getHistorialPropietarios() {
		return historialPropietarios;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setLoginPropietarioActual(String loginPropietarioActual) {
		this.loginPropietarioActual = loginPropietarioActual;
	}
	public void setAnioCreacion(int anioCreacion) {
		this.anioCreacion = anioCreacion;
	}
	public void setLugarCreacion(String lugarCreacion) {
		this.lugarCreacion = lugarCreacion;
	}
	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public void setTiempoConsignacion(int tiempoConsignacion) {
		this.tiempoConsignacion = tiempoConsignacion;
	}
	public void setSubasta(boolean subasta) {
		this.subasta = subasta;
	}
	public void setValores(ArrayList<Integer> valores) {
		this.valores = valores;
	}
	public void setBodega(boolean bodega) {
		this.bodega = bodega;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setHistorialPropietarios(ArrayList<Map<String, Object>> historialPropietarios) {
		this.historialPropietarios = historialPropietarios;
	}

	public String getRutaImagen()
	{
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImg)
	{
		rutaImagen = rutaImg;
	}

}