package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Persistencia.SubastaPersistencia;



public class Operador extends Usuario 

{
	
	private   ArrayList <String> idSubastas;



		
	





	public Operador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			ArrayList<String> idSubastas) {
		super(login, nombre, password, rol, telefono, verificado);
		this.idSubastas = idSubastas;
	}






	public static  void  registrarOferta(Oferta oferta1, ArrayList<Subasta> subastas, Galeria galeria, String fecha)
	{
		 for (Subasta subasta  : subastas)

		 {
			 List<Oferta> ofertas =subasta.getListaOfertas();
			 
			 for (Oferta oferta: ofertas)
			 {

				String nombrePieza=oferta.getNombrepiezaSubastada();
				String nombrePieza1=oferta1.getNombrepiezaSubastada();
				
				 if (nombrePieza== nombrePieza1)
				 {
					subasta.getListaOfertas().add(oferta1);
					SubastaPersistencia.registrarSubasta(subasta);
				 }

			if ( ofertas.size()==10)

			{
				ArrayList<Integer> valoresOfertados= new ArrayList<Integer>();
				for(Oferta oferta2 :ofertas)
				{
					valoresOfertados.add(oferta2.getValorOfertado());

					 
				}


				 Collections.sort(valoresOfertados, Collections.reverseOrder());
				 ArrayList<Oferta> ofertasOrdenadas= new ArrayList<Oferta>();
				 

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

					boolean aprobado= Administrador.aprobarVentaSubasta(mejoroferta, galeria, fecha);
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

