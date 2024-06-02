package Logica;


import java.util.ArrayList;
import java.util.Map;





public class Galeria 
{
    private String nombre;
    private int cantidadObras;
    private Inventario inventario;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Subasta> subastas;
    private Map<String,ArrayList<String>> autores;
    private ArrayList<Historia> historias;
    


    public Galeria(String nombre, int cantidadObras, Inventario inventario, ArrayList<Usuario> usuarios, ArrayList<Subasta> subastas, Map<String,ArrayList<String>> autores,ArrayList<Historia> historias) 
    {
        this.nombre = nombre;
        this.cantidadObras = cantidadObras;
        this.inventario = inventario;
        this.usuarios = usuarios;
        this.subastas = subastas;
        this.autores = autores;
        this.historias = historias;

    }
    

    public int getCantidadObras() 
    {
        return cantidadObras;
    }

    public void setCantidadObras(int cantidadObras) 
    {
        this.cantidadObras = cantidadObras;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public Inventario getInventario() 
    {
        return inventario;
    }

    public ArrayList<Usuario> getUsuarios() 
    {
        return usuarios;
    }


    public ArrayList<Subasta> getSubastas() 
    {
        return subastas;
    }


    public Map<String,ArrayList<String>> getAutores() 
    {
        return autores;
    }


    public ArrayList<Historia> getHistorias() {
        return historias;
    }


    public void setHistorias(ArrayList<Historia> historias) {
        this.historias = historias;
    }

    
    


    

}