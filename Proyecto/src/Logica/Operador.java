package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



public class Operador extends Usuario 
{
	
	private   ArrayList <String> idSubastas;



		
	public Operador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			ArrayList<String> idSubastas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.idSubastas = idSubastas;
	





	public static  void  registrarOferta(Oferta oferta1, List<Subasta> subastas, Galeria galeria)
	{
		 for (Subasta subasta  : subastas)

		 {
			 List<Oferta> ofertas =subasta.getListaOfertas();
			 
			 for (Oferta oferta: ofertas)
			 {
				 if (oferta.getPiezaSubastada()== oferta1.getPiezaSubastada())
				 {
					subasta.getListaOfertas().add(oferta1);
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






	public  ArrayList<String> getIdSubastas() {
		return idSubastas;
	}
	public void setIdSubastas(ArrayList<String> idSubastas) {
		this.idSubastas = idSubastas;
	}





	
	
	
}

