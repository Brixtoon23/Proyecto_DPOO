package Logica;

import java.util.ArrayList;
import java.util.List;

public class Subasta
{
    private int id; 
    private static List<Oferta> listaOfertas;
    private static  List<Pieza> listaPiezasSubasta;

    public Subasta(List<Pieza> listaPiezasSubasta) {
        this.listaOfertas = new ArrayList<>(); 
        this.listaPiezasSubasta =  new ArrayList<>();
    }

    

   
    public Subasta(int id, List<Oferta> listaOfertas, List<Pieza> listaPiezasSubasta) {
        this.id = id;
        this.listaOfertas = listaOfertas;
        this.listaPiezasSubasta = listaPiezasSubasta;
    }


    
    public List<Oferta> getOfertas() {
        return listaOfertas;
    }

   
    public List<Pieza> getPiezasSubastadas() {
        return listaPiezasSubasta;
    }




    public int getId() {
        return id;
    }
    
    

    
}
