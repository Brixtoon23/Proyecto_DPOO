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
    private ArrayList<Compra> compras;
    
    public Galeria(String nombre, int cantidadObras, Inventario inventario, ArrayList<Usuario> usuarios,
            ArrayList<Subasta> subastas, Map<String, ArrayList<String>> autores, ArrayList<Historia> historias,
            ArrayList<Compra> compras) {
        this.nombre = nombre;
        this.cantidadObras = cantidadObras;
        this.inventario = inventario;
        this.usuarios = usuarios;
        this.subastas = subastas;
        this.autores = autores;
        this.historias = historias;
        this.compras = compras;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidadObras() {
        return cantidadObras;
    }
    public void setCantidadObras(int cantidadObras) {
        this.cantidadObras = cantidadObras;
    }
    public Inventario getInventario() {
        return inventario;
    }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public ArrayList<Subasta> getSubastas() {
        return subastas;
    }
    public void setSubastas(ArrayList<Subasta> subastas) {
        this.subastas = subastas;
    }
    public Map<String, ArrayList<String>> getAutores() {
        return autores;
    }
    public void setAutores(Map<String, ArrayList<String>> autores) {
        this.autores = autores;
    }
    public ArrayList<Historia> getHistorias() {
        return historias;
    }
    public void setHistorias(ArrayList<Historia> historias) {
        this.historias = historias;
    }
    public ArrayList<Compra> getCompras() {
        return compras;
    }
    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    


   
    
    


    

}