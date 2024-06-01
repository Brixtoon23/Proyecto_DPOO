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
    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<Transferencia> transferencias;

    


    public Galeria(String nombre, int cantidadObras, Inventario inventario, ArrayList<Usuario> usuarios, ArrayList<Subasta> subastas, Map<String,ArrayList<String>> autores ,ArrayList<Tarjeta> tarjetas, 
    ArrayList<Transferencia> transferencias)
 
    {
        this.nombre = nombre;
        this.cantidadObras = cantidadObras;
        this.inventario = inventario;
        this.usuarios = usuarios;
        this.subastas = subastas;
        this.autores = autores;
        this.tarjetas =  tarjetas;
        this.transferencias = transferencias;

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


    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }


    public ArrayList<Transferencia> getTransferencias() {
        return transferencias;
    }


    public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }


    public void setTransferencias(ArrayList<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }
    


    

}