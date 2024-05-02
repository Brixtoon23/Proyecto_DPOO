package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



public class Operador extends Usuario 
{
	
	private  static List <Subasta> subastas;

	

	public Operador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			List<Subasta> subastas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.subastas = new ArrayList<Subasta>();
		
	}
	
	
	

	public static  List<Subasta> getSubastas() {
		return subastas;
	}

	
	public  static void  registrarOferta(Oferta oferta1, List<Subasta> subastas, Galeria galeria)
	{
		 for (Subasta subasta  : subastas)

		 {
			 List<Oferta> ofertas =subasta.getOfertas();
			 
			 for (Oferta oferta: ofertas)
			 {
				 if (oferta.getPiezaSubastada()== oferta1.getPiezaSubastada())
				 {
					subasta.getOfertas().add(oferta1);
				 }

			if ( ofertas.size()==10)

			{
				List<Integer> valoresOfertados= new ArrayList<Integer>();
				for(Oferta oferta2 :ofertas)
				{
					valoresOfertados.add(oferta2.getValorOfertado());
					 
				}


				 Collections.sort(valoresOfertados, Collections.reverseOrder());
				 List<Oferta> ofertasOrdenadas= new ArrayList<Oferta>();
				 

				 for(int valor: valoresOfertados)
				 {
					for(Oferta oferta3: ofertas)
					{
						if (oferta3.getValorOfertado()==valor)
						{
							ofertasOrdenadas.add(oferta3);
						}

					}
				 }

				boolean flag=false;
				int i=0;

				 while (flag==false)
				 {
					Oferta mejoroferta =ofertasOrdenadas.get(i);

					boolean aprobado= Administrador.aprobarVentaSubasta(mejoroferta, galeria);
					if(aprobado== true)
					{
						flag=true;

					}

					i+=1;



				 }

				 if(flag==false)
				 {
					ofertas.clear();
				 }


				 }

			}

				
				 

			 }
		 }
		 
	
	
	
}

