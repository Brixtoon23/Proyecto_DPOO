package Logica;

public class Oferta 
{
	private Pieza piezaSubastada;
	private Comprador comprador;
	private int valorOfertado;
	private Subasta subasta;
	private String id;
	private String metodoPago;
	public Oferta(Pieza piezaSubastada, Comprador comprador, int valorOfertado, Subasta subasta, String id,
			String metodoPago) {
		super();
		this.piezaSubastada = piezaSubastada;
		this.comprador = comprador;
		this.valorOfertado = valorOfertado;
		this.subasta = subasta;
		this.id = id;
		this.metodoPago = metodoPago;
	}
	public Pieza getPiezaSubastada() {
		return piezaSubastada;
	}
	public void setPiezaSubastada(Pieza piezaSubastada) {
		this.piezaSubastada = piezaSubastada;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public int getValorOfertado() {
		return valorOfertado;
	}
	public void setValorOfertado(int valorOfertado) {
		this.valorOfertado = valorOfertado;
	}
	public Subasta getSubasta() {
		return subasta;
	}
	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	
	
	
}
	
	
	