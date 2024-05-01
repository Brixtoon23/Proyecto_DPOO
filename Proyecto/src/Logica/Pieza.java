package Logica;

import java.util.ArrayList;
import java.util.List;

public abstract class Pieza
{
	
	protected String titulo;
	protected int anioCreacion;
	protected String  lugarCreacion;
	protected ArrayList<String> autor;
	protected  boolean  disponible;
	protected int tiempoConsignacion;
	protected boolean subasta;
	protected ArrayList<Integer> valores;
	protected String loginPropietario;
	protected boolean bodega;
	protected String tipo;
	public Pieza(String titulo, int anioCreacion, String lugarCreacion, ArrayList<String> autor, boolean disponible,
			int tiempoConsignacion, boolean subasta, ArrayList<Integer> valores, String loginPropietario, boolean bodega,String tipo) 
	{
		super();
		this.titulo = titulo;
		this.anioCreacion = anioCreacion;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.disponible = disponible;
		this.tiempoConsignacion = tiempoConsignacion;
		this.subasta = subasta;
		this.valores = valores;
		this.loginPropietario= loginPropietario;
		this.bodega = bodega;
		this.tipo = tipo;
	}
	public String getTitulo() 
	{
		return titulo;
	}
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public int getAnioCreacion() 
	{
		return anioCreacion;
	}
	public void setAnioCreacion(int anioCreacion) 
	{
		this.anioCreacion = anioCreacion;
	}
	public String getLugarCreacion() 
	{
		return lugarCreacion;
	}
	public void setLugarCreacion(String lugarCreacion) 
	{
		this.lugarCreacion = lugarCreacion;
	}
	public List<String> getAutor() 
	{
		return autor;
	}
	public void setAutor(ArrayList<String> autor) 
	{
		this.autor = autor;
	}
	public boolean isDisponible() 
	{
		return disponible;
	}
	public void setDisponoble(boolean disponible) 
	{
		this.disponible = disponible;
	}
	public int getTiempoConsignacion() 
	{
		return tiempoConsignacion;
	}
	public void setTiempoConsignacion(int tiempoConsignacion) 
	{
		this.tiempoConsignacion = tiempoConsignacion;
	}
	public boolean isSubasta() 
	{
		return subasta;
	}
	public void setSubasta(boolean subasta) 
	{
		this.subasta = subasta;
	}
	public List<Integer> getValores() 
	{
		return valores;
	}
	public void setValores(ArrayList<Integer> valores) 
	{
		this.valores = valores;
	}
	public String getLoginPropietario() 
	{
		return loginPropietario;
	}
	public void setLoginPropietario(String loginPropietario) 
	{
		this.loginPropietario = loginPropietario;
	}
	public boolean isBodega() 
	{
		return bodega;
	}
	public void setBodega(boolean bodega) 
	{
		this.bodega = bodega;
	}

	public String getTipo() 
	{
		return tipo;
	}
	
	
	
}
