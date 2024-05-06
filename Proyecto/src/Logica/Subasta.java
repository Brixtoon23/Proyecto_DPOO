package Logica;

import java.util.ArrayList;


public class Subasta
{
    private String id; 
    private ArrayList<Oferta> listaOfertas;
    private ArrayList<Pieza> listaPiezasSubasta;
    private ArrayList<Comprador> listaCompradores;
    public Subasta(String id, ArrayList<Oferta> listaOfertas, ArrayList<Pieza> listaPiezasSubasta,
            ArrayList<Comprador> listaCompradores) 
            {
        this.id = id;
        this.listaOfertas = listaOfertas;
        this.listaPiezasSubasta = listaPiezasSubasta;
        this.listaCompradores = listaCompradores;
    }
    public String getId() 
    {
        return id;
    }
    public ArrayList<Oferta> getListaOfertas() 
    {
        return listaOfertas;
    }
    public ArrayList<Pieza> getListaPiezasSubasta() 
    {
        return listaPiezasSubasta;
    }
    public ArrayList<Comprador> getListaCompradores() 
    {
        return listaCompradores;
    }
    public void setListaOfertas(ArrayList<Oferta> listaOfertas) 
    {
        this.listaOfertas = listaOfertas;
    }
    public void setListaPiezasSubasta(ArrayList<Pieza> listaPiezasSubasta) 
    {
        this.listaPiezasSubasta = listaPiezasSubasta;
    }
    public void setListaCompradores(ArrayList<Comprador> listaCompradores) 
    {
        this.listaCompradores = listaCompradores;
    }

    
    
    

    
}
