package Logica;


import java.util.ArrayList;





public class Galeria 
{
    private String nombre;
    private int cantidadObras;
    private Inventario inventario;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Subasta> subastas;
    


    public Galeria(String nombre, int cantidadObras, Inventario inventario, ArrayList<Usuario> usuarios, ArrayList<Subasta> subastas) 
    {
        this.nombre = nombre;
        this.cantidadObras = cantidadObras;
        this.inventario = inventario;
        this.usuarios = usuarios;
        this.subastas = subastas;

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
    


    

}