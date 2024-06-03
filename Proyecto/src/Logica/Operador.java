package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Persistencia.SubastaPersistencia;



public class Operador extends Usuario 

{
	
	private   ArrayList <String> idSubastas;



	public Operador(String login, String nombre, String password, String rol, String telefono, boolean verificado,
			ArrayList<String> arrayList) {
		super(login, nombre, password, rol, telefono, verificado);
		this.idSubastas = arrayList;
	}






	public static  void  registrarOferta(Oferta oferta1, ArrayList<Subasta> subastas, Galeria galeria, String fecha)
	{
		 for (Subasta subasta  : subastas)

		 {
			ArrayList<String> idPiezas =subasta.getIdListaPiezasSubasta();
			
			 for (String  idPieza : idPiezas )
			 {

				
				String nombrePieza1=oferta1.getNombrepiezaSubastada();
				
				 if (idPieza.equals(nombrePieza1))
				 {
					subasta.getListaOfertas().add(oferta1);

					SubastaPersistencia.registrarOferta(subasta);
				 }
				 

			ArrayList<Oferta> ListaOfertas= subasta.getListaOfertas();
			ArrayList<Oferta> ListaOfertasPieza= new ArrayList<>();

			for (Oferta oferta: ListaOfertas)
			{
				if (oferta.getNombrepiezaSubastada().equals(oferta1.getNombrepiezaSubastada()))
				{
					ListaOfertasPieza.add(oferta);
					
				}
			}



			 if ( ListaOfertasPieza.size()==5)

			{
				ArrayList<Integer> valoresOfertados= new ArrayList<Integer>();

				for(Oferta oferta2 :ListaOfertasPieza)
				{
					valoresOfertados.add(oferta2.getValorOfertado());
					 
				}


				 Collections.sort(valoresOfertados, Collections.reverseOrder());
				 ArrayList<Oferta> ofertasOrdenadas= new ArrayList<Oferta>();
				 

				 for(int valor: valoresOfertados)
				 {
					for(Oferta oferta3: ListaOfertasPieza)
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
					for( Oferta oferta4 : ListaOfertas)
					{
						if (oferta4.getNombrepiezaSubastada()== oferta1.getNombrepiezaSubastada())
						{
							ListaOfertas.remove(oferta4);
							
						}

					}

					subasta.setListaOfertas(ListaOfertasPieza);
					
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

