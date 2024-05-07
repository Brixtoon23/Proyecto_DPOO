package Logica;

import java.util.ArrayList;


public class Subasta
{
    private String id; 
    private ArrayList<Oferta> listaOfertas;
    private ArrayList<String> IdListaPiezasSubasta;



    public Subasta(String id, ArrayList<Oferta> listaOfertas, ArrayList<String> idListaPiezasSubasta) {
        this.id = id;
        this.listaOfertas = listaOfertas;
        IdListaPiezasSubasta = idListaPiezasSubasta;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public ArrayList<Oferta> getListaOfertas() {
        return listaOfertas;
    }



    public void setListaOfertas(ArrayList<Oferta> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }



    public ArrayList<String> getIdListaPiezasSubasta() {
        return IdListaPiezasSubasta;
    }



    public void setIdListaPiezasSubasta(ArrayList<String> idListaPiezasSubasta) {
        IdListaPiezasSubasta = idListaPiezasSubasta;
    }

    


    
   
}
