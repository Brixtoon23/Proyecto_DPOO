package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Operador extends Usuario 
{
	
	public  static List <Subasta> subastas;

	

	public Operador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			List<Subasta> subastas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.subastas = new ArrayList<Subasta>();
		
	}
	
	
	



	public static List<Subasta> getSubastas() {
		return subastas;
	}

	
	public void  registrarOferta(Oferta oferta1,  List <Subasta> subastas)
	{
		 for (Subasta subasta  : subastas )
		 {
			 List<Oferta> ofertas =subasta.getOfertas();
			 
			 for (Oferta oferta: ofertas)
			 {
				 if (oferta.getPiezaSubastada()== oferta1.getPiezaSubastada())
				 {
					 ofertas.add(oferta1);
				 }
				 
			 }
		 }
		 
	}
		
	

	
	public static List<Oferta> mejoresOfertas(List<Subasta> subastas) 
	{
		HashMap<Pieza, Oferta> mejoresOfertasPorPieza = new HashMap<>();

       
        for (Subasta subasta : subastas)
        {
            List<Oferta> ofertas = subasta.getOfertas();

           
            for (Oferta oferta : ofertas)
            {
                Pieza pieza = oferta.getPiezaSubastada();
                float valorOfertado = oferta.getValorOfertado();

               
                if (!mejoresOfertasPorPieza.containsKey(pieza) || valorOfertado > mejoresOfertasPorPieza.get(pieza).getValorOfertado()) {
                    mejoresOfertasPorPieza.put(pieza, oferta);
                    
                   
                }
            }
             
        }

        
        List<Oferta> mejoresOfertas = new ArrayList<>(mejoresOfertasPorPieza.values());
        
        for (Oferta mejorOferta: mejoresOfertas)
        {
        	Pieza piezaCasivendida=mejorOferta.getPiezaSubastada();
        	piezaCasivendida.setDisponoble(false);
        }
        return mejoresOfertas;
    }
	
	
}

