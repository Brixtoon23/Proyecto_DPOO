package Logica;

public class Mensaje
 {
    private String nombrePieza;
    private boolean vendida;
    private String mensaj1;
    public Mensaje(String nombrePieza, boolean vendida , String mensaje1) 
    {
        this.nombrePieza = nombrePieza;
        this.vendida = vendida;
        this.mensaj1=mensaje1;
    }
    public String getNombrePieza() 
    {
        return nombrePieza;
    }
    public boolean isVendida() 
    {
        return vendida;
    }
    public String getMensaj1() 
    {
        return mensaj1;
    }
    



    

    
    
    



}
